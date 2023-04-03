package com.zoup.orderapi.service;

import com.zoup.orderapi.model.Order;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface OrderService {
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    Order findByOrderId (String orderId);
    List<Order> getAllOrders();
    Boolean deleteById(String id);
}
