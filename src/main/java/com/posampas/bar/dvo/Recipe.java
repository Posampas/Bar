package com.posampas.bar.dvo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Recipe {

    private BigDecimal sum;

    public Recipe(BigDecimal sum) {
        this.sum = sum;
    }


    public BigDecimal getSum() {
        return sum;
    }

    @Override
    public String toString() {
         return " To pay "  + sum.toString() + "\n"
                 + "Date :" + LocalDateTime.now();
    }
}
