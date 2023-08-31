package br.com.carlosjunior.smartparking.services;

import br.com.carlosjunior.smartparking.dtos.ParkingItemDTO;
import br.com.carlosjunior.smartparking.enums.StatusEnum;
import br.com.carlosjunior.smartparking.utils.BaseService;

public interface ParkingItemService extends BaseService<Long, ParkingItemDTO> {

    ParkingItemDTO changeStatusParkingItem(Long idParkingItem, StatusEnum status);

}
