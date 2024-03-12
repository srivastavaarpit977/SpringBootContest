package com.cartservices.CartService;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cartservices.CartService.models.Cart;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}

    public List<Cart> getAllCart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCart'");
    }

    public Cart createCart(Object cart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCart'");
    }

    public Cart getSingleCart(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSingleCart'");
    }

    public void deleteCart(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCart'");
    }

    public List<String> getCategories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategories'");
    }

}
