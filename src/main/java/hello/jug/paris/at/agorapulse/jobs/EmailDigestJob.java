package hello.jug.paris.at.agorapulse.jobs;

import com.agorapulse.worker.annotation.Consumes;
import com.agorapulse.worker.annotation.Cron;
import com.agorapulse.worker.annotation.FixedRate;
import com.agorapulse.worker.annotation.Produces;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

@Singleton
public class EmailDigestJob {

    private final EmailRepository emailRepository;
    private final EmailSender emailSender;

    public EmailDigestJob(EmailRepository emailRepository, EmailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    @Cron("45 6 * * *")
    @Produces("other-queue")
    public Publisher<String> produceEmailsForDigest() {
        return Flux.fromIterable(emailRepository.getEmailsForDigest());
    }

    @FixedRate("1s")
    @Consumes("other-queue")
    public void sendEmail(String email) {
        emailSender.sendEmail(email, "Zoooooom!!!!");
    }

}
