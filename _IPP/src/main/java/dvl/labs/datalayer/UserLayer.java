package dvl.labs.datalayer;

import dvl.labs.common.User;

/**
 * Created by iura on 11/4/15.
 */
public interface UserLayer {

    User login(User user);
    User register(User user);
    User userExists(User user);
    void logEntry(User user);


}
