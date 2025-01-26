package com.bondar.orderservice.dto;

import com.bondar.orderservice.entity.Order;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionResponse {

    Order order;
    String transactionId;
    double amount;
    String message;
}
