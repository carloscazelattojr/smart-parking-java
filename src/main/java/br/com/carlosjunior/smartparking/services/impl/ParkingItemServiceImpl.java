package br.com.carlosjunior.smartparking.services.impl;

import br.com.carlosjunior.smartparking.dtos.ParkingItemDTO;
import br.com.carlosjunior.smartparking.entities.ParkingItem;
import br.com.carlosjunior.smartparking.enums.StatusEnum;
import br.com.carlosjunior.smartparking.exceptions.NotFoundException;
import br.com.carlosjunior.smartparking.repositories.ParkingItemRepository;
import br.com.carlosjunior.smartparking.services.ParkingItemService;
import br.com.carlosjunior.smartparking.utils.MessagesExceptions;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ParkingItemServiceImpl implements ParkingItemService {

    private final ParkingItemRepository repository;
    private final ModelMapper modelMapper;

    public ParkingItemServiceImpl(ParkingItemRepository repository,
                                  ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ParkingItemDTO findById(Long id) {
        ParkingItem parkingItem = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(MessagesExceptions.FIELD_NOTFOUND, "Id")));
        return new ParkingItemDTO(parkingItem);
    }

    @Override
    public Page<ParkingItemDTO> findAllPaged(Pageable pageable) {
        Page<ParkingItem> parkingItem = repository.findAll(pageable);
        return parkingItem.map(item -> modelMapper.map(item, ParkingItemDTO.class));
    }

    @Override
    public ParkingItemDTO changeStatusParkingItem(Long id, StatusEnum status) {
        ParkingItem parkingItem = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(MessagesExceptions.FIELD_NOTFOUND, "Id")));
        parkingItem.setStatus(status);
        return new ParkingItemDTO(repository.save(parkingItem));
    }
}
