package com.example.testtask.model.service.requestservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RequestCheckServiceImplTest {

    @BeforeEach
    void init() {
        RequestCheckServiceImpl requestCheckService = new RequestCheckServiceImpl();
    }

    @Test
    void shouldCheckThatUserNameIsPresent() {

        //given
        RequestCheckServiceImpl requestCheckService = new RequestCheckServiceImpl();

        //when
        List<String> expectedList = requestCheckService.userNameCheck("UserName");

        //then
        assertThat(expectedList.isEmpty()).isTrue();

    }

    @Test
    void shouldCheckThatUserNameIsEmpty() {

        //given
        RequestCheckServiceImpl requestCheckService = new RequestCheckServiceImpl();

        //when
        List<String> expectedList = requestCheckService.userNameCheck("");

        //then
        assertThat(expectedList.contains("User Name is empty; ")).isTrue();

    }

    @Test
    void shouldCheckThatUserLoginIsPresent() {

        //given
        RequestCheckServiceImpl requestCheckService = new RequestCheckServiceImpl();

        //when
        List<String> expectedList = requestCheckService.userLoginCheck("UserLogin");

        //then
        assertThat(expectedList.isEmpty()).isTrue();
    }

    @Test
    void shouldCheckThatUserLoginIsEmpty() {

        //given
        RequestCheckServiceImpl requestCheckService = new RequestCheckServiceImpl();

        //when
        List<String> expectedList = requestCheckService.userLoginCheck("");

        //then
        assertThat(expectedList.contains("User Login is empty; ")).isTrue();
    }

    @Test
    void shouldCheckThatUserRoleIsPresent() {

        //given
        RequestCheckServiceImpl requestCheckService = new RequestCheckServiceImpl();
        List<String> givenUserRole = Arrays.asList("SimpleRoleOne", "SimpleRoleTwo");

        //when
        List<String> expectedList = requestCheckService.userRoleCheck(givenUserRole);

        //then
        assertThat(expectedList.isEmpty()).isTrue();
    }

    @Test
    void shouldCheckThatUserRoleIsEmpty() {

        //given
        RequestCheckServiceImpl requestCheckService = new RequestCheckServiceImpl();
        List<String> givenUserRole = new ArrayList<>();

        //when
        List<String> expectedList = requestCheckService.userRoleCheck(givenUserRole);

        //then
        assertThat(expectedList.contains("User Role is empty; ")).isTrue();
    }
}

