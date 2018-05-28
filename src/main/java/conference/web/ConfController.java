package conference.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
//@RequestMapping("/")
public class ConfController {

    @RequestMapping(value = "/login", method = GET)
    public String showLoginForm() {
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = POST, params = "registration")
    public String registrationLoginForm() {
        return "redirect:/register";
    }

    @RequestMapping(value = "/login", method = POST, params = "login")
    public String loginLoginForm() {
        //TODO: implement
        return "mainForm";
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm() {
        //TODO: implement
        return "registrationForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistrationForm() {
        //TODO: implement
        return "mainForm";
    }
}
