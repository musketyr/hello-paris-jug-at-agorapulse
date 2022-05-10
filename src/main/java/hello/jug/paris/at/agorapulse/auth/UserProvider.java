package hello.jug.paris.at.agorapulse.auth;

import java.util.Optional;

public interface UserProvider {

    Optional<User> getCurrentUser();

}
