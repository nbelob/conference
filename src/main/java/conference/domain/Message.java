package conference.domain;

import java.util.Date;

/**
 * Message.
 */
public class Message {
    private Account account;
    private String text;
    private Date time;

    public Message(Account account, String text, Date time) {
        this.account = account;
        this.text = text;
        this.time = time;
    }
}
