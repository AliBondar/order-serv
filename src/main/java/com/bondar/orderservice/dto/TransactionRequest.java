package com.bondar.orderservice.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionRequest implements Serializable {

    OrderDto orderDto;

    PaymentDto paymentDto;
}
