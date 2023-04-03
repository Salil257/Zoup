package com.zoup.orderapi.service;

import com.google.gson.Gson;
import com.zoup.orderapi.model.payment.OrderPaymentDTO;
import okhttp3.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PaymentService {
    private final OkHttpClient httpClient = new OkHttpClient();
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public void makePayment(OrderPaymentDTO order) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(order);

        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url("https://sandbox.cashfree.com/pg/orders")
                .header("Content-Type", "application/json")
                .header("x-api-version", "2022-09-01")
                .header("x-client-id", "313650653bae0e369d9a401c9f056313")
                .header("x-client-secret", "f17c0924008d64d27d5977214e54867ff0511af4")
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        }
    }

}

