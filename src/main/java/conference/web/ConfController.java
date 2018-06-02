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
    public String loginLoginForm(LoginForm loginForm) {
        System.out.println("*" + loginForm.getUsername() + "*");
        System.out.println("*" + loginForm.getPassword() + "*");
        //TODO: implement
        return "mainForm";
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm() {
        //TODO: implement
        return "registrationForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistrationForm(RegistrationForm registrationForm) {
        System.out.println(registrationForm.getUsername());
        System.out.println(registrationForm.getPassword());
        System.out.println(registrationForm.getConfPassword());
        //TODO: implement
        return "mainForm";
    }
}
