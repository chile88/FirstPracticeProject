package data.testdata;

import data.definition.MessageData;

public class TestMessageData {

    // ---------------Message in Sign in Page---------------------
    // Error message when attempting login with empty email
    public static final MessageData loginEmailRequired = new MessageData()
            .setMessage("An email address required.");

    // Error message when attempting login with empty password
    public static final MessageData loginPassRequired = new MessageData()
            .setMessage("Password is required.");

    // Error message when attempting login with wrong credentials
    public static final MessageData wrongCredentials = new MessageData()
            .setMessage("Authentication failed.");

    // Error message for invalid email
    public static final MessageData invalidEmailCredentials = new MessageData()
            .setMessage("Invalid email address.");

    // Error message for invalid password
    public static final MessageData invalidPassCredentials = new MessageData()
            .setMessage("Invalid password.");


    // Error message when attempting create new account with existing email
    public static final MessageData existingEmail = new MessageData()
            .setMessage("An account using this email address has already been registered. Please enter a valid password or request a new one.");


    // -----------------Message in Forgot Password Page------------------------
    // Confirmation message
    public static final MessageData confirmationMessage = new MessageData()
            .setMessage("A confirmation email has been sent to your address: ");

    // Error message for invalid email
    public static final MessageData invalidEmailForgotPassword = new MessageData()
            .setMessage("Invalid email address.");

    // Error message for empty email
    public static final MessageData emptyEmailForgotPassword = new MessageData()
            .setMessage("Invalid email address.");

    // Error message when attempting reset password with non registered email
    public static final MessageData nonregisteredEmail = new MessageData()
            .setMessage("There is no account registered for this email address.");

    //------------------Message in MyAccount Page---------------------------------
    // Welcome message when login successfully
    public static final MessageData welcomeMessage = new MessageData()
            .setMessage("Welcome to your account. Here you can manage all of your personal information and orders.");

    //------------------Message in Search Page------------------------------------
    // Message for no results were found
    public static final MessageData noResultMessage = new MessageData()
            .setMessage("No results were found for your search");

}
