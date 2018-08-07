import java.util.*;
import com.mongodb.client.MongoDatabase; 
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class DBTest {
	public static void main (String args[]) {
	
	Scanner sc = new Scanner (System.in);
	System.out.print("Enter your favorite Color: ");
	String color = sc.nextLine();
	System.out.print("Enter your favorite Food: ");
	String food = sc.nextLine();
	System.out.println("Your favorite color is " + color);
	System.out.println("Your favorite food is " + food);
	
	//String color = "green";
	//String food = "orange chicken";
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);

			DB dataBase = mongo.getDB("testDB");

			DBCollection table = dataBase.getCollection("input");

			BasicDBObject document = new BasicDBObject();

			document.put("color", color);
			document.put("food", food);
			document.put("date", new Date());
			table.insert(document);

			DBCursor cursor2 = table.find(document);

			while (cursor2.hasNext()) {
				System.out.println(cursor2.next());
			}

		/*} catch (UnknownHostException e) {
			e.printStackTrace();*/
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}
}
