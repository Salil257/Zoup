package com.zoup.orderapi.service;

import com.zoup.orderapi.advice.exception.ExceptionCode;
import com.zoup.orderapi.advice.exception.ServiceException;
import com.zoup.orderapi.model.Order;
import com.zoup.orderapi.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private SheetService sheetService;
    @Override
    public Order saveOrder(Order order){
        if (orderRepository.existsById(order.getOrderId())){
            throw new ServiceException(ExceptionCode.O404,String.format("Order with this Id Already Exists"));

        }
        sheetService.updateOrderGoogleSheet(order);

        mailService.sendOrderMail(order);

        return orderRepository.save(order);
    }
    @Override
    public Order updateOrder(Order order) {
        if (!orderRepository.existsById(order.getOrderId())){
            throw  new ServiceException(ExceptionCode.O404,String.format("Order with this Id doesn't Exists"));

        }
        return orderRepository.save(order);
    }

    @Override
    public Order findByOrderId(String orderId) {
        return orderRepository.findById(orderId).orElseThrow(()->new ServiceException(ExceptionCode.O404,String.format("Order with this Id Doesn't Exist")));
    }

    @Override
    public List<Order> getAllOrders() {
        Sort sort = Sort.by("orderDateTime").descending();
        List<Order> orderPage = orderRepository.findAll(PageRequest.of(0,20,sort)).getContent();
        return orderPage;
    }

    @Override
    public Boolean deleteById(String id) {
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
