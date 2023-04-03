package com.zoup.orderapi.controller;


import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.zoup.orderapi.model.Customer;
import com.zoup.orderapi.model.Dish;
import com.zoup.orderapi.model.Order;
import com.zoup.orderapi.model.VehicleDetails;
import com.zoup.orderapi.model.payment.OrderPaymentDTO;
import com.zoup.orderapi.service.MailService;
import com.zoup.orderapi.service.OrderService;
import com.zoup.orderapi.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@RestController
@CrossOrigin()
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AmazonSNSClient amazonSNSClient;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MailService mailService;

    @Autowired
    private PaymentService paymentService;


    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.updateOrder(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") String id){
        return ResponseEntity.ok(orderService.findByOrderId(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrderList(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteOrder(@RequestParam String id){
        return ResponseEntity.ok(orderService.deleteById(id));

    }

    @GetMapping("/test")
    public ResponseEntity<String> snsCheck(){
        SubscribeRequest subscribeRequest= new SubscribeRequest("arn:aws:sns:ap-south-1:196:zoup-version1","sms","+9219193399");
        amazonSNSClient.subscribe(subscribeRequest);
        return ResponseEntity.ok("ok");

    }

    @GetMapping("/pay")
    public ResponseEntity<String> paycheck(@RequestBody OrderPaymentDTO orderPaymentDTO) throws IOException {
        paymentService.makePayment(orderPaymentDTO);
        return ResponseEntity.ok("ok");

    }

    @GetMapping("/testmail")
    public ResponseEntity<String> sendMail(){
//        mailService.sendOrderMail();
        return ResponseEntity.ok("mail will be sent");

    }

    @GetMapping("/test1")
    public ResponseEntity<String> sendMessage(){
        PublishRequest request = new PublishRequest();
                request.setMessage("Don't forget to check our other menu items on our website for your next order. Enjoy your meal! \"Your order of [dish] has been confirmed and is on its way. It will arrive at");
                request.setPhoneNumber("+91");
        amazonSNSClient.publish(request);
        return ResponseEntity.ok("ok");

    }

    @GetMapping("/test2")
    ResponseEntity<List<Order>> getMenuList(){
        log.info("this is test log");
        return ResponseEntity.ok(mongoTemplate.findAll(Order.class,"order"));
    }

    @GetMapping("/sample")
    public ResponseEntity<Order> getOrderBody(){
        Dish dish = Dish.builder().dishId("1").dishName("tea").unitCost(10).quantity(5).finalCost(50).build();
        Dish dish1 = Dish.builder().dishId("2").dishName("coffee").unitCost(25).quantity(2).finalCost(50).build();
        ArrayList dishes = new ArrayList<>();
        dishes.add(dish);
        dishes.add(dish1);
        return ResponseEntity.ok(Order.builder().orderId("123").orderStatus("placed").orderDateTime(23213123L)
                .customerDetails(Customer.builder().name("abhi").phoneNumber("392929221").build())
                        .dishes(dishes)
                .netAmount(231).restaurantId("121").restaurantName("restaurant12").vehicleDetails(VehicleDetails.builder().vehicleNo("pb12az2212").routeDetail("DLtoCHD").build()).build());
    }

}
