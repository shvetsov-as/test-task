package com.example.testtask.model.service.requestservice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordCheckTest {

    @Test
    void shouldCheckThatPasswordCorrect() {
        //given
        PasswordCheck passwordCheck = new PasswordCheck();

        //when
        List<String> expectedList = passwordCheck.validate("Abc123");

        //then
        assertThat(expectedList.isEmpty()).isTrue();
    }

    @Test
    void shouldCheckThatPasswordToShort() {
        //given
        PasswordCheck passwordCheck = new PasswordCheck();

        //when
        List<String> expectedList = passwordCheck.validate("Ab");

        //then
        assertThat(expectedList.contains("Password must contain at least three characters [ 1Ab ]; ")).isTrue();
    }

    @Test
    void shouldCheckThatPasswordNotEmpty() {
        //given
        PasswordCheck passwordCheck = new PasswordCheck();

        //when
        List<String> expectedList = passwordCheck.validate("");

        //then
        assertThat(expectedList.contains("Password must contain at least three characters [ 1Ab ]; ")).isTrue();
    }

    @Test
    void shouldCheckThatPasswordNotMatchRequirementsInUppercase() {
        //given
        PasswordCheck passwordCheck = new PasswordCheck();

        //when
        List<String> expectedList = passwordCheck.validate("abc1");

        //then
        assertThat(expectedList.contains("Password does not match requirements." +
                " Must contain at least three characters:" +
                " *in uppercase, *in lowercase, *digit [ 1Ab ]; ")).isTrue();

    }

    @Test
    void shouldCheckThatPasswordNotMatchRequirementsInLowercase() {
        //given
        PasswordCheck passwordCheck = new PasswordCheck();

        //when
        List<String> expectedList = passwordCheck.validate("ABC1");

        //then
        assertThat(expectedList.contains("Password does not match requirements." +
                " Must contain at least three characters:" +
                " *in uppercase, *in lowercase, *digit [ 1Ab ]; ")).isTrue();

    }

    @Test
    void shouldCheckThatPasswordNotMatchRequirementsInDigit() {
        //given
        PasswordCheck passwordCheck = new PasswordCheck();

        //when
        List<String> expectedList = passwordCheck.validate("ABC");

        //then
        assertThat(expectedList.contains("Password does not match requirements." +
                " Must contain at least three characters:" +
                " *in uppercase, *in lowercase, *digit [ 1Ab ]; ")).isTrue();

    }

    @Test
    void shouldCheckThatPasswordContainWhitespaces() {
        //given
        PasswordCheck passwordCheck = new PasswordCheck();

        //when
        List<String> expectedList = passwordCheck.validate("Ab c1");

        //then
        assertThat(expectedList.contains("Password contains a whitespaces; ")).isTrue();

    }
}