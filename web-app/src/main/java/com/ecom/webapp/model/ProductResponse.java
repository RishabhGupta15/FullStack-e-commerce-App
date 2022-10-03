package com.ecom.webapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {
    private String pId;
    private String productName;
    private String productDescription;
    private double price;
    private int stockPresent;
}
