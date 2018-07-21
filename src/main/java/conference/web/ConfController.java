package conference.web;

import conference.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
//@RequestMapping("/")
public class ConfController {

    private AccountDao accountDao;

    @Autowired
    public ConfController(AccountDao accountDao) {
        this.accountDao = accountDao;
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

        if (accountDao.find(loginForm.getUsername(), loginForm.getPassword())) {
            return "mainForm";
        } else {
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
        if (!registrationForm.getPassword().equals(registrationForm.getConfPassword())) {
            return "registrationForm";
        } else {
            accountDao.add(registrationForm.getUsername(), registrationForm.getPassword());
            return "mainForm";
        }

        /*System.out.println(registrationForm.getUsername());
        System.out.println(registrationForm.getPassword());
        System.out.println(registrationForm.getConfPassword());*/
        //TODO: implement
    }
}
