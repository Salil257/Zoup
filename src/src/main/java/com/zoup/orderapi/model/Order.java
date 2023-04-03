package com.zoup.orderapi.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "order")
public class Order {
    @Id
    private String orderId;
    private String restaurantId;
    private String restaurantName;
    private Long orderDateTime;
    private float netAmount;
    private float totalAmount;
    private Customer customerDetails;
    private List<Dish> dishes;
    private String orderStatus;
    private float taxes;
    private VehicleDetails vehicleDetails;

}
