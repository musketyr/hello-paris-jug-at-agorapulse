package hello.jug.paris.at.agorapulse;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Post("/")
    public Message create(String author, String body) {
        Message message = Message.create(author, body);
        return messageService.save(message);
    }

}
