package com.zoup.orderapi.controller;

import com.zoup.orderapi.dto.response.MenuResponseDTOList;
import com.zoup.orderapi.model.Menu;
import com.zoup.orderapi.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin()
@Slf4j
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    ResponseEntity<Menu> saveMenu(@RequestBody Menu menu, @PathVariable("restaurantName") String restaurantName){
        log.info("testing menu controller");
        return ResponseEntity.ok(menuService.saveMenu(menu,restaurantName));
    }
//
//    @GetMapping
//    ResponseEntity<List<Menu>> getMenuList(@RequestParam String restaurantName){
//        return ResponseEntity.ok(menuService.getMenuList(restaurantName));
//    }

    @GetMapping
    public String getMyResource() {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("https://script.google.com/macros/s/AKfycbzrukuzv2lA3IOaodVhF7ALh_rFlZqnUJCb81ViQFpgB05RdrC6fH_NpK7WGVu9Z4dg0Q/exec")
//                .get()
//                .build();
//        Response response = null;
//        try {
//            response = client.newCall(request).execute();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        if (response.isSuccessful()) {
//            try {
//                Gson gson = new Gson();
//                MenuResponseDTOList data = gson.fromJson(response.body().string(),MenuResponseDTOList.class);
////                MenuResponseDTO data = mapper.readValue(response.body().string(), MenuResponseDTO.class);
//                return data.getMenuResponseDTOList().get(0).getData().toString();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            System.out.println("Request failed with code: " + response.code());
//        }
       return restTemplate.getForObject("https://script.google.com/macros/s/AKfycbzrukuzv2lA3IOaodVhF7ALh_rFlZqnUJCb81ViQFpgB05RdrC6fH_NpK7WGVu9Z4dg0Q/exec", MenuResponseDTOList.class).toString();

    }
}