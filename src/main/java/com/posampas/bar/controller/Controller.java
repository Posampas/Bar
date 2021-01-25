package com.posampas.bar.controller;

import com.posampas.bar.dto.InvoiceDto;
import com.posampas.bar.dto.PlaceOrderDto;
import com.posampas.bar.dto.PrintBillDto;
import com.posampas.bar.dvo.Invoice;
import com.posampas.bar.dvo.Recipe;
import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.facade.BarFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class Controller {

    private final BarFacade facade;


    @GetMapping("/menu")
    public ResponseEntity<Collection<BeverageEntity>>getMenu(){
            Collection<BeverageEntity> list = facade.getMenu();

            return  new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<UUID> placeOrder(@RequestBody PlaceOrderDto dto){
         return new ResponseEntity<>( facade.placeAnOrder(dto), HttpStatus.OK);

    }

    @GetMapping("/recipePrint")
    public ResponseEntity<Recipe> getBill(@RequestBody PrintBillDto dto){
        return new ResponseEntity<>(facade.printRecipe(dto.getBillID()),HttpStatus.OK);
    }

    @GetMapping("/invoice")
    public ResponseEntity<Invoice> getInvoice(@RequestBody InvoiceDto dto){
        return new ResponseEntity<>(facade.printInvoice(dto),HttpStatus.OK);
    }



}
