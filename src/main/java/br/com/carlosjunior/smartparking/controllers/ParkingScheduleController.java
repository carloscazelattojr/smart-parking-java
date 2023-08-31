package br.com.carlosjunior.smartparking.controllers;

import br.com.carlosjunior.smartparking.dtos.ParkingScheduleDTO;
import br.com.carlosjunior.smartparking.dtos.ParkingScheduleRegistryDTO;
import br.com.carlosjunior.smartparking.services.ParkingScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Parking Schedule Controller", description = "REST API for managing Schedule")
@RestController
@RequestMapping("/parking-schedule")
@RequiredArgsConstructor
public class ParkingScheduleController {

    private final ParkingScheduleService service;

    @Operation(summary = "Registry entry Parking Schedule", description = "Create registry entry parking")
    @PostMapping("/entry")
    public ResponseEntity<ParkingScheduleDTO> createParkingSchedule(@RequestBody ParkingScheduleRegistryDTO dto) {
        return new ResponseEntity<>(service.entryParking(dto), CREATED);
    }

    @Operation(summary = "Registry exit Parking Schedule", description = "update registry exit parking")
    @PutMapping("/exit")
    public ResponseEntity<ParkingScheduleDTO> updateParkingSchedule(@RequestBody ParkingScheduleRegistryDTO dto) {
        return new ResponseEntity<>(service.exitParking(dto), ACCEPTED);
    }


}
