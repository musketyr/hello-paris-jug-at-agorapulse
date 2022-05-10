package hello.jug.paris.at.agorapulse;

import jakarta.inject.Singleton;

@Singleton
public class DefaultMessageService implements MessageService {

    @Override
    public Message save(Message message) {
        return message;
    }

}
