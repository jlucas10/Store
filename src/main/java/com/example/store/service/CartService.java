package com.example.store.service;

import com.example.store.entity.Cart;
import com.example.store.entity.CartItem;
import com.example.store.entity.User;
import com.example.store.entity.Product;
import com.example.store.repository.ProductRepository;
import com.example.store.repository.CartRepository;
import com.example.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;


    public Cart addItemByUsername(String email, Long productId, int quantity) {
        // Fetch the user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch the product by ID
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Get or create the user's cart
        Cart cart = cartRepository.findByUser(user)
                .orElse(new Cart(user));

        // Check if the product is already in the cart
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            cart.getItems().add(new CartItem(product, quantity));
        }

        return cartRepository.save(cart);
    }




    public Cart getCartByUsername(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) throw new RuntimeException("User not found");

        User user = optionalUser.get();
        return cartRepository.findByUser(user)
                .orElse(new Cart(user));
    }

}
