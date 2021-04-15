package data.testdata;

import data.definition.ForgotPasswordData;

public class TestForgotPasswordData {

    public static final ForgotPasswordData emptyEmail = new ForgotPasswordData()
            .setEmail("");

    public static final ForgotPasswordData invalidEmail = new ForgotPasswordData()
            .setEmail("abc");

    public static final ForgotPasswordData  notregisteredEmail = new ForgotPasswordData()
            .setEmail("notregistered@gmail.com");

    public static final ForgotPasswordData validEmail = new ForgotPasswordData()
            .setEmail("phuongchi123@gmail.com");


}
