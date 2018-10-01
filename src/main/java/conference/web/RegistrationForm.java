package conference.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm {
    @NotNull
    @NotEmpty(message = "{username.empty}")
    @Size(min = 1, max = 16, message = "{username.size}")
    private String username;

    @NotNull
    @NotEmpty(message = "{password.empty}")
    private String password;

    @NotNull
    @NotEmpty(message = "{passwordConfirmation.empty}")
    private String passwordConfirmation;

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

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
