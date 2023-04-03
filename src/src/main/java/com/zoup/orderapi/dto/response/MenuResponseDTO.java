package com.zoup.orderapi.dto.response;

import com.zoup.orderapi.model.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuResponseDTO implements Serializable {
    private Integer status;
    private List<Menu> data;
}
