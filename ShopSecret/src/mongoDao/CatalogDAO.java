package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dao.DAO;
import helper.MongoDBHelper;
import helper.NextId;
import model.Catalog;

/**
 * <h1> CatalogDao</h1>
 * CRUD-Funktions for Catalog
 * 
 * @author Ugur Yürük
 */
public class CatalogDAO implements DAO<Catalog>{

	MongoDatabase db = DBManager.getDatabase();

	/**
	 * Create a new Catalog-Collection in MongoDB
	 * 
	 */
	@Override
	public void create(Catalog c) {
		db.getCollection("Catalog").insertOne(new Document().append("_id", NextId.getNextId("Catalog"))
															.append("name", c.getName()));
	}

	
	@Override
	public Catalog findById(int id) {
		throw new RuntimeException("not implemented yet");
	}
	
	
	/**
	 * Returns a list of all Catalogs from MongoDB
	 */
	@Override
	public List<Catalog> findAll() {
		
		List<Catalog> output = new ArrayList<>();
		
		MongoCollection<Document> collection = DBManager.getDatabase().getCollection("Catalog");
		
		List<Document> catalogs = collection.find().into(new ArrayList<Document>());
		
		for(Document document: catalogs){
			output.add(MongoDBHelper.parseCatalog(document));
		}
		return output;
	}

	
	@Override
	public void update(Catalog object) {
		throw new RuntimeException("not implemented yet");
	}

	/**
	 * Delete specific Catalog from MongoDB
	 */
	@Override
	public void delete(Catalog c) {
		try{
			Document query = new Document("name", c.getName());
					
			db.getCollection("Catalog").deleteOne(query);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
