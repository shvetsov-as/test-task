package com.example.testtask.model.service.dataservice.user;

import com.example.testtask.entity.user.User;
import com.example.testtask.webservice.jaxb.StatusResponse;
import com.example.testtask.webservice.jaxb.UserFull;
import com.example.testtask.webservice.jaxb.UserShort;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserDataService {

    UserFull findUserShort(String login);

    List<UserShort> findAllUsersFull();

    StatusResponse deleteByLogin(String login);

    StatusResponse create(UserFull userFull);

    StatusResponse updateByLogin(String login, UserFull userFull);
    /*Если в запросе на редактирование передан массив ролей,
     система должна обновить список ролей пользователя в БД - новые привязки добавить,
      неактуальные привязки удалить.*/

}
