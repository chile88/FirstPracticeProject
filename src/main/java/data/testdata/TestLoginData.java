package data.testdata;

import data.definition.LoginData;

public class TestLoginData {


    // Wrong login credentials
    public static final LoginData wrongData = new LoginData()
            .setEmail("wrongemail@gmail.com")
            .setPassword("123456");

    // Correct login credentials
    public static final LoginData correctData = new LoginData()
            .setEmail("phuongchi123@gmail.com")
            .setPassword("11111111");

    // Invalid email credentials
    public static final LoginData invalidEmail = new LoginData()
            .setEmail("abc")
            .setPassword("12143243");

    // Invalid password credentials
    public static final LoginData invalidPass = new LoginData()
            .setEmail("phuongchi123@gmail.com")
            .setPassword("1");

    // Empty login credentials
    public static final LoginData emptyData = new LoginData()
            .setEmail("")
            .setPassword("");

    // Empty pass credentials
    public static final LoginData emptyPassword = new LoginData()
            .setEmail("phuongchi123@gmail.com")
            .setPassword("");

}