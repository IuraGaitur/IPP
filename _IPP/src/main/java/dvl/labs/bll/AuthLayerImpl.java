package dvl.labs.bll;

import com.mongodb.util.JSON;
import dvl.labs.common.User;
import dvl.labs.datalayer.UserLayerImpl;
import org.json.JSONObject;

/**
 * Created by iura on 11/5/15.
 */
public class AuthLayerImpl implements AuthLayer {

    private UserLayerImpl userLayer;

    public AuthLayerImpl() {
        userLayer = new UserLayerImpl();
    }

    public JSONObject register(User user) {
        System.out.println(user.toString());
        JSONObject object = new JSONObject();
        if (user != null && !user.email.isEmpty() && user.password.length() > 4) {
            User foundUser = userLayer.userExists(user);
            if (foundUser == null) {
                User userDetails = userLayer.register(user);
                userLayer.logEntry(userDetails);
                object.put("code", 0);
                object.put("token", userDetails.token);
            } else {
                object.put("code", 1);
            }
        } else {
            object.put("code", 2);
        }

        return object;
    }

    public JSONObject login(User user) {
        System.out.println(user.toString());
        JSONObject object = new JSONObject();
        if (user != null && !user.email.isEmpty() && user.password.length() > 5) {
            User foundUser = userLayer.userExists(user);
            if (foundUser != null) {
                userLayer.logEntry(foundUser);
                object.put("code", 2);
                object.put("token", foundUser.token);
            } else {
                object.put("code", 0);
            }
        } else {
            object.put("code", 0);
        }

        return object;
    }

    public JSONObject getLastEntry(User user) {
        JSONObject object = new JSONObject();
        if (user != null && !user.token.isEmpty()) {
            User foundUser = userLayer.userExists(user);
            if (foundUser != null) {
                object.put("code", 3);
                object.put("time", foundUser.lastEntry);
            } else {
                object.put("code", 0);
            }
        } else {
            object.put("code", 2);
        }

        return object;
    }
}
