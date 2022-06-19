package com.example.testtask.webservice;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebService {

    public void test(){
        try{
            //выброс ошибки в конце метода
        }catch(Exception e){
            e.getMessage();
        }
    }
}
