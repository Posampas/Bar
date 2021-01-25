package com.posampas.bar.intefaces;

import com.posampas.bar.entities.BillEntity;

import java.util.Optional;
import java.util.UUID;

public interface IBillQuery {
    Optional<BillEntity> findById(UUID id);

    Iterable<BillEntity> findAll();
}
