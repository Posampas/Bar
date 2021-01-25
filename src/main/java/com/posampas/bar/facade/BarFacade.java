package com.posampas.bar.facade;

import com.posampas.bar.dto.InvoiceDto;
import com.posampas.bar.dto.PlaceOrderDto;
import com.posampas.bar.dvo.Invoice;
import com.posampas.bar.dvo.Recipe;
import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.intefaces.IBarService;

import java.util.Collection;
import java.util.UUID;

public class BarFacade {
    private final IBarService barService;

    public BarFacade(IBarService barService) {
        this.barService = barService;
    }

    public Collection<BeverageEntity> getMenu() {
        return barService.getMenu();
    }


    public UUID placeAnOrder(PlaceOrderDto dto) {
        return barService.placeAnOrder(dto);

    }


    public Recipe printRecipe(UUID billId) {
        return barService.printRecipe(billId);
    }

    public Invoice printInvoice(InvoiceDto dto) {
        return barService.printInvoice(dto);
    }


}
