package conference.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewPasswordForm {
    @NotNull
    @NotEmpty(message = "{password.empty}")
    private String password;

    @NotNull
    @NotEmpty(message = "{confPassword.empty}")
    private String confPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }
}
