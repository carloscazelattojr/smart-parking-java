package br.com.carlosjunior.smartparking.controllers;

import br.com.carlosjunior.smartparking.entities.ParkingSchedule;
import br.com.carlosjunior.smartparking.services.ParkingScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Parking Schedule Controller", description = "REST API for managing Schedule")
@RestController
@RequestMapping("/parking-schedule")
@RequiredArgsConstructor
public class ParkingScheduleController {

    private final ParkingScheduleService service;

}
