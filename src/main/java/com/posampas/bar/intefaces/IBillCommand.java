package com.posampas.bar.intefaces;

import com.posampas.bar.entities.BillEntity;

import java.util.UUID;

public interface IBillCommand {


    void save(BillEntity bill);

    void deleteById(UUID billId);

}
