package com.example.testtask.webservice;

import com.example.testtask.model.service.dataservice.user.UserDataService;
import com.example.testtask.webservice.jaxb.CreateUserRequest;
import com.example.testtask.webservice.jaxb.DeleteUserRequest;
import com.example.testtask.webservice.jaxb.GetAllUsersRequest;
import com.example.testtask.webservice.jaxb.GetAllUsersResponse;
import com.example.testtask.webservice.jaxb.GetUserRequest;
import com.example.testtask.webservice.jaxb.GetUserResponse;
import com.example.testtask.webservice.jaxb.StatusResponse;
import com.example.testtask.webservice.jaxb.UpdateUserRequest;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WebServiceUserEndpoint {

    private final UserDataService userDataService;
    private static final String URI = "http://localhost:8080/testtask/example/com";

    public WebServiceUserEndpoint(UserDataService userDataService) {
        this.userDataService = userDataService;
    }


    @PayloadRoot(namespace = URI, localPart = "getAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsersResponse(@RequestPayload GetAllUsersRequest request) {
        return userDataService.findAllUsersShort();
    }


    @PayloadRoot(namespace = URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserResponse(@RequestPayload GetUserRequest request) {
        return userDataService.findUserFull(request.getUserLogin());
    }


    @PayloadRoot(namespace = URI, localPart = "createUserRequest")
    @ResponsePayload
    public StatusResponse createUser (@RequestPayload CreateUserRequest request){
        return userDataService.create(request.getUserFull());
    }

    @PayloadRoot(namespace = URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public StatusResponse deleteUser (@RequestPayload DeleteUserRequest request){
        return userDataService.deleteByLogin(request.getUserLogin());
    }

    @PayloadRoot(namespace = URI, localPart = "updateUserRequest")
    @ResponsePayload
    public StatusResponse updateUser (@RequestPayload UpdateUserRequest request){
        return userDataService.updateByLogin(request.getUserLogin(), request.getUserFull());
    }

}
