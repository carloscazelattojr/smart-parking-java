package br.com.carlosjunior.smartparking.controllers;

import br.com.carlosjunior.smartparking.dtos.ParkingValuesDTO;
import br.com.carlosjunior.smartparking.services.ParkingValuesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Parking Values Controller", description = "REST API for managing parking values")
@RestController
@RequestMapping("/parking-values")
@RequiredArgsConstructor
public class ParkingValuesController {

    private final ParkingValuesService service;

    @Operation(summary = "Get all parking values", description = "Retrieve a findAll parking values")
    @GetMapping
    public ResponseEntity<Page<ParkingValuesDTO>> findAllPaged(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(service.findAllPaged(pageable), OK);
    }

    @Operation(summary = "Get a parking values by ID", description = "Retrieve a specific parking values based on its ID")
    @GetMapping("/{id}")
    public ResponseEntity<ParkingValuesDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), OK);
    }

}
