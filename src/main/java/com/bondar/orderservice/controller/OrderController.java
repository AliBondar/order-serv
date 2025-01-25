package com.bondar.orderservice.controller;

import com.bondar.orderservice.dto.OrderRequestDto;
import com.bondar.orderservice.entity.Order;
import com.bondar.orderservice.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/saveOrder")
    public ResponseEntity<?> bookOrder(@RequestBody OrderRequestDto dto) {
        Order persistedOrder = orderService.saveOrder(dto);
        if (persistedOrder != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(persistedOrder);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
