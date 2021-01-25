package com.posampas.bar;

import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.entities.BeverageEntityRepository;

import java.util.*;

public class TestBeverageEntityRepository implements BeverageEntityRepository {
    private Map<UUID, BeverageEntity> entities = new HashMap<>();


    @Override
    public <S extends BeverageEntity> S save(S beverage) {
        entities.put(beverage.getBeverageId(), beverage);
        System.out.println(entities.get(beverage.getBeverageId()));
        return beverage;
    }

    @Override
    public <S extends BeverageEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<BeverageEntity> findById(UUID uuid) {
        return Optional.of(entities.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public Iterable<BeverageEntity> findAll() {
        List<BeverageEntity> list = new LinkedList<>(entities.values());
        return list;

    }

    @Override
    public Iterable<BeverageEntity> findAllById(Iterable<UUID> iterable) {
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
    public void delete(BeverageEntity beverageEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends BeverageEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
