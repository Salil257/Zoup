package com.zoup.orderapi.repository.service;


import com.zoup.orderapi.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuRepositoryService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Menu saveMenu(Menu menu, String restaurantName){
        return mongoTemplate.save(menu,"menu_"+restaurantName);
    }

    public List<Menu> getMenuList(String restaurantName){
        return mongoTemplate.findAll(Menu.class,String.format("%s_%s","menu",restaurantName));
    }

    public Menu getMenuById(String restaurantName, String id){
        return mongoTemplate.findById(id,Menu.class,String.format("%s_%s","menu",restaurantName));
    }
}

