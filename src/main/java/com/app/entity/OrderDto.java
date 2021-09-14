package com.app.entity;

import lombok.Data;

@Data
public class OrderDto extends  Order {
    private long totalPrice;
}
