package mongoDao;

import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import model.Admin;

/**
 * DB Connection to MongoDB
 * @author yemrekanitoglu
 *
 */
public class DBManager {

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
	
	
	/**
	 * Create a default admin if default admin not exist
	 */
	private static void addDefaultAdmin() {
		AdminDAO adminDao = new AdminDAO();
		List<Admin> adminList = adminDao.findAll();
		if(adminList.isEmpty()){
			db.getCollection("Admin").insertOne(new Document()
					.append("username", "admin").append("password", "admin"));
		}
		
	}

	
}
