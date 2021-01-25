package com.posampas.bar.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BillEntityRepository extends CrudRepository<BillEntity, UUID> {
}
