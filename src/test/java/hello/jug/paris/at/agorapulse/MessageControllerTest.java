package hello.jug.paris.at.agorapulse;

import com.agorapulse.gru.Gru;
import com.agorapulse.gru.HttpStatusShortcuts;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static com.agorapulse.gru.HttpStatusShortcuts.UNAUTHORIZED;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MessageControllerTest {

    @Inject
    Gru gru;

    @Test
    void createMessageNoUser() throws Throwable {
        gru.verify(test -> test
                .post("/message", req -> req.json("createRequest.json"))
                .expect(resp -> resp.status(UNAUTHORIZED))
        );
    }

    @Test
    void createMessage() throws Throwable {
        gru.verify(test -> test
                .post("/message", req -> req
                        .json("createRequest.json")
                        .header("x-user", "vlad")
                )
                .expect(resp -> resp.json("createResponse.json"))
        );
    }

}