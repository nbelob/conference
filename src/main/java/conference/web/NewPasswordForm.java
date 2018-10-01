package conference.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewPasswordForm {
    @NotNull
    @NotEmpty(message = "{password.empty}")
    private String password;

    @NotNull
    @NotEmpty(message = "{passwordConfirmation.empty}")
    private String passwordConfirmation;

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
