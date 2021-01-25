package com.posampas.bar.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "Beverage")
@Data
@NoArgsConstructor
public class BeverageEntity {



    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "uuid-char")
    @Column(name = "BEVERAGE_ID")
    private UUID beverageId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private BigDecimal price;



    public BeverageEntity(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
    public BeverageEntity(UUID id, String name, BigDecimal price) {
        this.beverageId = id;
        this.name = name;
        this.price = price;
    }

}
