package com.cartservices.CartService.Services;

import java.util.List;

import com.cartservices.CartService.models.Cart;

public interface CartService {
    List<Cart> getAllCart();

    Cart getSingleCart(Long id);

    Cart createCart(Cart cart);

    Cart updateCart(Cart cart);
    void deleteCart(Long id);
    List<Cart> getCartByCategory(String categoryName);
    List<String> getCategories();


}

    
