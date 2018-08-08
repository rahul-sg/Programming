package Packages.rsengupta.Library;

import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import Packages.rsengupta.Library.User;
import Packages.rsengupta.Library.Library;

import java.util.*;


public class LibraryModelMongo {
	DBCollection userTable;
	HashMap<String, User> userMap;

	public LibraryModelMongo(HashMap<String, User> userMap) {
		MongoClient client = new MongoClient();
		DB dataBase = client.getDB("Library");
		userTable = dataBase.getCollection("UserTable");
		this.userMap = userMap;
	}

	public void write_user(String name, String userName,
			       String DOB, String email) {
		BasicDBObject userRow;

		userRow = new BasicDBObject();
		userRow.put("userFullName", name);
		userRow.put("userName", userName);
		userRow.put("userDOB", DOB);
		userRow.put("userEmail", email);
		userTable.insert(userRow);
	}

	public void view_users() {
		BasicDBObject userRow;
		userRow = new BasicDBObject();

		DBCursor cursor = userTable.find(userRow);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

	}

	public void populate_users(Library lib) {
		BasicDBObject ref = new BasicDBObject();
		BasicDBObject keys = new BasicDBObject();
		keys.append("userFullName", true);
		keys.append("userName", true);
		keys.append("userDOB", true);
		keys.append("userEmail", true);

		DBCursor cursor = userTable.find(ref, keys);

		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			String userFullNameValue = (String) obj.get("userFullName");
			String userNameValue = (String) obj.get("userName");
			String userEmailValue = (String) obj.get("userEmail");
			String userDOBValue = (String) obj.get("userDOB");
			User user = new User(userFullNameValue, userDOBValue,
					     userEmailValue, userNameValue,
					     lib);
			userMap.put(userNameValue, user);
		}
	}
	
}
