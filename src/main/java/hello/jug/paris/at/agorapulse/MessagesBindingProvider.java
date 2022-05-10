package hello.jug.paris.at.agorapulse;

import com.agorapulse.micronaut.console.BindingProvider;
import jakarta.inject.Singleton;

import java.util.Collections;
import java.util.Map;

@Singleton
public class MessagesBindingProvider implements BindingProvider {

    private final MessageService messageService;

    public MessagesBindingProvider(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public Map<String, ?> getBinding() {
        return Collections.singletonMap("messages", messageService);
    }

}
