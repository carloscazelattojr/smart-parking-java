package br.com.carlosjunior.smartparking.services.impl;

import br.com.carlosjunior.smartparking.dtos.ParkingSpaceDTO;
import br.com.carlosjunior.smartparking.entities.ParkingSpace;
import br.com.carlosjunior.smartparking.exceptions.NotFoundException;
import br.com.carlosjunior.smartparking.repositories.ParkingSpaceRepository;
import br.com.carlosjunior.smartparking.services.ParkingService;
import br.com.carlosjunior.smartparking.utils.MessagesExceptions;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ParkingSpaceServiceImpl implements ParkingService {

    private final ParkingSpaceRepository repository;

    private final ModelMapper modelMapper;

    public ParkingSpaceServiceImpl(ParkingSpaceRepository repository,
                                   ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<ParkingSpaceDTO> findAllPaged(Pageable pageable) {
        Page<ParkingSpace> parkingSpaces = repository.findAll(pageable);
        return parkingSpaces.map(item -> modelMapper.map(parkingSpaces, ParkingSpaceDTO.class));
    }

    @Override
    public ParkingSpaceDTO findById(Long id) {
        ParkingSpace parkingSpace = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(MessagesExceptions.FIELD_NOTFOUND, "ID")));
        return modelMapper.map(parkingSpace, ParkingSpaceDTO.class);
    }

}
