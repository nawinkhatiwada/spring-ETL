package com.example.advancejavaassignmentfetchandsave.order.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class OrderDetailIds implements Serializable {
    private Long userId;
    private Long orderId;
    private Long skuId;
}
