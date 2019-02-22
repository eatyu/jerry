package com.inter.order.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderDto {
    private BigInteger orderId;
    private String name;
    private int price;
    private int actualMoney;
}
