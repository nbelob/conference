package conference.web;

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

    private Map<String, String> accounts = new HashMap<>();

    public ConfController() {
        accounts.put("bnl", "pppppp");
        accounts.put("user", "passuser");
        accounts.put("mp", "passmp");
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

        System.out.println(loginForm.getUsername());
        System.out.println(loginForm.getPassword());

        if (accounts.get(loginForm.getUsername()).equals(loginForm.getPassword())) {
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

        System.out.println(registrationForm.getUsername());
        System.out.println(registrationForm.getPassword());
        System.out.println(registrationForm.getConfPassword());
        //TODO: implement
        return "mainForm";
    }
}
