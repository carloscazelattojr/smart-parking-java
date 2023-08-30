package br.com.carlosjunior.smartparking.services.impl;

import br.com.carlosjunior.smartparking.dtos.ParkingValuesDTO;
import br.com.carlosjunior.smartparking.entities.ParkingValues;
import br.com.carlosjunior.smartparking.exceptions.NotFoundException;
import br.com.carlosjunior.smartparking.repositories.ParkingValuesRepository;
import br.com.carlosjunior.smartparking.services.ParkingValuesService;
import br.com.carlosjunior.smartparking.utils.MessagesExceptions;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ParkingValuesServiceImpl implements ParkingValuesService {

    private final ParkingValuesRepository repository;
    private final ModelMapper modelMapper;

    public ParkingValuesServiceImpl(ParkingValuesRepository repository,
                                    ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ParkingValuesDTO findById(Long id) {
        ParkingValues parkingSpace = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(MessagesExceptions.FIELD_NOTFOUND, "Id")));
        return modelMapper.map(parkingSpace, ParkingValuesDTO.class);
    }

    @Override
    public Page<ParkingValuesDTO> findAllPaged(Pageable pageable) {
        Page<ParkingValues> parkingSpaces = repository.findAll(pageable);
        return parkingSpaces.map(item -> modelMapper.map(item, ParkingValuesDTO.class));
    }
}
