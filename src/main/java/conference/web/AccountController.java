package conference.web;

import conference.dao.AccountDao;
import conference.dao.MessageDao;
import conference.dao.exception.AccountNotExistsException;
import conference.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/account")
public class AccountController {
    private AccountDao accountDao;
    private MessageDao messageDao;
    private MessageSourceAccessor messageSourceAccessor;

    @Autowired
    public AccountController(AccountDao accountDao, MessageDao messageDao, MessageSourceAccessor messageSourceAccessor) {
        this.accountDao = accountDao;
        this.messageDao = messageDao;
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new RegistrationForm());

        return "registrationForm";
    }

    @RequestMapping(value = "/register", method = POST, params = "registration")
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

        return "redirect:/account/show/" + registrationForm.getUsername();
    }

    @RequestMapping(value = "/register", method = POST, params = "cancel")
    public String cancelRegistrationForm() {
        return "redirect:/account/login";
    }

    /**
     * Shows account form for current authenticated account
     *
     * @param model     model
     * @param principal principal
     * @return view name
     */
    @RequestMapping(value = "/show", method = GET)
    public String showAccountForm(Model model, Principal principal) {
        List<Message> messages = messageDao.findAll();

        model.addAttribute(principal.getName());
        model.addAttribute(messages);

        return "mainForm";
    }

    @RequestMapping(value = "/show", method = POST, params = "newMessage")
    public String newMessageMainForm() {
        return "redirect:/message/new";
    }

    @RequestMapping(value = "/show", method = POST, params = "newPassword")
    public String newPasswordForm() {
        return "redirect:/account/newPassword";
    }

    @RequestMapping(value = "/newPassword", method = GET)
    public String newPassword(Model model) {
        model.addAttribute(new NewPasswordForm());

        return "newPasswordForm";
    }

    @RequestMapping(value = "/newPassword", method = POST, params = "cancel")
    public String cancelNewPassword() {
        return "redirect:/account/show";
    }

    @RequestMapping(value = "/newPassword", method = POST, params = "ok")
    public String okNewPassword(@Valid NewPasswordForm newPasswordForm, Errors errors, Principal principal) {
        if (errors.hasErrors()) {
            return "newPasswordForm";
        }
        if (!newPasswordForm.getPassword().equals(newPasswordForm.getPasswordConfirmation())) {
            return "newPasswordForm";
        }
        accountDao.update(principal.getName(), newPasswordForm.getPassword());
        return "redirect:/account/show";
    }
}
