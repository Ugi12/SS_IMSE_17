package dao;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * this class is the manager implementation of mongodb
 * 
 * @author yemrekanitoglu
 */
public class MongoDBManager {

	private static MongoDatabase db;
	
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
