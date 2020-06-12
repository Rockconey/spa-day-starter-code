package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotBlank(message = "User name is required.")
    @Size(min = 5, max = 15, message = "User name must be between 5 and 15 characters.")
    private String username;

    @Email(message = "You must use a valid email address.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;


    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;

    //TODO add constructor?
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public User() {
    }

    private void checkPassword(String password, String verifyPassword) {
        if (password != null && verifyPassword != null) {
            if (!password.equals(verifyPassword)) {
                setVerifyPassword(null);
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword(password, verifyPassword);
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword(password, verifyPassword);
    }
}
