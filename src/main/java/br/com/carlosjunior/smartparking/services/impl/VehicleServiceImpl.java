package br.com.carlosjunior.smartparking.services.impl;

import br.com.carlosjunior.smartparking.dtos.VehicleCreateDTO;
import br.com.carlosjunior.smartparking.dtos.VehicleDTO;
import br.com.carlosjunior.smartparking.entities.Vehicle;
import br.com.carlosjunior.smartparking.enums.VehicleTypeEnum;
import br.com.carlosjunior.smartparking.exceptions.NotFoundException;
import br.com.carlosjunior.smartparking.repositories.VehicleRepository;
import br.com.carlosjunior.smartparking.services.VehicleService;
import br.com.carlosjunior.smartparking.utils.MessagesExceptions;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(VehicleRepository repository,
                              ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<VehicleDTO> findAllPaged(Pageable pageable) {
        Page<Vehicle> vehicles = repository.findAll(pageable);
        return vehicles.map(item -> modelMapper.map(item, VehicleDTO.class));
    }

    @Override
    public VehicleDTO findById(Long id) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(MessagesExceptions.FIELD_NOTFOUND, "Id")));
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    @Override
    public VehicleDTO findByLicensePlate(String licensePlate) {
        Vehicle vehicle = repository.findByLicensePlate(licensePlate);
        return vehicle != null ? modelMapper.map(vehicle, VehicleDTO.class) : null;
    }

    @Override
    public VehicleDTO create(VehicleCreateDTO newVehicle) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(newVehicle.getModel());
        vehicle.setLicensePlate(newVehicle.getLicensePlate());
        vehicle.setVehicleType(newVehicle.getVehicleType());
        return new VehicleDTO(repository.save(vehicle));
    }
}
