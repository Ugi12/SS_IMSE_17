package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dao.DAO;
import helper.MongoDBHelper;
import helper.NextId;
import model.Supplier;

public class SupplierDAO implements DAO<Supplier> {

	MongoDatabase db = DBManager.getDatabase();
	
	@Override
	public void create(Supplier s) {
		db.getCollection("Supplier").insertOne(new Document().append("_id", NextId.getNextId("Supplier"))
															 .append("name", s.getName()));
		
	}

	@Override
	public Supplier findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> findAll() {
		
		List<Supplier> output = new ArrayList<>();
		
		MongoCollection<Document> collection = DBManager.getDatabase().getCollection("Supplier");
		
		List<Document> products = collection.find().into(new ArrayList<Document>());
		
		for(Document document: products){
			output.add(MongoDBHelper.parseSupplier(document));
		}
		return output;
	}

	@Override
	public void update(Supplier object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Supplier object) {
		// TODO Auto-generated method stub
		
	}

}
