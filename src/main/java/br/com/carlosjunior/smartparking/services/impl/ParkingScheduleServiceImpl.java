package br.com.carlosjunior.smartparking.services.impl;

import br.com.carlosjunior.smartparking.dtos.*;
import br.com.carlosjunior.smartparking.entities.ParkingSchedule;
import br.com.carlosjunior.smartparking.entities.ParkingValues;
import br.com.carlosjunior.smartparking.enums.StatusEnum;
import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import br.com.carlosjunior.smartparking.exceptions.BadRequestException;
import br.com.carlosjunior.smartparking.repositories.ParkingScheduleRepository;
import br.com.carlosjunior.smartparking.services.ParkingItemService;
import br.com.carlosjunior.smartparking.services.ParkingScheduleService;
import br.com.carlosjunior.smartparking.services.ParkingValuesService;
import br.com.carlosjunior.smartparking.services.VehicleService;
import br.com.carlosjunior.smartparking.utils.MessagesExceptions;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@Transactional
public class ParkingScheduleServiceImpl implements ParkingScheduleService {

    private final ParkingScheduleRepository repository;
    private final VehicleService vehicleService;
    private final ParkingItemService parkingItemService;
    private final ParkingValuesService parkingValuesService;

    public ParkingScheduleServiceImpl(ParkingScheduleRepository repository,
                                      VehicleService vehicleService,
                                      ParkingItemService parkingItemService,
                                      ParkingValuesService parkingValuesService) {
        this.repository = repository;
        this.vehicleService = vehicleService;
        this.parkingItemService = parkingItemService;
        this.parkingValuesService = parkingValuesService;
    }

    @Override
    public ParkingScheduleDTO entryParking(@Valid ParkingScheduleRegistryDTO dto) {

        dto.setVehicle(validateVehicle(dto.getVehicle()));

        ParkingItemDTO parkingItemDTO = validateParkingItem(dto.getIdParkingItem());

        StatusEnum status = parkingItemDTO.getStatus();
        if (status != StatusEnum.FREE)
            throw new BadRequestException(String.format(MessagesExceptions.PARKING_SPACE, status.name()));

        if (dto.getVehicle().getVehicleType() != parkingItemDTO.getParkingSpace().getVehicleType())
            throw new BadRequestException(MessagesExceptions.VEHICLE_NOT_COMPATIBLE_WITH_PARKING_SPACE);

        LocalDate entryDate = LocalDate.now();
        LocalTime entryTime = LocalTime.now();

        validateParkingScheduleInUse(dto.getIdParkingItem(), dto.getVehicle(), entryDate, entryTime);

        ParkingSchedule parkingSchedule = new ParkingSchedule();
        parkingSchedule.setParkingItem(parkingItemDTO.toEntity());

        parkingSchedule.setVehicle(dto.getVehicle().toEntity());
        parkingSchedule.setParkingValues(findParkingValues(dto.getVehicle().getVehicleType()));
        parkingSchedule.setEntryDate(entryDate);
        parkingSchedule.setEntryTime(entryTime);
        parkingSchedule.setStatus(StatusEnum.OCCUPIED);
        parkingSchedule = repository.save(parkingSchedule);

        changeStatusParkingSpace(parkingItemDTO.getParkingSpace().getIdParkingSpace(), StatusEnum.OCCUPIED);

        return new ParkingScheduleDTO(parkingSchedule);
    }

    private void changeStatusParkingSpace(Long idParkingSpace, StatusEnum statusEnum) {
        parkingItemService.changeStatusParkingItem(idParkingSpace, statusEnum);
    }

    @Override
    public ParkingScheduleDTO exitParking(ParkingScheduleRegistryDTO dto) {

        dto.setVehicle(validateVehicle(dto.getVehicle()));

        ParkingItemDTO parkingItemDTO = validateParkingItem(dto.getIdParkingItem());

        LocalDate exitDate = LocalDate.now();
        LocalTime exitTime = LocalTime.now();

        ParkingSchedule parkingSchedule = repository.findParkingScheduleExit(
                        parkingItemDTO.getIdParkingItem(), dto.getVehicle().getLicensePlate(), exitDate, exitTime)
                .orElseThrow(() -> new BadRequestException(String.format(MessagesExceptions.FIELD_NOTFOUND, "Parking Space")));

        if (parkingSchedule == null)
            throw new BadRequestException(String.format(MessagesExceptions.FIELD_NOTFOUND, "Parking Space Scheduler"));

        if (parkingSchedule.getStatus() != StatusEnum.OCCUPIED)
            throw new BadRequestException(String.format(MessagesExceptions.PARKING_SPACE, parkingSchedule.getStatus()));


        LocalDateTime entryDateTime = LocalDateTime.of(parkingSchedule.getEntryDate(), parkingSchedule.getEntryTime());
        LocalDateTime exitDateTime = LocalDateTime.of(exitDate, exitTime);
        Long minutes = Duration.between(entryDateTime, exitDateTime).toMinutes();
        Double valueUnitMinute = parkingSchedule.getParkingValues().getValueMinute();

        parkingSchedule.setExitDate(exitDate);
        parkingSchedule.setExitTime(exitTime);
        parkingSchedule.setDurationMinute(minutes);
        parkingSchedule.setTotalCost(minutes * valueUnitMinute);
        parkingSchedule.setStatus(StatusEnum.PAID);
        parkingSchedule = repository.save(parkingSchedule);

        changeStatusParkingSpace(parkingItemDTO.getParkingSpace().getIdParkingSpace(), StatusEnum.FREE);

        return new ParkingScheduleDTO(parkingSchedule);
    }

    private ParkingValues findParkingValues(VehicleTypeEnum vehicleType) {
        return parkingValuesService.findParkingValuesByVehicleType(vehicleType).toEntity();
    }

    private void validateParkingScheduleInUse(Long idParkingItem,
                                              VehicleDTO vehicle,
                                              LocalDate entryDate,
                                              LocalTime entryTime) {
        ParkingSchedule parkingSchedule = repository
                .findParkingSchedule(idParkingItem, vehicle.getLicensePlate(), entryDate, entryTime);

        if (parkingSchedule != null &&
                parkingSchedule.getStatus() == StatusEnum.OCCUPIED)
            throw new BadRequestException(MessagesExceptions.PARKING_SPACE_IN_USE);
    }

    private VehicleDTO validateVehicle(VehicleDTO dto) {
        VehicleDTO vehicleDTO = vehicleService.findByLicensePlate(dto.getLicensePlate());
        if (vehicleDTO == null)
            vehicleDTO = vehicleService.create(new VehicleCreateDTO(dto));
        return vehicleDTO;
    }

    private ParkingItemDTO validateParkingItem(Long idParkingItem) {
        if (idParkingItem == null)
            throw new BadRequestException(String.format(MessagesExceptions.FIELD_MANDATORY, "Id Parking Item"));
        return parkingItemService.findById(idParkingItem);
    }
}
