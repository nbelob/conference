package conference.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageForm {
    @NotNull
    @NotEmpty(message = "{text.empty}")
    @Size(min = 1, max = 140, message = "{text.size}")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
