package dvl.labs.common;

/**
 * Created by iura on 11/4/15.
 */
public class User {
    public String app_id;
    public String email;
    public String password;
    public String nameSurename;
    public String token;
    public long lastEntry;

    @Override
    public String toString() {
        return "app_id:" + app_id + "," + "email:" + email + "," + "pass:" + password + ","
                + "namesurename:" + nameSurename + "," +
                "token:" + token + "," + "lastentry:" + lastEntry + ",";
    }
}
