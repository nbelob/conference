package conference.web;

import conference.dao.AccountDao;
import conference.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
//@RequestMapping("/")
public class ConfController {

    private AccountDao accountDao;
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

        /*System.out.println(loginForm.getUsername());
        System.out.println(loginForm.getPassword());*/
        int r = accountDao.find(loginForm.getUsername(), loginForm.getPassword());
        if (r == 0) {
            return "redirect:/account/" + loginForm.getUsername();
        } else if (r == 1) {
            errors.reject("account.empty", messageSourceAccessor.getMessage("account.empty"));
            return "loginForm";
        } else {
            errors.reject("account.password", messageSourceAccessor.getMessage("account.password"));
            return "loginForm";
        }
        //TODO: implement
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
        if (accountDao.find(registrationForm.getUsername(), "") != 1) {
            errors.reject("account.username", messageSourceAccessor.getMessage("account.username"));
            return "registrationForm";
        } else if (!registrationForm.getPassword().equals(registrationForm.getConfPassword())) {
            return "registrationForm";
        } else {
            accountDao.add(registrationForm.getUsername(), registrationForm.getPassword());
            return "redirect:/account/" + registrationForm.getUsername();
        }

        /*System.out.println(registrationForm.getUsername());
        System.out.println(registrationForm.getPassword());
        System.out.println(registrationForm.getConfPassword());*/
        //TODO: implement
    }

    @RequestMapping(value = "/account/{username}", method = GET)
    public String showAccounts(@PathVariable String username, Model model) {
        List<Message> messages = accountDao.findAllByUsername(username);
        model.addAttribute(username);
        model.addAttribute(messages);
        return "mainForm";
    }
}
