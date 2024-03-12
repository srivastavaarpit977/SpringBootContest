package com.cartservices.CartService.Controller;

import java.util.List;

// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartservices.CartService.CartServiceApplication;
import com.cartservices.CartService.models.Cart;
import com.cartservices.CartService.models.Category;

@RestController
public class CartServiceController {
    private CartServiceApplication CartService;
    public CartServiceController(CartServiceApplication CartService) {
        this.CartService = CartService;
    }
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World";
    }
    @GetMapping("/services")
    public List<Cart> getAllCart() {
        return CartService.getAllCart();
    }
    
    @PostMapping("/services")
    public Cart createCart(@RequestBody Cart product) {
        Cart cart = new Cart(); // Initialize the cart variable
        return CartService.createCart(cart);
    }

    @GetMapping("/services/{id}")
    public Cart getSingleCart(@PathVariable("id") Long id) {
        return CartService.getSingleCart(id);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/services/category/{categoryName}")
    public List<Cart> getCartByCategory(@PathVariable String categoryName) {
        Cart cart = new Cart();
        Category category = new Category(); // Create a Category object with the categoryName
        cart.setCategory(category); // Pass the Category object to the setCategory method
        return (List<Cart>) cart.getCategory();
    }
    
}

