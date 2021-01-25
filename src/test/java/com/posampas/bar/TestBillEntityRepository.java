package com.posampas.bar;

import com.posampas.bar.entities.BillEntity;
import com.posampas.bar.entities.BillEntityRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class TestBillEntityRepository implements BillEntityRepository {
    Map<UUID, BillEntity> entities = new HashMap<>();

    @Override
    public <S extends BillEntity> S save(S  bill) {
        entities.put(bill.getBillID(), bill);
        return bill;
    }

    @Override
    public <S extends BillEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<BillEntity> findById(UUID uuid) {
        return Optional.of(entities.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public Iterable<BillEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<BillEntity> findAllById(Iterable<UUID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(BillEntity billEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends BillEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
