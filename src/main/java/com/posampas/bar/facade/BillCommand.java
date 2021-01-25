package com.posampas.bar.facade;


import com.posampas.bar.entities.BillEntity;
import com.posampas.bar.entities.BillEntityRepository;
import com.posampas.bar.intefaces.IBillCommand;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class BillCommand implements IBillCommand {
    public final BillEntityRepository repository;

    @Override
    public void save(BillEntity bill) {
        repository.save(bill);
    }

    @Override
    public void deleteById(UUID billId) {
        repository.deleteById(billId);
    }
}
