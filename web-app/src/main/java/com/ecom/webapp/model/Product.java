package com.ecom.webapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "should not be null")
    @Size(min = 4, max = 6, message = "enter at least 4 and at max 6 character")
    @Column(name = "pid")
    private String pID;

    @NotNull(message = "should not be null")
    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name="price")
    private double price;

    @Column(name="stock_present")
    private int stockPresent;
}
