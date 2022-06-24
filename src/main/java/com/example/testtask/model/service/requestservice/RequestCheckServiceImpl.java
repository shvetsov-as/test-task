package com.example.testtask.model.service.requestservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("requestCheckServiceImpl")
public class RequestCheckServiceImpl implements RequestCheckService {

    @Override
    public List<String> userPasswordCheck(String userPassword) {

        PasswordCheck passwordCheck = new PasswordCheck();
        return passwordCheck.validate(userPassword);
    }

    @Override
    public List<String> userNameCheck(String userName) {

        List<String> errorList = new ArrayList<>();
        if (userName.equals("") || userName.isBlank()) {
            errorList.add("User Name is empty; ");
        }
        return errorList;
    }

    @Override
    public List<String> userLoginCheck(String userLogin) {

        List<String> errorList = new ArrayList<>();
        if (userLogin.equals("") || userLogin.isBlank()) {
            errorList.add("User Login is empty; ");
        }
        return errorList;
    }

    @Override
    public List<String> userRoleCheck(List<String> userRole) {

        List<String> errorList = new ArrayList<>();
        if (userRole.isEmpty()) {
            errorList.add("User Role is empty; ");
        }
        return errorList;
    }
}
