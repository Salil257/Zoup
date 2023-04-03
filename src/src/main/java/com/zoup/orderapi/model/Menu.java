package com.zoup.orderapi.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Menu implements Serializable {
    @Indexed(unique = true)
    private String dishId;
    private String dishName;
    private Integer unitAvailable;
    private Integer unitCost;
    private String category;
    private String foodType;
    private String image;
    private String description;
}
