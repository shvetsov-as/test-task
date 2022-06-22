package com.example.testtask.webservice;

import com.example.testtask.model.service.dataservice.user.UserDataService;
import com.example.testtask.webservice.jaxb.CreateUserRequest;
import com.example.testtask.webservice.jaxb.GetAllUsersRequest;
import com.example.testtask.webservice.jaxb.GetAllUsersResponse;
import com.example.testtask.webservice.jaxb.GetUserResponse;
import com.example.testtask.webservice.jaxb.GetUserRequest;
import com.example.testtask.webservice.jaxb.StatusResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Endpoint
public class WebServiceUserEndpoint {

    private final UserDataService userDataService;

    public WebServiceUserEndpoint(UserDataService userDataService) {
        this.userDataService = userDataService;
    }


    @PayloadRoot(namespace = "http://localhost:8080/testtask/example/com", localPart = "getAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsersResponse(@RequestPayload GetAllUsersRequest request) {
        return userDataService.findAllUsersShort();
    }


    @PayloadRoot(namespace = "http://localhost:8080/testtask/example/com", localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserResponse(@RequestPayload GetUserRequest request) {
        return userDataService.findUserFull(request.getUserLogin());
    }


    @PayloadRoot(namespace = "http://localhost:8080/testtask/example/com", localPart = "createUserRequest")
    @ResponsePayload
    public StatusResponse createUser (@RequestPayload CreateUserRequest request){
        return userDataService.create(request.getUserFull());
    }



    public void test() {
        try {
            //выброс ошибки в конце метода
            Set<String> s = new HashSet<>();
            s.add("dfsdfsdf");
            Iterator<String> ss = s.iterator();


        } catch (Exception e) {
            e.getMessage();
        }
    }



}
