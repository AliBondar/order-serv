package com.bondar.orderservice.service;


import com.bondar.orderservice.dto.OrderDto;
import com.bondar.orderservice.dto.TransactionRequest;
import com.bondar.orderservice.dto.TransactionResponse;
import com.bondar.orderservice.entity.Order;

public interface OrderService {

    TransactionResponse saveOrder(TransactionRequest request);

    TransactionResponse saveOrUpdateOrder(Order order, TransactionRequest request);


}
