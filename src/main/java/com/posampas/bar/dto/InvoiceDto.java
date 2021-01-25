package com.posampas.bar.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class InvoiceDto {
    private String nip;
    private String companyName;
    private UUID billID;
}
