package conference.domain;

import java.util.Date;

/**
 * Message.
 */
public class Message {
    private String userName;
    private String text;
    private Date time;

    public Message(String userName, String text, Date time) {
        this.userName = userName;
        this.text = text;
        this.time = time;
    }
}
