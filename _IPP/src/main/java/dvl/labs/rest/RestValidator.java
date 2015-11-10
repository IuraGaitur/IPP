package dvl.labs.rest;

import dvl.labs.common.User;
import org.json.JSONObject;

/**
 * Created by iura on 11/9/15.
 */
public class RestValidator {

    public static User checkUserValidity(String message) {
        User user = null;
        message = message.replace("'","");
        try {
            JSONObject json = new JSONObject(message);
            user = new User();
            user.app_id = json.getString("app_id");
            user.password = json.getString("pass");
            user.email = json.getString("email");
            user.nameSurename = json.getString("name_surname");
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return user;

    }

}
