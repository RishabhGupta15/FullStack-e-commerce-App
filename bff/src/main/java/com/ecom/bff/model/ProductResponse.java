package com.ecom.bff.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String pid;
    private String productName;
    private String productDescription;
    private double price;
    private int stockPresent;
}
