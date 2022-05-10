package hello.jug.paris.at.agorapulse.jobs;

import jakarta.inject.Singleton;

import java.util.Arrays;
import java.util.List;

@Singleton
public class EmailRepository {

    public List<String> getEmailsForDigest() {
        return Arrays.asList("vlad@agorapulse.com", "ben@agorapulse.com", "szymon@agorapulse.com");
    }

}
