package conference.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/")
public class ConfController {

    @RequestMapping(method = GET)
    public String showLoginForm() {
        return "loginForm";
    }

    @RequestMapping(method = POST, params = "registration")
    public String showRegistrationForm() {
        return "registrationForm";
    }

    @RequestMapping(method = POST, params = "login")
    public String processLoginForm() {
        //TODO: implement
        return null;
    }
}
