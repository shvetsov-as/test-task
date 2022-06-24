package com.example.testtask.model.service.requestservice;

import java.util.List;

public interface RequestCheckService {

    List<String> userPasswordCheck(String userPassword);

    List<String> userNameCheck(String userName);

    List<String> userLoginCheck(String userLogin);

    List<String> userRoleCheck(List<String> userRole);

}
