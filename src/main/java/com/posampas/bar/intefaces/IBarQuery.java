package com.posampas.bar.intefaces;

import com.posampas.bar.entities.BeverageEntity;

import java.util.Optional;
import java.util.UUID;

public interface IBarQuery {
    Iterable<BeverageEntity> findAll();

    Optional<BeverageEntity>  findById(UUID id);
}
