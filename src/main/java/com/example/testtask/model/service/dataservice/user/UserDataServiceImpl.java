package com.example.testtask.model.service.dataservice.user;

import com.example.testtask.entity.user.mapper.UserMapper;
import com.example.testtask.model.service.requestservice.RequestCheckService;
import com.example.testtask.repo.UserRepository;
import com.example.testtask.webservice.jaxb.StatusResponse;
import com.example.testtask.webservice.jaxb.UserFull;
import com.example.testtask.webservice.jaxb.UserShort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService{

    private final UserRepository userRepository;
    private final RequestCheckService requestCheckService;
    private final UserMapper userMapper;

    public UserDataServiceImpl(UserRepository userRepository, RequestCheckService requestCheckService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.requestCheckService = requestCheckService;
        this.userMapper = userMapper;
    }

    @Override
    public UserFull findUserShort(String login) {
        return null;
    }

    @Override
    public List<UserShort> findAllUsersFull() {
        return null;
    }

    @Override
    public StatusResponse deleteByLogin(String login) {
        return null;
    }

    @Override
    public StatusResponse create(UserFull userFull) {

        StatusResponse response = new StatusResponse();
        response.setSuccess(true);

        userRepository.save(userMapper.userFullToUser(userFull));

        return response;
    }

    @Override
    public StatusResponse updateByLogin(String login, UserFull userFull) {
        return null;
    }
}
