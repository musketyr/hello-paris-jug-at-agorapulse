package hello.jug.paris.at.agorapulse.auth;

import io.micronaut.http.context.ServerRequestContext;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class RequestUserProvider implements UserProvider {

    @Override
    public Optional<User> getCurrentUser() {
        return ServerRequestContext.currentRequest().flatMap(req -> {
            return req.getHeaders().get("x-user", String.class);
        }).map(User::new);
    }
}
