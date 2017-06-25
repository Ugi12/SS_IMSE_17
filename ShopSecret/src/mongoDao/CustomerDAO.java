package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import dao.DAO;
import helper.MongoDBHelper;
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
		throw new RuntimeException("not implemented yet");
		
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
