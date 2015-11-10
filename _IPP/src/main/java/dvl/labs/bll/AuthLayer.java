package dvl.labs.bll;

import dvl.labs.common.User;
import org.json.JSONObject;

/**
 * Created by iura on 11/5/15.
 */
public interface AuthLayer {
    JSONObject register(User user);

    JSONObject login(User user);

    JSONObject getLastEntry(User user);
}
