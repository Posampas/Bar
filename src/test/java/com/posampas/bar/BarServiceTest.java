package com.posampas.bar;

import com.posampas.bar.dto.InvoiceDto;
import com.posampas.bar.dto.PlaceOrderDto;
import com.posampas.bar.dvo.Invoice;
import com.posampas.bar.dvo.Recipe;
import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.entities.BillEntity;
import com.posampas.bar.facade.BarQuery;
import com.posampas.bar.facade.BarService;
import com.posampas.bar.facade.BillCommand;
import com.posampas.bar.facade.BillQuery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BarServiceTest {

    private BarService barService;
    private UUID wodkaId = UUID.randomUUID();
    private UUID beerId = UUID.randomUUID();
    private TestBeverageEntityRepository beverageEntityRepository;
    private TestBillEntityRepository billEntityRepository;

    @BeforeAll
    void setUp() {

        beverageEntityRepository = new TestBeverageEntityRepository();
        billEntityRepository = new TestBillEntityRepository();

        barService = new BarService(new BarQuery(beverageEntityRepository), new BillQuery(billEntityRepository), new BillCommand(billEntityRepository));

        BeverageEntity entity = new BeverageEntity(beerId, "Beer", new BigDecimal(5));
        beverageEntityRepository.save(entity);
        beverageEntityRepository.save(new BeverageEntity(wodkaId, "Wodka", new BigDecimal(15)));
        System.out.println(beverageEntityRepository.findById(wodkaId));

    }

    @Test
    void getMenu() {
        List<BeverageEntity> list = new LinkedList<>(barService.getMenu());

        assertEquals(2, list.size());

    }

    @Test
    void placeAnOrder() {

        PlaceOrderDto dtoWithoutBillId = new PlaceOrderDto(wodkaId);
        UUID billId = barService.placeAnOrder(dtoWithoutBillId);
        BillEntity bill = billEntityRepository.findById(billId).get();
        Assert.assertEquals(billId , bill.getBillID());
        Assert.assertEquals(wodkaId,bill.getBeverageList().get(0));


        PlaceOrderDto dto = new PlaceOrderDto(billId, wodkaId);
        barService.placeAnOrder(dto);
        barService.placeAnOrder(dto);
        bill = billEntityRepository.findById(billId).get();
        Assert.assertEquals(3,bill.getBeverageList().size());




    }

    @Test
    void printRecipe() {
        PlaceOrderDto dtoWithoutBillId = new PlaceOrderDto(beerId);
        UUID billId = barService.placeAnOrder(dtoWithoutBillId);
        PlaceOrderDto dto = new PlaceOrderDto(billId, wodkaId);
        barService.placeAnOrder(dto);
        barService.placeAnOrder(dto);

        Recipe recipe= barService.printRecipe(billId);
        Assert.assertEquals(new BigDecimal(35), recipe.getSum());
    }

    @Test
    void printInvoice() {

        PlaceOrderDto dtoWithoutBillId = new PlaceOrderDto(beerId);
        UUID billId = barService.placeAnOrder(dtoWithoutBillId);
        PlaceOrderDto dto = new PlaceOrderDto(billId, wodkaId);
        barService.placeAnOrder(dto);
        barService.placeAnOrder(dto);

        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setBillID(billId);
        invoiceDto.setCompanyName("Comany");
        invoiceDto.setNip("123412431243");

        Invoice invoice = barService.printInvoice(invoiceDto);
        System.out.println(invoice.getNIP());
        System.out.println(invoice);
        Assert.assertEquals(new BigDecimal(35), invoice.getSum());

    }
}