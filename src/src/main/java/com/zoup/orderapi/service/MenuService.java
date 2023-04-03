package com.zoup.orderapi.service;

import com.zoup.orderapi.model.Menu;

import java.io.IOException;
import java.util.List;

public interface MenuService {

    Menu saveMenu(Menu menu,String restaurantName) ;
    List<Menu> getMenuList(String restaurantName);
    Menu getMenuById(String restaurantName, String foodId);
}
