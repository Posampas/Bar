package com.posampas.bar.dvo;

import java.math.BigDecimal;

public class Invoice {
    private String NIP;
    private String companyName;
    private BigDecimal sum;

    public Invoice(String nip, String companyName, BigDecimal sum) {
        this.NIP = nip;
        this.companyName = companyName;
        this.sum = sum;
    }


    public BigDecimal getSum() {
        return sum;
    }

    public String getNIP() {
        return NIP;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "INVOICE \n" +
                "Company: " + companyName + "\n" +
                "NIP: " + NIP + " \n" +
                " Total " + sum;
    }
}
