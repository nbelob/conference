package conference.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginForm {
    @NotNull
    @NotEmpty(message = "Введите логин")
    private String username;

    @NotNull
    @NotEmpty(message = "Введите пароль")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
