package com.posampas.bar.dto;

import lombok.Data;

import java.util.UUID;

public class PlaceOrderDto {
    private UUID billID;
    private UUID beverageID;

    public PlaceOrderDto() {

    }

    public PlaceOrderDto(UUID billID, UUID beverageID) {
        this.billID = billID;
        this.beverageID = beverageID;
    }

    public PlaceOrderDto( UUID beverageID) {
        billID = null;
        this.beverageID = beverageID;
    }

    public UUID getBillID() {
        return billID;
    }

    public UUID getBeverageID() {
        return beverageID;
    }
}
