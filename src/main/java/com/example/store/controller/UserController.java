package com.example.store.controller;

import com.example.store.entity.User;
import com.example.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        String email = authentication.getName(); // Extracted from JWT
        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }

        return ResponseEntity.ok(user);
    }
}
