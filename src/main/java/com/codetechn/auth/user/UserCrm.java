package com.codetechn.auth.user;


/*import com.codetechn.auth.validation.FieldMatch;*/

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.logging.FileHandler;

/*@FieldMatch.List({
        @FieldMatch(first="password", second="confirm_password",message="the password fields doesn't match")
})*/
public class UserCrm {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String name;
    @Email(message = "is not an email")
    @Size(min = 1, message = "is required")
    private String email;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String confirm_password;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String number;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")

    private String address;

    public UserCrm(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
