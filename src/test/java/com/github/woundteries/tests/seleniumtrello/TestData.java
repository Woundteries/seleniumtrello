package com.github.woundteries.tests.seleniumtrello;

import lombok.Getter;

@Getter
public class TestData {

    private String userName;
    private String email;
    private String password;

    public TestData(ConfigurationReader configReader) {
        userName = configReader.getTestData("userName");
        email = configReader.getTestData("email");
        password = configReader.getTestData("password");
    }

}
