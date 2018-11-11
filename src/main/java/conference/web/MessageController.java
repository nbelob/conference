package conference.web;

import conference.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/message")
public class MessageController {
    private MessageDao messageDao;

    @Autowired
    public MessageController(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @RequestMapping(value = "/new", method = GET)
    public String newMessage(Model model) {
        model.addAttribute(new MessageForm());

        return "messageForm";
    }

    @RequestMapping(value = "/new", method = POST, params = "ok")
    public String okNewMessage(
            @Valid MessageForm messageForm,
            Errors errors,
            Principal principal) {
        if (errors.hasErrors()) {
            return "messageForm";
        }

        messageDao.add(principal.getName(), messageForm.getText());

        return "redirect:/account/show";
    }

    @RequestMapping(value = "/new", method = POST, params = "cancel")
    public String cancelNewMessage() {
        return "redirect:/account/show";
    }
}