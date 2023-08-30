package br.com.carlosjunior.smartparking.controllers;

import br.com.carlosjunior.smartparking.dtos.VehicleDTO;
import br.com.carlosjunior.smartparking.services.VehicleService;
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

@Tag(name = "Vehicle Controller", description = "REST API for managing vehicle")
@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @Operation(summary = "Get all vehicles", description = "Retrieve a findAll vehicles")
    @GetMapping
    public ResponseEntity<Page<VehicleDTO>> findAllPaged(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(service.findAllPaged(pageable), OK);
    }

    @Operation(summary = "Get a vehicle by ID", description = "Retrieve a specific vehicle based on its ID")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), OK);
    }

}
