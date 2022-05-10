package hello.jug.paris.at.agorapulse;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public class Message {

    public static Message create(String author, String body) {
        Message message = new Message();
        message.setAuthor(author);
        message.setBody(body);
        message.setCreated(Instant.now());
        return message;
    }

    private String author;
    private String body;
    private Instant created;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }
}
