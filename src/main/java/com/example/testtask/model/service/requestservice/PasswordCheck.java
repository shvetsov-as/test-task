package com.example.testtask.model.service.requestservice;

import java.util.ArrayList;
import java.util.List;

public class PasswordCheck {

    private static final int PWD_LEN = 3;

    private char ch;
    private boolean flagUpCase;
    private boolean flagLwCase;
    private boolean flagDigit;

    private final String messageLength = "Password must contain at least three characters [ 1Ab ]; ";
    private final String messageWhitespace = "Password contains a whitespaces; ";
    private final String messageRequirements = "Password does not match requirements. Must contain at least three characters: *in uppercase, *in lowercase, *digit [ 1Ab ]; ";

    private void reset() {
        ch = ' ';
        flagUpCase = false;
        flagLwCase = false;
        flagDigit = false;
    }

    public List<String> validate(String password) {

        List<String> errorList = new ArrayList<>();

        password = password.trim();

        if (password.length() < PWD_LEN) {
            errorList.add(messageLength);
        }

        for (int i = 0; i < password.length(); i++) {

            ch = password.charAt(i);

            if (Character.isSpaceChar(ch)) {
                reset();
                errorList.add(messageWhitespace);
                break;

            } else if (Character.isLowerCase(ch)) {
                flagLwCase = true;
            } else if (Character.isUpperCase(ch)) {
                flagUpCase = true;
            } else if (Character.isDigit(ch)) {
                flagDigit = true;
            }
        }

        if (flagLwCase && flagUpCase && flagDigit) {
            reset();
            return errorList;
        }

        errorList.add(messageRequirements);
        return errorList;
    }
}
