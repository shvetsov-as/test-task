package com.example.testtask.model.service.dataservice.user;

import com.example.testtask.entity.user.User;
import com.example.testtask.entity.user.mapper.UserMapper;
import com.example.testtask.model.service.requestservice.RequestCheckService;
import com.example.testtask.repo.UserRepository;
import com.example.testtask.webservice.jaxb.GetAllUsersResponse;
import com.example.testtask.webservice.jaxb.GetUserResponse;
import com.example.testtask.webservice.jaxb.StatusResponse;
import com.example.testtask.webservice.jaxb.UserFull;
import com.example.testtask.webservice.jaxb.UserShort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    private final UserRepository userRepository;
    private final RequestCheckService requestCheckService;
    private final UserMapper userMapper;

    public UserDataServiceImpl(UserRepository userRepository, RequestCheckService requestCheckService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.requestCheckService = requestCheckService;
        this.userMapper = userMapper;
    }

    @Override
    public GetUserResponse findUserFull(String login) {

        GetUserResponse userResponse = new GetUserResponse();
        userResponse.setUserFull(
                userMapper.userToUserFull(
                        userRepository.findById(login)
                                .orElse(new User("User with login [ " + login + " ] not found", " ", " "))
                )
        );

        return userResponse;
    }

    @Override
    public GetAllUsersResponse findAllUsersShort() {

        GetAllUsersResponse allUsersResponse = new GetAllUsersResponse();
        allUsersResponse.getUserShort().addAll(
                userMapper.userToUserShortList(userRepository.findAll())
        );

        return allUsersResponse;
    }

    @Override
    public StatusResponse deleteByLogin(String login) {
        return null;
    }

    @Override
    public StatusResponse create(UserFull userFull) {

        StatusResponse responseCreated = new StatusResponse();
        responseCreated.setSuccess(true);

        userRepository.save(userMapper.userFullToUser(userFull));

        return responseCreated;
    }

    @Override
    public StatusResponse updateByLogin(String login, UserFull userFull) {
        return null;
    }
}
