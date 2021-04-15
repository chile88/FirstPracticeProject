package data.testdata;

import data.definition.RegisterData;

public class TestRegisterData {
    public static final RegisterData validData = new RegisterData()
            .setTitle("2")
            .setFirstName1("Chi")
            .setLastName1("Le")
            .setFirstName2("Chi")
            .setLasttName2("Le")
            .setPassword("12345")
            .setDayOfBirth("1")
            .setMonthOfBirth("9")
            .setYearOfBirth("1998")
            .setCheckbox1(true)
            .setCheckbox2(false)
            .setCompany("ABC")
            .setCountry("United States")
            .setState("Idaho")
            .setAddress1("3112 street")
            .setAddress2("12345 street")
            .setCity("Vancouver")
            .setAddInfo("Something bla bla")
            .setAliasAddress("456 12Ave")
            .setHomePhone("123456789")
            .setMobilePhone("0909090909")
            .setPostCode("00000");

    public static final RegisterData invalidEmail = new RegisterData()
            .setEmail("abc");

    public static final RegisterData existingEmail = new RegisterData()
            .setEmail("phuongchi123@gmail.com");

    public static final RegisterData emptyEmail = new RegisterData()
            .setEmail("");
}
