package com.example.testtask.model.service.dataservice.user;

import com.example.testtask.entity.user.User;

import java.util.List;

public interface UserDataService {

    List<User> findAllfull();

    List<User> findAllshort();

    void deleteByLogin(String login);

    void create(User user);

    void update(User user);
    /*Если в запросе на редактирование передан массив ролей,
     система должна обновить список ролей пользователя в БД - новые привязки добавить,
      неактуальные привязки удалить.*/

}
