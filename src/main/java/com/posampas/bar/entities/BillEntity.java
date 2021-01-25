package com.posampas.bar.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Bill")
@Data
@NoArgsConstructor
public class BillEntity {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "BILL_ID")
    private UUID billID;
    private boolean isOpen= true;


    @ElementCollection
    private List<UUID> beverageList = new LinkedList<>();

    public BillEntity(UUID billID) {
        this.billID = billID;
    }

    public void addOrder(BeverageEntity beverage) {
        if (isOpen) {
            beverageList.add(beverage.getBeverageId());
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillEntity)) return false;
        BillEntity that = (BillEntity) o;
        return billID.equals(that.billID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billID);
    }



    @Override
    public String toString() {
        return "BillEntity{" +
                "billID=" + billID +
                ", isOpen=" + isOpen +
                '}';
    }

    public void close() {
        isOpen = false;
    }
}
