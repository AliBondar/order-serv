package com.bondar.orderservice.service;

import com.bondar.orderservice.dto.OrderRequestDto;
import com.bondar.orderservice.entity.Order;
import com.bondar.orderservice.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderServiceImpl implements OrderService {

    final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(OrderRequestDto dto) {
            return saveOrUpdateOrder(new Order(), dto);
    }

    @Override
    public Order saveOrUpdateOrder(Order order, OrderRequestDto dto) {
        order.setName(dto.getName());
        order.setQuantity(dto.getQuantity());
        order.setPrice(dto.getPrice());
        return orderRepository.save(order);
    }

}
