package data.definition;

public class LoginData {
    String email;
    String password;


    public LoginData setEmail(String email) {
        this.email = email;
        return this;
    }

    public LoginData setPassword(String password) {
        this.password = password;
        return this;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
