package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import dao.DAO;
import helper.MongoDBHelper;
import helper.NextId;
import model.Supplier;

public class SupplierDAO implements DAO<Supplier> {

	MongoCollection<Document> collection;

	public SupplierDAO() {
		 collection = DBManager.getDatabase().getCollection("Supplier");
	}
	
	/**
	 * Create a new Supplier-Collection in MongoDB
	 * 
	 */
	@Override
	public void create(Supplier s) {
		collection.insertOne(new Document().append("_id", NextId.getNextId("Supplier"))
															 .append("name", s.getName()));
		
	}

	@Override
	public Supplier findById(int id) {
		throw new RuntimeException("not implemented yet");
	}

	
	/**
	 * Returns a list of all Suppliers from MongoDB
	 */
	@Override
	public List<Supplier> findAll() {
		
		List<Supplier> output = new ArrayList<>();
				
		List<Document> products = collection.find().into(new ArrayList<Document>());
		
		for(Document document: products){
			output.add(MongoDBHelper.parseSupplier(document));
		}
		return output;
	}

	@Override
	public void update(Supplier object) {
		throw new RuntimeException("not implemented yet");
		
	}

	/**
	 * Delete specific Supplier from MongoDB
	 */
	@Override
	public void delete(Supplier s) {
		try{
			Document query = new Document("_id", s.getId());
					
			collection.deleteOne(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
