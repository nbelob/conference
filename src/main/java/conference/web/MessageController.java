package conference.web;

import conference.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    @RequestMapping(value = "/new/{username}", method = GET)
    public String newMessage(Model model) {
        model.addAttribute(new MessageForm());

        return "messageForm";
    }

    @RequestMapping(value = "/new/{username}", method = POST, params = "ok")
    public String okNewMessage(
            @PathVariable String username,
            @Valid MessageForm messageForm,
            Errors errors) {
        if (errors.hasErrors()) {
            return "messageForm";
        }

        messageDao.add(username, messageForm.getText());

        return "redirect:/account/show/{username}";
    }

    @RequestMapping(value = "/new/{username}", method = POST, params = "cancel")
    public String cancelNewMessage() {
        return "redirect:/account/show/{username}";
    }
}