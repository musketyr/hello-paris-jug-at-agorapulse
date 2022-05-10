package hello.jug.paris.at.agorapulse;

import com.agorapulse.permissions.PermissionException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
public class MessageExceptionHandler implements ExceptionHandler<PermissionException, HttpResponse<?>> {

    @Override
    public HttpResponse<?> handle(HttpRequest request, PermissionException exception) {
        return HttpResponse.unauthorized();
    }
}
