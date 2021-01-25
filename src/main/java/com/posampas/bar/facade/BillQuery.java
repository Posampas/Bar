package com.posampas.bar.facade;

import com.posampas.bar.entities.BillEntity;
import com.posampas.bar.entities.BillEntityRepository;
import com.posampas.bar.intefaces.IBillQuery;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class BillQuery implements IBillQuery {

    private final BillEntityRepository repository;

    @Override
    public Optional<BillEntity> findById(UUID id) {
        return  repository.findById(id);
    }

    @Override
    public Iterable<BillEntity> findAll() {
        return repository.findAll();
    }
}
