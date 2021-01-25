package com.posampas.bar.entities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BeverageEntityRepository extends CrudRepository<BeverageEntity, UUID> {

    @Query("FROM Beverage")
    Iterable<BeverageEntity> findAll();
}
