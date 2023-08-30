package br.com.carlosjunior.smartparking.controllers;

import br.com.carlosjunior.smartparking.dtos.ParkingDTO;
import br.com.carlosjunior.smartparking.dtos.ParkingSpaceDTO;
import br.com.carlosjunior.smartparking.services.ParkingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Parking Controller", description = "REST API for managing parking")
@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService service;

    @Operation(summary = "Get a parking by ID", description = "Retrieve a specific parking based on its ID")
    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), OK);
    }

}
