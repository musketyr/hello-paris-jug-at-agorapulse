package hello.jug.paris.at.agorapulse;

import com.agorapulse.permissions.RequiresPermission;

public interface MessageService {

    @RequiresPermission("create")
    Message save(Message message);

}
