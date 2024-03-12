package com.cartservices.CartService.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCartDto {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;
}