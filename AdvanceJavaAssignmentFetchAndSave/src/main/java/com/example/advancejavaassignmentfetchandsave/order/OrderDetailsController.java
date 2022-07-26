package com.example.advancejavaassignmentfetchandsave.order;

import com.example.advancejavaassignmentfetchandsave.common.api.ResponseBody;
import com.example.advancejavaassignmentfetchandsave.order.data.dto.OrderDetailsDto;
import com.example.advancejavaassignmentfetchandsave.order.data.dto.OrderDetailsMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.advancejavaassignmentfetchandsave.common.errors.ErrorParser.getErrorMessage;
import static com.example.advancejavaassignmentfetchandsave.common.errors.ErrorParser.getErrorStatusCode;

@RestController
@RequestMapping(path = "/api/v1/orderDetails")
public class OrderDetailsController {
    private final OrderDetailsService service;
    private final OrderDetailsMapper orderDetailsMapper;

    public OrderDetailsController(OrderDetailsService service, OrderDetailsMapper orderDetailsMapper) {
        this.service = service;
        this.orderDetailsMapper = orderDetailsMapper;
    }

    @GetMapping
    public ResponseEntity<ResponseBody> getOrderDetails() {
        try {
            List<OrderDetailsDto> students = orderDetailsMapper.map(service.getOrderDetails());
            return ResponseEntity.ok(ResponseBody.builder()
                    .message("success")
                    .data(students)
                    .status(HttpStatus.OK.value())
                    .build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseBody.builder()
                    .message(getErrorMessage(e))
                    .data(null)
                    .status(getErrorStatusCode(e).value())
                    .build());
        }
    }
}
