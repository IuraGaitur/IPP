package dvl.labs.datalayer;


import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dvl.labs.common.User;
import dvl.labs.common.UserMapper;
import dvl.labs.util.ConnectionDetails;
import org.bson.Document;

/**
 * Created by iura on 11/4/15.
 */
public class DbLayerImpl implements DbLayer{

    String userTable = "users";

    public void addUser(User user) {
        MongoCollection collection = MongoDb.getInstance().getCollection(userTable);
        Document document = UserMapper.convertUserToDocument(user);
        collection.insertOne(document);
        long value = collection.count();
        //MongoDb.getInstance().client.close();
    }

    public User getUserDetails(String token) {

        FindIterable<Document> iterable = MongoDb.getInstance().getCollection(userTable).find(new Document("token", token));
        final User[] user = new User[1];
        iterable.forEach(new Block<Document>() {
            public void apply(Document document) {
                user[0] = UserMapper.convertDocumentToUser(document);
            }
        });
        //MongoDb.getInstance().client.close();
        return user[0];
    }

    public User getUserDetails(String email, String password) {

        FindIterable<Document> iterable = MongoDb.getInstance()
                .getCollection(userTable)
                .find(new Document("email", email).append("password", password));
        final User[] user = new User[1];
        iterable.forEach(new Block<Document>() {
            public void apply(Document document) {
                user[0] = UserMapper.convertDocumentToUser(document);
            }
        });
        //MongoDb.getInstance().client.close();
        return user[0];
    }

    public void updateUserDetails(User user) {
        FindIterable<Document> iterable = (FindIterable<Document>) MongoDb.getInstance()
                .getCollection(userTable).updateOne(
                        new Document("email", user.email).append("password", user.password),
                        new Document("last_entry", user.lastEntry));
        //MongoDb.getInstance().client.close();
        return ;
    }
}
