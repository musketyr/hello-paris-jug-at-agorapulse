package hello.jug.paris.at.agorapulse.jobs;

import jakarta.inject.Singleton;

@Singleton
public class EmailSender {

    public void sendEmail(String to, String body) {
        System.out.println("sending email to " + to + " body: " + body);
    }

}
