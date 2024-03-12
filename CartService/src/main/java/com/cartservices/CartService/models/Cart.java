package com.cartservices.CartService.models;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Cart {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    private Category category;
}
