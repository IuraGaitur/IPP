package dvl.labs.datalayer;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dvl.labs.util.ConnectionDetails;

/**
 * Created by iura on 11/4/15.
 */
public class MongoDb {

    private static MongoDb _instance;
    MongoClient client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    String mDbName = "psi";


    private MongoDb(){}

    public static MongoDb getInstance() {
        if(_instance == null)
            _instance = new MongoDb();

        return _instance;
    }

    public MongoCollection getCollection(String name) {
        MongoDatabase db = client.getDatabase(mDbName);
        MongoCollection collection = db.getCollection(name);
        return  collection;
    }



}
