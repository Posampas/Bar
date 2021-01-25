package com.posampas.bar.facade;

import com.posampas.bar.dto.InvoiceDto;
import com.posampas.bar.dto.PlaceOrderDto;
import com.posampas.bar.dvo.Invoice;
import com.posampas.bar.dvo.Recipe;
import com.posampas.bar.entities.BeverageEntity;
import com.posampas.bar.entities.BillEntity;
import com.posampas.bar.intefaces.IBarService;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.*;

@RequiredArgsConstructor
public class BarService implements IBarService {
    private final BarQuery barQueryRepository;
    private final BillQuery billQueryRepository;
    private final BillCommand billCommandRepository;

    @Override
    public Collection<BeverageEntity> getMenu() {

        LinkedList<BeverageEntity> list = new LinkedList<>();
        barQueryRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public UUID placeAnOrder(PlaceOrderDto dto) {
        if (dto.getBillID() == null) {
            BillEntity bill = new BillEntity(UUID.randomUUID());

            BeverageEntity beverage = getBeverageFromRepo(dto.getBeverageID());
            bill.addOrder(beverage);

            billCommandRepository.save(bill);
            return bill.getBillID();

        } else {
            BeverageEntity beverage = getBeverageFromRepo(dto.getBeverageID());
            BillEntity bill = getBillFromRepo(dto.getBillID());
            bill.addOrder(beverage);

            billCommandRepository.save(bill);
            return bill.getBillID();

        }

    }

    public Recipe printRecipe(UUID billId) {

        BillEntity bill = getBillFromRepo(billId);
        bill.close();
        return new Recipe(calcuateSum(bill));

    }

    @Override
    public Invoice printInvoice(InvoiceDto dto) {
        BillEntity bill = getBillFromRepo(dto.getBillID());
        bill.close();

        return new Invoice(dto.getNip(), dto.getCompanyName(),calcuateSum(bill));



    }

    private BigDecimal calcuateSum(BillEntity bill){
        Map<UUID, BigDecimal> priceMap = getPriceMap();

        BigDecimal sum = BigDecimal.ZERO;

        for (UUID id : bill.getBeverageList()) {
            sum = sum.add(priceMap.get(id));
        }

        return  sum;
    }


    private Map<UUID, BigDecimal> getPriceMap(){
        Map<UUID, BigDecimal> priceMap = new Hashtable<>();
        barQueryRepository.findAll().forEach(e -> {
            priceMap.put(e.getBeverageId(), e.getPrice());
        });

        return priceMap;
    }

    private BillEntity getBillFromRepo(UUID id) {
        return billQueryRepository.findById(id).orElseThrow((NullPointerException::new));
    }

    private BeverageEntity getBeverageFromRepo(UUID id) {
        return barQueryRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
