package com.example.testtask.model.service.dataservice.user;

import com.example.testtask.entity.role.Role;
import com.example.testtask.entity.user.User;
import com.example.testtask.entity.user.mapper.UserMapper;
import com.example.testtask.model.service.dataservice.role.RoleDataService;
import com.example.testtask.model.service.requestservice.RequestCheckService;
import com.example.testtask.repo.UserRepository;
import com.example.testtask.webservice.jaxb.GetAllUsersResponse;
import com.example.testtask.webservice.jaxb.GetUserResponse;
import com.example.testtask.webservice.jaxb.StatusResponse;
import com.example.testtask.webservice.jaxb.UserFull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service ("userDataServiceImpl")
public class UserDataServiceImpl implements UserDataService {

    private final UserRepository userRepository;
    private final RoleDataService roleDataService;
    private final RequestCheckService requestCheckService;
    private final UserMapper userMapper;

    public UserDataServiceImpl(
            UserRepository userRepository,
            @Qualifier("roleDataServiceImpl") RoleDataService roleDataService,
            @Qualifier("requestCheckServiceImpl")RequestCheckService requestCheckService,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.roleDataService = roleDataService;
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
    @Transactional
    public StatusResponse deleteByLogin(String login) {
        StatusResponse responseDeleted = new StatusResponse();
        responseDeleted.setSuccess(true);

        userRepository.deleteById(login);

        return responseDeleted;
    }

    @Override
    @Transactional
    public StatusResponse create(UserFull userFull) {

        StatusResponse responseCreated = new StatusResponse();
        responseCreated.setSuccess(true);

        userRepository.save(userMapper.userFullToUser(userFull));

        return responseCreated;
    }

    @Override
    @Transactional
    public StatusResponse updateByLogin(String login, UserFull userFull) {

        StatusResponse responseUpdated = new StatusResponse();
        responseUpdated.setSuccess(true);

        User user = userRepository.findById(login).get();

        if (!userFull.getRoles().isEmpty()) {
            Set<Role> rolesSet = user.getRoles();
            for (Role r : rolesSet){
                roleDataService.deleteRoleById(r.getRoleId());
            }
            user.setRoles(userFull.getRoles().stream().map(Role::new).collect(Collectors.toSet()));
        }

        if (!userFull.getUserLogin().equals("") && !userFull.getUserLogin().equals(user.getUserLogin())) {
            User userToUpdatePK = new User(
                    userFull.getUserLogin(),
                    user.getUserName(),
                    user.getUserPassword(),
                    user.getRoles()
            );
            user = userRepository.save(userToUpdatePK);
            userRepository.deleteById(login);
        }

        if (!userFull.getUserName().equals("")) {
            user.setUserName(userFull.getUserName());
        }

        if (!userFull.getUserPassword().equals("")) {
            user.setUserPassword(userFull.getUserPassword());
        }

        return responseUpdated;
    }
}
