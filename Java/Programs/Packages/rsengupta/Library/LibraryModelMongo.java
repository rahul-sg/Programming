package Packages.rsengupta.Library;

import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;

import Packages.rsengupta.Library.User;
import Packages.rsengupta.Library.Book;
import Packages.rsengupta.Library.CD;
import Packages.rsengupta.Library.Library;

import java.util.*;


public class LibraryModelMongo {
	DBCollection userTable;
	public DBCollection bookTable;
	public DBCollection cdTable;
	HashMap<String, User> userMap;
	HashMap<String, Book> books;
	HashMap<String, CD> cds;
	
	BasicDBObject userRow;

	public BasicDBObject bookRow;

	public LibraryModelMongo(HashMap<String, User> userMap,
				 HashMap<String, Book> books,
				 HashMap<String, CD> cds) {
		MongoClient client = new MongoClient();
		DB dataBase = client.getDB("Library");
		userTable = dataBase.getCollection("UserTable");
		cdTable = dataBase.getCollection("CDTable");
		bookTable = dataBase.getCollection("BookTable");
		this.userMap = userMap;
		this.books = books;
		this.cds = cds;
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

	public void update_book(String title) {
		BasicDBObject ref = new BasicDBObject();
		BasicDBObject keys = new BasicDBObject();

		keys.append("bookTitle", true);
		keys.append("bookCount", true);

		DBCursor cursor = bookTable.find(ref, keys);
		Integer countVal;
		String titleVal;
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			titleVal = (String) obj.get("bookTitle");
			if (title.equals(titleVal)) {
				DBObject query, update;

				countVal = (Integer) obj.get("bookCount");
				countVal--;
				if (countVal <= 0) {
					countVal++;
					break;
				}

				query = new BasicDBObject("bookTitle", title);
				update = new BasicDBObject();
				update.put("$set", new BasicDBObject(
							"bookCount", countVal));
				WriteResult result = bookTable.update(query, 
								      update);
				break;
			}
		}
	}

	public void return_book(String title) {
		BasicDBObject ref = new BasicDBObject();
		BasicDBObject keys = new BasicDBObject();

		keys.append("bookTitle", true);
		keys.append("bookCount", true);

		DBCursor cursor = bookTable.find(ref, keys);
		Integer countVal;
		int countMax = books.get(title).getCount();
		String titleVal;
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			titleVal = (String) obj.get("bookTitle");
			if (title.equals(titleVal)) {
				DBObject query, update;

				countVal = (Integer) obj.get("bookCount");
				countVal++;
				if (countVal >= countMax) {
					countVal--;
					break;
				}

				query = new BasicDBObject("bookTitle", title);
				update = new BasicDBObject();
				update.put("$set", new BasicDBObject(
							"bookCount", countVal));
				WriteResult result = bookTable.update(query,
								      update);
				break;
			}
		}

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

//
	public void write_chkOB(String title) {
		BasicDBObject ref = new BasicDBObject();
		BasicDBObject keys = new BasicDBObject();
		keys.append("bookTitle", true);

		Book bk = books.get(title);
		//BasicDBObject chkOB = new BasicDBObject();

		DBCursor cursor = bookTable.find(ref, keys);
		String titleVal;
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			titleVal = (String) obj.get("bookTitle");
			if (title.equals(titleVal)) {
				userRow.put("checkedOutBook", bk.getTitle());
				userTable.insert(userRow);
				break;
			}
		}
	}

/*	public void populate_chkOB(String[] checkedOutBooks) {
		BasicDBObject ref = new BasicDBObject();
		BasicDBObject keys = new BasicDBObject();
		keys.append("bookName", true);
		
		DBCursor cursor = bookTable.find(ref, keys);
		
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			for (int i = 0; i < checkedOutBooks.length; i++) {
				String title = (String) obj.get("bookName");
				checkedOutBooks[i] = title;
			}
			
		}
	}*/
//

	public void write_cd(String title, String author, String isbn,
			       String description, int borrowTime,
			       boolean bluray, String artist, int count) {
		BasicDBObject cdRow;

		cdRow = new BasicDBObject();
		cdRow.put("cdTitle", title);
		cdRow.put("cdAuthor", author);
		cdRow.put("cdISBN", isbn);
		cdRow.put("cdDescription", description);
		cdRow.put("cdBT", borrowTime);
		cdRow.put("cdBluray", bluray);
		cdRow.put("cdArtist", artist);
		cdRow.put("cdCount", count);
		cdTable.insert(cdRow);
	}

	public void update_cd(String title) {
		BasicDBObject ref = new BasicDBObject();
		BasicDBObject keys = new BasicDBObject();

		keys.append("cdTitle", true);
		keys.append("cdCount", true);

		DBCursor cursor = cdTable.find(ref, keys);
		Integer countVal;
		String titleVal;
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			titleVal = (String) obj.get("cdTitle");
			if (title.equals(titleVal)) {
				countVal = (Integer) obj.get("cdCount");
				countVal--;
				if (countVal <= 0) {
					countVal++;
					break;
				}
				DBObject query = new BasicDBObject("cdTitle",
								   title);
				DBObject update = new BasicDBObject();
				update.put("$set", new BasicDBObject("cdCount",
								     countVal));
				WriteResult result = cdTable.update(query, 
								    update);
				break;
			}
		}
	}
	
	public void return_cd(String title) {
		BasicDBObject ref = new BasicDBObject();
		BasicDBObject keys = new BasicDBObject();

		keys.append("cdTitle", true);
		keys.append("cdCount", true);

		DBCursor cursor = cdTable.find(ref, keys);
		Integer countVal;
		int countMax = cds.get(title).getCount();
		String titleVal;
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			titleVal = (String) obj.get("cdTitle");
			if (title.equals(titleVal)) {
				DBObject query, update;

				countVal = (Integer) obj.get("cdCount");
				countVal++;
				if (countVal >= countMax) {
					countVal--;
					break;
				}

				query = new BasicDBObject("cdTitle", title);
				update = new BasicDBObject();
				update.put("$set", new BasicDBObject(
							"cdCount", countVal));
				WriteResult result = cdTable.update(query,
								      update);
				break;
			}
		}

	}

	public void view_cds() {
		BasicDBObject cdRow;
		cdRow = new BasicDBObject();

		DBCursor cursor = userTable.find(cdRow);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

	}

	public void populate_cds(HashMap<String, CD> cds) {
		BasicDBObject ref = new BasicDBObject();
		BasicDBObject keys = new BasicDBObject();
		keys.append("cdTitle", true);
		keys.append("cdAuthor", true);
		keys.append("cdISBN", true);
		keys.append("cdDescription", true);
		keys.append("cdBT", true);
		keys.append("cdBluray", true);
		keys.append("cdArtist", true);
		keys.append("cdCount", true);

		DBCursor cursor = cdTable.find(ref, keys);

		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			String titleValue = (String) obj.get("cdTitle");
			String authorValue = (String) obj.get("cdAuthor");
			String isbnValue = (String) obj.get("cdISBN");
			String desValue = (String) obj.get("cdDescription");
			Integer btValue = (Integer) obj.get("cdBT");
			Boolean blValue = (Boolean) obj.get("cdBluray");
			String arValue = (String) obj.get("cdArtist");
			Integer ctValue = (Integer) obj.get("cdCount");
			CD cd = new CD(titleValue, authorValue,
					     isbnValue, desValue,
					     btValue.intValue(),
					     blValue.booleanValue(),
					     arValue,
					     ctValue.intValue());
			cds.put(titleValue, cd);
		}
	}
}
