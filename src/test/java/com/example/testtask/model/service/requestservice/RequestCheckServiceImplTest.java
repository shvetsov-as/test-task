package com.example.testtask.model.service.requestservice;

import com.example.testtask.webservice.jaxb.UserFull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RequestCheckServiceImplTest {

    private RequestCheckServiceImpl requestCheckService;

    @BeforeEach
    public void setup() {
        //given
        requestCheckService = new RequestCheckServiceImpl();
    }

    @Test
    void shouldCheckThatUserNameIsPresent() {

        //when
        List<String> expectedList = requestCheckService.userNameCheck("UserName");

        //then
        assertThat(expectedList.isEmpty()).isTrue();

    }

    @Test
    void shouldCheckThatUserNameIsEmpty() {

        //when
        List<String> expectedList = requestCheckService.userNameCheck("");

        //then
        assertThat(expectedList.contains("User Name is empty; ")).isTrue();

    }

    @Test
    void shouldCheckThatUserLoginIsPresent() {

        //when
        List<String> expectedList = requestCheckService.userLoginCheck("UserLogin");

        //then
        assertThat(expectedList.isEmpty()).isTrue();
    }

    @Test
    void shouldCheckThatUserLoginIsEmpty() {

        //when
        List<String> expectedList = requestCheckService.userLoginCheck("");

        //then
        assertThat(expectedList.contains("User Login is empty; ")).isTrue();
    }

    @Test
    void shouldCheckThatUserRoleIsPresent() {

        //given
        List<String> givenUserRole = Arrays.asList("SimpleRoleOne", "SimpleRoleTwo");

        //when
        List<String> expectedList = requestCheckService.userRoleCheck(givenUserRole);

        //then
        assertThat(expectedList.isEmpty()).isTrue();
    }

    @Test
    void shouldCheckThatUserRoleIsEmpty() {

        //given
        List<String> givenUserRole = new ArrayList<>();

        //when
        List<String> expectedList = requestCheckService.userRoleCheck(givenUserRole);

        //then
        assertThat(expectedList.contains("User Role is empty; ")).isTrue();
    }

    @Test
    void shouldPerformCorrectFullCheck() {

        //given
        UserFull userFull = new UserFull();
        List<String> givenUserRole = Arrays.asList("SimpleRoleOne", "SimpleRoleTwo");

        userFull.setUserLogin("John123");
        userFull.setUserName("John");
        userFull.setUserPassword("John123");
        userFull.getRoles().addAll(givenUserRole);

        //when
        List<String> expectedList = requestCheckService.fullCheck(userFull);

        //then
        assertThat(expectedList.isEmpty()).isTrue();
    }

    @Test
    void shouldReturnAllErrorsAfterFullCheck() {

        //given
        UserFull userFull = new UserFull();
        List<String> givenUserRole = new ArrayList<>();

        userFull.setUserLogin("");
        userFull.setUserName("");
        userFull.setUserPassword("a");
        userFull.getRoles().addAll(givenUserRole);

        //when
        List<String> expectedList = requestCheckService.fullCheck(userFull);
        List<String> errorList = Arrays.asList(
                "User Name is empty; ",
                "User Login is empty; ",
                "User Role is empty; ",
                "Password must contain at least three characters [ 1Ab ]; ",
                "Password does not match requirements." +
                        " Must contain at least three characters:" +
                        " *in uppercase, *in lowercase, *digit [ 1Ab ]; "
        );

        //then
        assertThat(expectedList.containsAll(errorList)).isTrue();
    }
}

