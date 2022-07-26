package com.example.advancejavaassignmentfetchandsave.order.data.dto;

import lombok.Data;

@Data
public class OrderDetailsDto {
    private Long orderId;
    private Long userId;
    private Long skuId;
    private String skuName;
    private String rlpVat;
    private int quantity;
    private String transactionDate;
    private double grossAmount;
}
