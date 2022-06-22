package com.example.testtask.entity.user.mapper;

import com.example.testtask.entity.role.Role;
import com.example.testtask.entity.user.User;
import com.example.testtask.webservice.jaxb.UserFull;
import com.example.testtask.webservice.jaxb.UserShort;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public User userFullToUser(UserFull userFull) {

        return new User(
                userFull.getUserLogin(),
                userFull.getUserName(),
                userFull.getUserPassword(),
                map(userFull.getRoles())
        );
    }

    public UserFull userToUserFull(User user) {

        UserFull userFull = new UserFull();
        userFull.setUserLogin(user.getUserLogin());
        userFull.setUserName(user.getUserName());
        userFull.setUserPassword(user.getUserPassword());
        userFull.getRoles().addAll(map(user.getRoles()));

        return userFull;
    }

    public abstract User userShortToUser(UserShort userShort);

    public abstract UserShort userToUserShort(User user);

    public abstract List<UserShort> userToUserShortList(List<User> userList);

    private Set<Role> map(List<String> roleList) {
        Set<Role> roleSet = new LinkedHashSet<>();
        for (String roleName : roleList) {
            Role role = new Role(roleName);
            roleSet.add(role);
        }
        return roleSet;
    }

    private List<String> map(Set<Role> roleSet) {
        List<String> roleList = new ArrayList<>();
        for (Role role : roleSet) {
            roleList.add(role.getRoleName());
        }
        return roleList;
    }
}
