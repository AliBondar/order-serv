package com.bondar.orderservice.service;

import com.bondar.orderservice.dto.PaymentDto;
import com.bondar.orderservice.dto.TransactionRequest;
import com.bondar.orderservice.dto.TransactionResponse;
import com.bondar.orderservice.entity.Order;
import com.bondar.orderservice.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderServiceImpl implements OrderService {

    @Value("${payment-service.path}")
    String path;

    @Value("${payment-service.method}")
    String method;

    final OrderRepository orderRepository;


    final RestTemplate restTemplate;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.restTemplate = new RestTemplate();
    }


    @Override
    public TransactionResponse saveOrder(TransactionRequest request) {
        return saveOrUpdateOrder(new Order(), request);
    }

    @Override
    public TransactionResponse saveOrUpdateOrder(Order order, TransactionRequest request) {
        String response;

        order.setName(request.getOrderDto().getName());
        order.setQuantity(request.getOrderDto().getQuantity());
        order.setPrice(request.getOrderDto().getPrice());

        PaymentDto paymentResponse = restTemplate.postForObject(String.format(path, method), request, PaymentDto.class);

        assert paymentResponse != null;
        response = paymentResponse.getStatus().equals("success")?"payment processing successful and order placed":"failed to pay, order has been added to cart";

        orderRepository.save(order);
        return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
    }

}
