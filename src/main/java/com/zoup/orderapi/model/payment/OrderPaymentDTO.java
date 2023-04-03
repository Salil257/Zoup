package com.zoup.orderapi.model.payment;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderPaymentDTO {
    private String order_id;
    private double order_amount;
    private String order_currency;
    private String order_note;
    private CustomerDetailsDTO customer_details;
}
