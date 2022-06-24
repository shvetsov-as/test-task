package com.example.testtask.model.service.dataservice.user;

import com.example.testtask.webservice.jaxb.GetAllUsersResponse;
import com.example.testtask.webservice.jaxb.GetUserResponse;
import com.example.testtask.webservice.jaxb.StatusResponse;
import com.example.testtask.webservice.jaxb.UserFull;

public interface UserDataService {

    GetUserResponse findUserFull(String login);

    GetAllUsersResponse findAllUsersShort();

    StatusResponse deleteByLogin(String login);

    StatusResponse create(UserFull userFull);

    StatusResponse updateByLogin(String login, UserFull userFull);
}
