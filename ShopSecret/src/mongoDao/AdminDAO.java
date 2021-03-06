package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import dao.DAO;
import model.Admin;


/**
 * <h1> AdminDao</h1>
 * CRUD-Funktions for Admin
 * 
 * @author Ugur Yürük
 */
public class AdminDAO implements DAO<Admin> {

	private MongoCollection<Document> collection;

	public AdminDAO() {
		this.collection = DBManager.getDatabase().getCollection("Catalog");

	}
	
	@Override
	public void create(Admin object) {
		throw new RuntimeException("not implemented yet");
		
	}

	@Override
	public Admin findById(int id) {
		throw new RuntimeException("not implemented yet");
	}

	/**
	 * Returns a list of all Admins from MongoDB
	 */
	@Override
	public List<Admin> findAll() {
		List<Admin> output = new ArrayList<>();
		
		MongoCollection<Document> collection = DBManager.getDatabase()
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
		throw new RuntimeException("not implemented yet");
		
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
