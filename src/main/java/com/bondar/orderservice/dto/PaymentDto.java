package com.bondar.orderservice.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentDto implements Serializable {

    Long paymentId;

    String status;

    String transactionId;

    Long orderId;

    double amount;
}
