package com.cartservices.CartService.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cartservices.CartService.Dtos.FakeStoreCartDto;
import com.cartservices.CartService.models.Category;

@Service
public class FakeStoreCartService implements CartService{
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<com.cartservices.CartService.models.Cart> getAllCart() {
        FakeStoreCartDto[] cartDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/services",
                FakeStoreCartDto[].class
        );

        if (cartDtos != null) {
            List<Cart> services = new ArrayList<>();
            for (FakeStoreCartDto dto : cartDtos) {
                Cart cart = new Cart();
                Cart.setId(dto.getId());
                Cart.setTitle(dto.getTitle());
                Cart.setPrice(dto.getPrice());
                Cart.setImageUrl(dto.getImage());
                Cart.setDescription(dto.getDescription());
                Category category = new Category();
                category.setName(dto.getCategory());
                Cart.setCategory(category);
                services.add(cart);
            }
            return services;
        }
        return null;
    }

    @Override
    public com.cartservices.CartService.models.Cart getSingleCart(Long id) {
        FakeStoreCartDto fakeStoreCartDto = restTemplate.getForObject(
            "https://fakestoreapi.com/services/" + id,
            FakeStoreCartDto.class
        );

        Cart cart = new Cart();
        Cart.setId(fakeStoreCartDto.getId());
        Cart.setTitle(fakeStoreCartDto.getTitle());
        Cart.setPrice(fakeStoreCartDto.getPrice());
        Cart.setImageUrl(fakeStoreCartDto.getImage());
        Cart.setDescription(fakeStoreCartDto.getDescription());
        Cart.setCategory(new Category());
        Cart.getCategory().setName(fakeStoreCartDto.getCategory());

        com.cartservices.CartService.models.Cart product;
        return cart;
    }

    @Override
    public Cart createCart(Cart cart) {
        //update product to fakestoreapi
        //https://fakestoreapi.com/services/id

        FakeStoreCartDto fakeStoreProductDto = new FakeStoreCartDto();
        FakeStoreCartDto fakeStoreCartDto;
        fakeStoreCartDto.setId(cart.getId());
        fakeStoreCartDto.setTitle(cart.getTitle());
        fakeStoreCartDto.setPrice(cart.getPrice());
        fakeStoreCartDto.setImage(cart.getImageUrl());
        fakeStoreCartDto.setDescription(cart.getDescription());
        fakeStoreCartDto.setCategory(Cart.getCategory().getName());

        restTemplate.postForObject(
                "https://fakestoreapi.com/services",
                fakeStoreCartDto,
                FakeStoreCartDto.class
        );
        return null;
    }

    @Override
    public Cart updateCart(Cart cart) {

        //update product to fakestoreapi

        FakeStoreCartDto fakeStoreProductDto = new FakeStoreCartDto();
        FakeStoreCartDto fakeStoreCartDto;
        FakeStoreCartDto Cart;
        fakeStoreCartDto.setId(cart.getId());
        fakeStoreCartDto.setTitle(cart.getTitle());
        fakeStoreCartDto.setPrice(cart.getPrice());
        fakeStoreCartDto.setImage(cart.getId());
        fakeStoreCartDto.setDescription(cart.getDescription());
        fakeStoreCartDto.setCategory(cart.getCategory().getName());

        Object fakeStoreCartDto;
        restTemplate.put(
                "https://fakestoreapi.com/services/" + cart.getId(),
                fakeStoreCartDto
        );

        return cart;

    }

    @Override
    public void deleteCart(Long id) {

        restTemplate.delete("https://fakestoreapi.com/services/" + id);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<com.cartservices.CartService.models.Cart> getCartByCategory(String categoryName) {

        //'https://fakestoreapi.com/services/category/jewelery'
        FakeStoreCartDto[] cartDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/services/category/" + categoryName,
                FakeStoreCartDto[].class
        );

        Object CartDtos;
        if (CartDtos != null) {
            List<com.cartservices.CartService.models.Cart> services = new ArrayList<>();
            for (FakeStoreCartDto dto : (Collection<FakeStoreCartDto>) cartDtos){
                Cart cart = new Cart();
                Cart.setId(dto.getId());
                Cart.setTitle(dto.getTitle());
                Cart.setPrice(dto.getPrice());
                Cart.setImageUrl(dto.getImage());
                Cart.setDescription(dto.getDescription());
                Category category = new Category();
                category.setName(dto.getCategory());
                Cart.setCategory(category);
                services.addAll((Collection<? extends com.cartservices.CartService.models.Cart>) cart);
            }
            return services;
        }

        return null;


    }

    @Override
    public List<String> getCategories() {
        //https://fakestoreapi.com/services/categories
        String[] categories = restTemplate.getForObject(
                "https://fakestoreapi.com/services/categories",
                String[].class
        );

        if (categories != null) {
            List<String> categoryList = new ArrayList<>();
            for (String category : categories) {
                categoryList.add(category);
            }
            return categoryList;
        }
        return null;

    }

    @Override
    public com.cartservices.CartService.models.Cart createCart(com.cartservices.CartService.models.Cart cart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCart'");
    }

    @Override
    public com.cartservices.CartService.models.Cart updateCart(com.cartservices.CartService.models.Cart cart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCart'");
    }


}