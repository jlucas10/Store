package com.example.store.config;

import com.example.store.entity.Product;
import com.example.store.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner initDatabase(ProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.saveAll(List.of(
                        new Product("Asics Running shoes", "Lightweight, breathable shoes designed for comfort and performance. Made from recycled materials.", 89.99, "https://images.unsplash.com/photo-1597892657493-6847b9640bac?q=80&w=774&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
                        new Product("Nike Volt Surge", "A bold neon green shoes featuring a lightweight mesh upper, cushioned sole, and sleek black accents.", 109.99, "https://images.unsplash.com/photo-1606107557195-0e29a4b5b4aa?q=80&w=2400&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
                        new Product("Nike Phantom Glide", "A sleek white sneaker crafted for all-day comfort and performance. With a breathable mesh upper, responsive cushioning, and a bold black swoosh.", 159.99, "https://images.unsplash.com/photo-1675762647949-1b25f669a687?q=80&w=774&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                ));
            }
        };
    }
}
