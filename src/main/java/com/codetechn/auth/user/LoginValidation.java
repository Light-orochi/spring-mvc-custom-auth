package com.codetechn.auth.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginValidation {

    @NotNull(message = "Field name is required")
    @Size(min = 2,message ="Field name is required" )
    private String email;
    @NotNull(message = "Field name is required")
    @Size(min = 2,message ="Field name is required" )
    private String password;
    public LoginValidation(){


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
    }

    @Override
    public String toString() {
        return "LoginValidation{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public LoginValidation(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
