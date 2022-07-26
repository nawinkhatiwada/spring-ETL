package com.example.advancejavaassignmentfetchandsave.order.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@IdClass(OrderDetailIds.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderDetails {
    @Id
    private Long userId;
    @Id
    private Long orderId;
    @Id
    private Long skuId;
    private Long invoiceId;
    private String transactionDate;
    private String skuName;
    private Double rlp;
    private Double rlpVat;
    private int quantity;
    private double grossAmount;
    private String fullName;
}
