package dvl.labs.common;

import org.bson.Document;

/**
 * Created by iura on 11/4/15.
 */
public class UserMapper {

    public static User convertDocumentToUser(Document document) {
        User user = new User();
        user.app_id = document.getString("app_id");
        user.email = document.getString("email");
        user.lastEntry = document.getLong("last_entry");
        user.nameSurename = document.getString("name_surename");
        user.password = document.getString("password");
        user.token = document.getString("token");

        return user;

    }

    public static Document convertUserToDocument(User user) {
        Document document = new Document("app_id", user.app_id)
                .append("email", user.email)
                .append("password", user.password)
                .append("name_surename",user.nameSurename)
                .append("token", user.token)
                .append("last_entry", user.lastEntry);
        return document;
    }
}
