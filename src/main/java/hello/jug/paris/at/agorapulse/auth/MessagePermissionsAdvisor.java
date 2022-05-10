package hello.jug.paris.at.agorapulse.auth;

import com.agorapulse.permissions.PermissionAdvisor;
import com.agorapulse.permissions.PermissionCheckResult;
import hello.jug.paris.at.agorapulse.Message;
import io.micronaut.core.type.Argument;
import jakarta.inject.Singleton;

@Singleton
public class MessagePermissionsAdvisor implements PermissionAdvisor<Message> {

    private final UserProvider userProvider;

    public MessagePermissionsAdvisor(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public Argument<Message> argumentType() {
        return Argument.of(Message.class);
    }

    @Override
    public PermissionCheckResult checkPermissions(String permissionDefinition, Message value, Argument<Message> argument) {
        return userProvider.getCurrentUser().map(user -> {
            if ("create".equals(permissionDefinition)) {
                if (user.getUsername().equals(value.getAuthor())) {
                    return PermissionCheckResult.ALLOW;
                }
                return PermissionCheckResult.DENY;
            }
            return PermissionCheckResult.UNKNOWN;
        }).orElse(PermissionCheckResult.UNKNOWN);
    }
}
