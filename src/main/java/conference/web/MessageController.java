package conference.web;

import conference.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
//@RequestMapping("/")
public class MessageController {
    private MessageDao messageDao;

    @Autowired
    public MessageController(MessageDao messageDao) {
        this.messageDao = messageDao;
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
}