package com.example.testtask.model.service.requestservice;

import com.example.testtask.webservice.jaxb.UserFull;

import java.util.List;

public interface RequestCheckService {

    List<String> userPasswordCheck(String userPassword);

    List<String> userNameCheck(String userName);

    List<String> userLoginCheck(String userLogin);

    List<String> userRoleCheck(List<String> userRole);

    List<String> fullCheck(UserFull userFull);

}
