package com.bondar.orderservice.service;


import com.bondar.orderservice.dto.OrderRequestDto;
import com.bondar.orderservice.entity.Order;

public interface OrderService {

    Order saveOrder(OrderRequestDto dto);

    Order saveOrUpdateOrder(Order order, OrderRequestDto dto);


}
