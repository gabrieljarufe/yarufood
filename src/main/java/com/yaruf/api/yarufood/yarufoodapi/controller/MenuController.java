package com.yaruf.api.yarufood.yarufoodapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "menu")
public class MenuController {

    @GetMapping()
    public String getHelloWorld(){
        return "Hello YaruFood!";
    }

}
