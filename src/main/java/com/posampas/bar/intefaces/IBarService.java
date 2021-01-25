package com.posampas.bar.intefaces;

import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.dvo.Invoice;
import com.posampas.bar.dvo.Recipe;
import com.posampas.bar.dto.InvoiceDto;
import com.posampas.bar.dto.PlaceOrderDto;

import java.util.Collection;
import java.util.UUID;

public interface IBarService {
    Collection<BeverageEntity> getMenu();

    UUID placeAnOrder(PlaceOrderDto dto);

    Recipe printRecipe(UUID billId);

    Invoice printInvoice(InvoiceDto dto);
}
