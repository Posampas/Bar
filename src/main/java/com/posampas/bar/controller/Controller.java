package com.posampas.bar.controller;

import com.posampas.bar.dto.InvoiceDto;
import com.posampas.bar.dto.PlaceOrderDto;
import com.posampas.bar.dto.PrintBillDto;
import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.facade.BarFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class Controller {

    private final BarFacade facade;


    @GetMapping("/menu")
    public Collection<BeverageEntity> getMenu(){
            return facade.getMenu();

    }

    @PostMapping("/order")
    public UUID placeOrder(@RequestBody PlaceOrderDto dto){
         return facade.placeAnOrder(dto);

    }

    @GetMapping("/recipePrint")
    public String getBill(@RequestBody PrintBillDto dto){
        return facade.printRecipe(dto.getBillID()).toString();
    }

    @GetMapping("/invoice")
    public String getInvoice(@RequestBody InvoiceDto dto){
        return facade.printInvoice(dto).toString();
    }



}
