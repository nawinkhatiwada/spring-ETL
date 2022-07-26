package com.example.advancejavaassignmentfetchandsave.order.data.dto;

import com.example.advancejavaassignmentfetchandsave.order.data.entity.OrderDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderDetailsMapper {
    List<OrderDetailsDto> map(List<OrderDetails> type);
    OrderDetailsDto map(OrderDetails type);
}
