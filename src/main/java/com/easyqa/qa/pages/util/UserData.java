package com.easyqa.qa.pages.util;

public class UserData {
    private final String userEmail;
    private final String userPassword;

    public UserData(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {

        return this.userEmail;
    }

    public String getUserPassword() {

        return this.userPassword;
    }
}
