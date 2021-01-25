package com.posampas.bar;

import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.entities.BillEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

class BillEntityTest {

    BillEntity bill = new BillEntity(UUID.randomUUID());

    private void setUp(){

    }

    @Test
    void addOrder() {
        bill.addOrder(new BeverageEntity(UUID.randomUUID(), "Piwo", new BigDecimal(5)));
        bill.close();
        bill.addOrder(new BeverageEntity(UUID.randomUUID(), "Piwo", new BigDecimal(5)));

        Assert.assertEquals(1, bill.getBeverageList().size());


    }
}