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
import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.CD;
import Packages.rsengupta.Library.Library;

import java.util.*;


public class LibraryModelMongo {
	DBCollection userTable;
	DBCollection bookTable;
	HashMap<String, User> userMap;
	HashMap<String, Book> books;
	HashMap<String, CD> cds;

	public LibraryModelMongo(HashMap<String, User> userMap,
				 HashMap<String, Book> books,
				 HashMap<String, CD> cds) {
		MongoClient client = new MongoClient();
		DB dataBase = client.getDB("Library");
		userTable = dataBase.getCollection("UserTable");
		bookTable = dataBase.getCollection("BookTable");
		this.userMap = userMap;
		this.books = books;
		this.cds = cds;
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

	public void write_book(String title, String author, String isbn,
			       String description, int borrowTime, 
			       String publisher, double price, int count) {
		BasicDBObject bookRow;

		bookRow = new BasicDBObject();
		bookRow.put("bookTitle", title);
		bookRow.put("bookAuthor", author);
		bookRow.put("bookISBN", isbn);
		bookRow.put("bookDescription", description);
		bookRow.put("bookBT", borrowTime);
		bookRow.put("bookPublisher", publisher);
		bookRow.put("bookPrice", price);
		bookRow.put("bookCount", count);
		bookTable.insert(bookRow);
	}

	public void view_books() {
		BasicDBObject bookRow;
		bookRow = new BasicDBObject();

		DBCursor cursor = userTable.find(bookRow);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

	}

	public void populate_books(HashMap<String, Book> books) {
		BasicDBObject ref = new BasicDBObject();
		BasicDBObject keys = new BasicDBObject();
		keys.append("bookTitle", true);
		keys.append("bookAuthor", true);
		keys.append("bookISBN", true);
		keys.append("bookDescription", true);
		keys.append("bookBT", true);
		keys.append("bookPublisher", true);
		keys.append("bookPrice", true);
		keys.append("bookCount", true);

		DBCursor cursor = bookTable.find(ref, keys);

		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			String titleValue = (String) obj.get("bookTitle");
			String authorValue = (String) obj.get("bookAuthor");
			String isbnValue = (String) obj.get("bookISBN");
			String desValue = (String) obj.get("bookDescription");
			Integer btValue = (Integer) obj.get("bookBT");
			String pubValue = (String) obj.get("bookPublisher");
			Double prValue = (Double) obj.get("bookPrice");
			Integer ctValue = (Integer) obj.get("bookCount");
			Book book = new Book(titleValue, authorValue,
					     isbnValue, desValue,
					     btValue.intValue(), pubValue,
					     prValue.doubleValue(),
					     ctValue.intValue());
			books.put(titleValue, book);
		}
	}
}
