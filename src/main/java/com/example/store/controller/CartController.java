package com.example.store.controller;

import com.example.store.entity.Cart;
import com.example.store.service.CartService;
import com.example.store.dto.CartItemRequest;
import com.example.store.security.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody CartItemRequest request, HttpServletRequest httpRequest) {
        String token = extractToken(httpRequest);
        String username = jwtUtil.extractUsername(token);

        Cart updatedCart = cartService.addItemByUsername(username, request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(updatedCart);
    }

    @GetMapping("/view")
    public ResponseEntity<Cart> viewCart(HttpServletRequest httpRequest) {
        String token = extractToken(httpRequest);
        String username = jwtUtil.extractUsername(token);

        Cart cart = cartService.getCartByUsername(username);
        return ResponseEntity.ok(cart);
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        return header != null && header.startsWith("Bearer ") ? header.substring(7) : null;
    }
}
