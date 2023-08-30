package br.com.carlosjunior.smartparking.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<ID, T> {
    T findById(ID id);

    Page<T> findAllPaged(Pageable pageable);

}