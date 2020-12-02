import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[] password = System.console().readPassword();
        char[] secretKey = System.console().readPassword();
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://sysadmin:" + String.valueOf(password) + "@cluster0.j1yj9.mongodb.net/myDB?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("Students");

        MongoCollection<Document> collection = database.getCollection("Students");

        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        // Getting the iterator
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            String tmp = it.next().toString();
            tmp = tmp.substring(tmp.indexOf('{') + 2, tmp.length() - 2);
            String result[] = tmp.trim().split("\\s*,\\s*");

            for(String s : result) {
                String dictField[] = s.split("=", 2);
                if(dictField[1].charAt(dictField[1].length() - 1) == '=') {
                    dictField[1] = TwoWayEncryptor.decrypt(dictField[1], String.valueOf(secretKey));
                }
                System.out.println(dictField[0] + " -> " + dictField[1]);
            }
            System.out.println();
            i++;
        }
    }
}
