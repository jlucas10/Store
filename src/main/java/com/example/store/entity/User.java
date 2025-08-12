package com.example.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;
}
