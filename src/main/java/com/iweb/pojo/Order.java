package com.iweb.pojo;


import com.iweb.dao.OrderDAO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private String orderCode;
    private String address;
    private String post;
    private String receiver;
    private String mobile;
    private String userMessage;
    private Date createDate;
    private Date payDate;
    private Date deliveryDate;
    private Date confirmDate;
    private User user;
    private int id;
    public String getStatusDesc(){
        String desc = "未知";
        switch (status){
            case OrderDAO.waitPay:
                desc = "待付款";
                break;
            case OrderDAO.waitDelivery:
                desc = "待发货";
                break;
            case OrderDAO.waitConfirm:
                desc = "待收货";
                break;
            case OrderDAO.waitReview:
                desc = "待评价";
                break;
            case OrderDAO.finish:
                desc = "完成";
                break;
            case OrderDAO.delete:
                desc = "删除";
                break;
            default:
                desc = "未知";
        }
        return desc;
    }

    //每一个订单所对应的订单项集合
    private List<OrderItem> orderItems;
    //订单的总计金额
    private float total;
    //订单的商品总数量
    private int totalNumber;
    //订单状态
    private String status;
}
