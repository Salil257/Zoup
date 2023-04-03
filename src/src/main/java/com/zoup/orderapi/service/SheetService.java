package com.zoup.orderapi.service;

import com.google.gson.Gson;
import com.zoup.orderapi.model.Order;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class SheetService {


    @Async
    public String updateOrderGoogleSheet(Order order){
        OkHttpClient client = new OkHttpClient();

        Gson gson = new Gson();

        String json = gson.toJson(order);

        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        log.info(json);

        Request request = new Request.Builder()
                .url("https://script.google.com/macros/s/AKfycbypbwlgMoyfXP6mOib1RtooYhYgs47VR7qdHoRo0-PpkjxR1yzNSYR-JjHXSlodtAzP/exec")
                .post(body)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            log.info("sheet request success");


        if (response.isSuccessful()) {
            String responseBody = response.body().string();
//            log.info(responseBody);
//            Order responseData = gson.fromJson(responseBody, Order.class);
            return responseBody.toString();
        } else {
            System.out.println("Request was not successful");
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "request failed in posting order to sheets";
    }
}
