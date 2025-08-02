package com.example.store.controller;

import com.example.store.entity.Cart;
import com.example.store.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestParam Long userId,
                                       @RequestParam Long productId,
                                       @RequestParam int quantity) {
        cartService.addItemToCart(userId, productId, quantity);
        return ResponseEntity.ok("Item added to cart!");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getUserCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getUserCart(userId));
    }
}
