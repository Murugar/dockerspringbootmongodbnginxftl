package com.iqmsoft;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class IndexController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/")
    public String index(Model model) {
        try(MongoClient mongoClient = MongoClients.
        		create(new ConnectionString("mongodb://mongo:27017"))){
            logger.log(Level.INFO, "First database name: " + mongoClient.listDatabaseNames().first());
        }
        
        return "index";
    }
}
