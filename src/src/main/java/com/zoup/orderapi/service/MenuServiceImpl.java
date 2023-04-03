package com.zoup.orderapi.service;

import com.zoup.orderapi.model.Menu;
import com.zoup.orderapi.repository.service.MenuRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuRepositoryService menuRepositoryService;

    @Override
    public Menu saveMenu(Menu menu, String restaurantName){

//        OkHttpClient client = new OkHttpClient();
//        log.info("amking erquest");
//        Request request = new Request.Builder()
//                .url("https://script.google.com/macros/s/AKfycbzrukuzv2lA3IOaodVhF7ALh_rFlZqnUJCb81ViQFpgB05RdrC6fH_NpK7WGVu9Z4dg0Q/exec")
//                .get()
//                .build();
//        log.info("hi 1");
//        Response response = client.newCall(request).execute();
//
//        log.info(response.body().string());
        return menuRepositoryService.saveMenu(menu,restaurantName);
    }

    @Override
    public List<Menu> getMenuList(String restaurantName) {
        return menuRepositoryService.getMenuList(restaurantName);
    }

    @Override
    public Menu getMenuById(String restaurantName, String foodId) {
        return menuRepositoryService.getMenuById(restaurantName,foodId);
    }
}
