package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import dao.DAO;
import helper.MongoDBHelper;
import helper.NextId;
import model.Customer;


/**
 * <h1> CustomerDAO</h1>
 * CRUD-Funktions for Customer
 * 
 * @author yemrekanitoglu
 */
public class CustomerDAO implements DAO<Customer> {

	private MongoCollection<Document> collection;

	public CustomerDAO() {
		this.collection = DBManager.getDatabase().getCollection("Customer");

	}
	
	@Override
	public void create(Customer object) {
		if (object == null)
			throw new IllegalArgumentException("object missing");
		if (object.getEmail() == null || object.getEmail().trim().length() < 3)
			throw new IllegalArgumentException("email too short");
		if (object.getPassword() == null || object.getPassword().trim().length() < 3)
			throw new IllegalArgumentException("password too short");
		if (object.getFirstname() == null || object.getFirstname().trim().length() < 3)
			throw new IllegalArgumentException("firstname too short");
		if (object.getLastname() == null || object.getLastname().trim().length() < 3)
			throw new IllegalArgumentException("lastname too short");
		if (object.getAddress() == null || object.getAddress().trim().length() < 3)
			throw new IllegalArgumentException("address too short");
		if (object.getCity() == null || object.getCity().trim().length() < 3)
			throw new IllegalArgumentException("city too short");
		if (object.getCountry() == null || object.getCountry().trim().length() < 3)
			throw new IllegalArgumentException("country too short");

		object.setId(NextId.getNextId("Customer"));
		collection.insertOne(new Document().append("_id", object.getId())
				.append("email", object.getEmail())
				.append("password", object.getPassword())
				.append("firstname", object.getFirstname())
				.append("lastname", object.getLastname())
				.append("address", object.getAddress())
				.append("city", object.getCity())
				.append("country", object.getCountry())
				);
	}

	@Override
	public Customer findById(int id) {
		throw new RuntimeException("not implemented yet");
	}

	/**
	 * Returns a list of all customer from MongoDB
	 */
	@Override
	public List<Customer> findAll() {
		List<Customer> output = new ArrayList<>();
		
		MongoCollection<Document> collection = DBManager.getDatabase()
				.getCollection("Customer");
 
		List<Document> customers = (List<Document>) collection.find().into(
				new ArrayList<Document>());
		
		for (Document document : customers) {
			output.add(MongoDBHelper.parseCustomer(document));
		}
		
		return output;
	}

	@Override
	public void update(Customer object) {
		throw new RuntimeException("not implemented yet");
		
	}

	@Override
	public void delete(Customer object) {
		throw new RuntimeException("not implemented yet");	
	}

}
