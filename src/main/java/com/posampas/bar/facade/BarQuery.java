package com.posampas.bar.facade;

import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.entities.BeverageEntityRepository;
import com.posampas.bar.intefaces.IBarQuery;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class BarQuery implements IBarQuery {

    private final BeverageEntityRepository repository;

    @Override
    public Iterable<BeverageEntity> findAll() {
       return repository.findAll();
    }

    @Override
    public Optional<BeverageEntity> findById(UUID id) {
        return repository.findById(id);
    }
}
