package dvl.labs.datalayer;

import dvl.labs.common.User;
import dvl.labs.util.TokenGenerator;

/**
 * Created by iura on 11/4/15.
 */
public class UserLayerImpl implements UserLayer {

    public DbLayer dbLayer;

    public UserLayerImpl() {
        dbLayer = new DbLayerImpl();
    }

    public User login(User user) {
        User finalUser = dbLayer.getUserDetails(user.email, user.password);
        return finalUser;
    }

    public User register(User user) {
        user.token = TokenGenerator.getNewToken();
        dbLayer.addUser(user);
        User finalUser = dbLayer.getUserDetails(user.email, user.password);
        return finalUser;
    }

    public User userExists(User user) {
        User finalUser = dbLayer.getUserDetails(user.email, user.password);
        return finalUser;
    }

    public void logEntry(User user) {
        dbLayer.updateUserDetails(user);
        return ;
    }


}
