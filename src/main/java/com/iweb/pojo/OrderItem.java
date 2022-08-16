package com.iweb.pojo;

import lombok.Data;

@Data
public class OrderItem {
    private int number;
    private Product product;
    private Order order;
    private User user;
    private int id;
}
