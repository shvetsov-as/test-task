package com.example.testtask.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    public void test(){
        try{
            //выброс ошибки в конце метода
        }catch(Exception e){
            e.getMessage();
        }
    }
}
