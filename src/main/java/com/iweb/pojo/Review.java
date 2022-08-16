package com.iweb.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Review {
    private String content;
    private Date createDate;
    private User user;
    private Product product;
    private int id;
}
