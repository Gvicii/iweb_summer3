package com.iweb.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Product {
    private String name;
    private String subTitle;//
    private float originalPrice;
    private float promotePrice;
    private int stock;
    private Date createDate;
    private Category category;
    private int id;
    private int reviewCount;//评价数量
    private int saleCount;// 销量
    private List<ProductImage> images;
}
