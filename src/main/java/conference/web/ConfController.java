package conference.web;

import conference.dao.AccountDao;
import conference.dao.MessageDao;
import conference.dao.exception.AccountNotExistsException;
import conference.dao.exception.WrongPasswordException;
import conference.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
//@RequestMapping("/")
public class ConfController {
    private AccountDao accountDao;
    private MessageDao messageDao;
    private MessageSourceAccessor messageSourceAccessor;

    @Autowired
    public ConfController(AccountDao accountDao, MessageSourceAccessor messageSourceAccessor) {
        this.accountDao = accountDao;
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @RequestMapping(value = "/login", method = GET)
    public String showLoginForm(Model model) {
        model.addAttribute(new LoginForm());
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = POST, params = "registration")
    public String registrationLoginForm() {
        return "redirect:/register";
    }

    @RequestMapping(value = "/login", method = POST, params = "login")
    public String loginLoginForm(@Valid LoginForm loginForm, Errors errors) {
        if (errors.hasErrors()) {
            return "loginForm";
        }

        try {
            accountDao.login(loginForm.getUsername(), loginForm.getPassword());
        } catch (AccountNotExistsException e) {
            errors.reject("account.not.exists", messageSourceAccessor.getMessage("account.not.exists"));
            return "loginForm";
        } catch (WrongPasswordException e) {
            errors.reject("account.wrong.password", messageSourceAccessor.getMessage("account.wrong.password"));
            return "loginForm";
        }

        return "redirect:/account/" + loginForm.getUsername();
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new RegistrationForm());
        return "registrationForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistrationForm(@Valid RegistrationForm registrationForm, Errors errors) {
        if (errors.hasErrors()) {
            return "registrationForm";
        }

        try {
            accountDao.findByUsername(registrationForm.getUsername());

            errors.reject("account.exists", messageSourceAccessor.getMessage("account.exists"));
            return "registrationForm";
        } catch (AccountNotExistsException e) {
            // Nothing
        }

        if (!registrationForm.getPassword().equals(registrationForm.getPasswordConfirmation())) {
            return "registrationForm";
        }

        accountDao.add(registrationForm.getUsername(), registrationForm.getPassword());
        return "redirect:/account/" + registrationForm.getUsername();
    }

    @RequestMapping(value = "/account/{username}", method = GET)
    public String showAccounts(@PathVariable String username, Model model) {
        List<Message> messages = messageDao.findByUsername(username);
        model.addAttribute(username);
        model.addAttribute(messages);
        return "mainForm";
    }

    @RequestMapping(value = "/account/{username}", method = POST, params = "newMessage")
    public String newMessageMainForm() {
        return "redirect:/account/{username}/new";
    }

    @RequestMapping(value = "/account/{username}/new", method = GET)
    public String newMessage(Model model) {
        model.addAttribute(new MessageForm());
        return "messageForm";
    }

    @RequestMapping(value = "/account/{username}/new", method = POST, params = "cancel")
    public String cancelNewMessage() {
        return "redirect:/account/{username}";
    }

    @RequestMapping(value = "/account/{username}/new", method = POST, params = "ok")
    public String okNewMessage(@PathVariable String username, MessageForm messageForm) {
        messageDao.add(username, messageForm.getText());
        return "redirect:/account/{username}";
    }

    @RequestMapping(value = "/account/{username}", method = POST, params = "newPassword")
    public String newPasswordForm() {
        return "redirect:/account/{username}/newPassword";
    }

    @RequestMapping(value = "/account/{username}/newPassword", method = GET)
    public String newPassword(Model model) {
        model.addAttribute(new NewPasswordForm());
        return "newPasswordForm";
    }

    @RequestMapping(value = "/account/{username}/newPassword", method = POST, params = "cancel")
    public String cancelNewPassword() {
        return "redirect:/account/{username}";
    }

    @RequestMapping(value = "/account/{username}/newPassword", method = POST, params = "ok")
    public String okNewPassword(@Valid NewPasswordForm newPasswordForm, Errors errors, @PathVariable String username) {
        if (errors.hasErrors()) {
            return "newPasswordForm";
        }
        if (!newPasswordForm.getPassword().equals(newPasswordForm.getPasswordConfirmation())) {
            return "newPasswordForm";
        }
        accountDao.update(username, newPasswordForm.getPassword());
        return "redirect:/account/{username}";
    }
}
