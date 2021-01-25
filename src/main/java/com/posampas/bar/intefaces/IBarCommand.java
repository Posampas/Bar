package com.posampas.bar.intefaces;

import com.posampas.bar.entities.BeverageEntity;

import java.util.UUID;

public interface IBarCommand {

    void save(BeverageEntity beverageEntity);

    void deleteById(UUID beverageId);
}
