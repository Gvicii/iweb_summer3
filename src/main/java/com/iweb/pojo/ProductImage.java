package com.iweb.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GUAN
 * @date 2022/8/15 13:54
 */
@Data
@NoArgsConstructor
public class ProductImage {
    private int id;
    private String url;
    private Product p;
}
