package com.posampas.bar.facade;

import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.entities.BeverageEntityRepository;
import com.posampas.bar.intefaces.IBarCommand;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class BarCommand implements IBarCommand {

    private  final BeverageEntityRepository repository;

    @Override
    public void save(BeverageEntity beverageEntity) {
        repository.save(beverageEntity);
    }

    @Override
    public void deleteById(UUID beverageId) {
        repository.deleteById(beverageId);
    }
}
