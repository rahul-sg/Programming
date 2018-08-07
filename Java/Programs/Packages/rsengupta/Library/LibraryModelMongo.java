package Packages.rsengupta.Library;

import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import Packages.rsengupta.Library.User;

import java.util.*;


public class LibraryModelMongo {
	DBCollection userTable;
	BasicDBObject userRow;

	public LibraryModelMongo() {
		MongoClient client = new MongoClient();
		DB dataBase = client.getDB("Library");
		userTable = dataBase.getCollection("UserTable");
	}

	public void write_user(String name, String userName,
			       String DOB, String email) {
		userRow = new BasicDBObject();
		userRow.put("userFullName", name);
		userRow.put("userName", userName);
		userRow.put("userDOB", DOB);
		userRow.put("userEmail", email);
		userTable.insert(userRow);
	}

	public void view_users() {
		DBCursor cursor = userTable.find(userRow);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

	}
	
}
