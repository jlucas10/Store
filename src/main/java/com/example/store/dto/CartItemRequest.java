package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItemRequest {
    private Long productId;
    private int quantity;

    public CartItemRequest() {}

}
