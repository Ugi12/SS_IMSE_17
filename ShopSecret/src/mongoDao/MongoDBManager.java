package mongoDao;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBManager {

	private static MongoDatabase db;
	
	@SuppressWarnings("resource")
	public static MongoDatabase getDatabase() {
		
		if (db == null) {
			
			db = new MongoClient("localhost", 27017).getDatabase("IMSE");
			addDefaultAdmin();
			return db;
		}
		
		return db;
	}
	
	private static void addDefaultAdmin() {
		db.getCollection("Admin").insertOne(new Document()
				.append("username", "admin").append("password", "admin")
				);
	}
}
