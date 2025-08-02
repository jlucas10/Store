package com.example.store.service;

import com.example.store.entity.*;
import com.example.store.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepo;
    private final CartItemRepository itemRepo;
    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    public void addItemToCart(Long userId, Long productId, int quantity) {
        User user = userRepo.findById(userId).orElseThrow();
        Cart cart = cartRepo.findByUserId(userId).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(user);
            return cartRepo.save(newCart);
        });

        Product product = productRepo.findById(productId).orElseThrow();
        CartItem item = new CartItem(null, product, quantity, cart);
        itemRepo.save(item);
    }

    public Cart getUserCart(Long userId) {
        return cartRepo.findByUserId(userId).orElse(null);
    }
}
