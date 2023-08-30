package br.com.carlosjunior.smartparking.services.impl;

import br.com.carlosjunior.smartparking.dtos.ParkingDTO;
import br.com.carlosjunior.smartparking.dtos.ParkingSpaceDTO;
import br.com.carlosjunior.smartparking.entities.Parking;
import br.com.carlosjunior.smartparking.entities.ParkingSpace;
import br.com.carlosjunior.smartparking.exceptions.NotFoundException;
import br.com.carlosjunior.smartparking.repositories.ParkingRepository;
import br.com.carlosjunior.smartparking.services.ParkingService;
import br.com.carlosjunior.smartparking.utils.MessagesExceptions;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository repository;
    private final ModelMapper modelMapper;

    public ParkingServiceImpl(ParkingRepository repository,
                              ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ParkingDTO findById(Long id) {
        Parking parking = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(MessagesExceptions.FIELD_NOTFOUND, "Id")));
        return modelMapper.map(parking, ParkingDTO.class);
    }
}
