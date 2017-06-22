package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import dao.DAO;
import dao.DBManager;
import model.Admin;


/**
 * <h1> AdminDao</h1>
 * CRUD-Funktions for Admin
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class AdminDAO implements DAO<Admin> {

	
	@SuppressWarnings("unused")
	private DBManager db;

	protected AdminDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Admin object) {
		throw new RuntimeException("not implemented yet");
		
	}

	@Override
	public Admin findById(int id) {
		throw new RuntimeException("not implemented yet");
	}

	@Override
	public List<Admin> findAll() {
		List<Admin> output = new ArrayList<>();
		
		MongoCollection<Document> collection = MongoDBManager.getDatabase()
				.getCollection("Admin");
 
		List<Document> admins = (List<Document>) collection.find().into(
				new ArrayList<Document>());
		
		for (Document document : admins) {
			output.add(parse(document));
		}
		
		return output;
	}

	@Override
	public void update(Admin object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin object) {
		throw new RuntimeException("not implemented yet");	
	}
	
	private Admin parse(Document result) {
		Admin admin = new Admin();
		admin.setUsername(result.getString("username"));
		admin.setPassword(result.getString("password"));

		return admin;
	}

}
