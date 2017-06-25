package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import dao.DAO;
import helper.MongoDBHelper;
import helper.NextId;
import model.Product;


/**
 * <h1> ProductDAO</h1>
 * CRUD-Funktions for Product
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class ProductDAO implements DAO<Product> {

	MongoCollection<Document> collection;

	public ProductDAO() {
		 collection = DBManager.getDatabase().getCollection("Product");
	}
	
	public void create(Product p) {
		
		collection.insertOne(new Document().append("_id", NextId.getNextId("Product"))
															.append("name", p.getName())
															.append("price", p.getPrice())
															.append("sex", p.getSex())
															.append("supplierid", p.getSupplierid())
															.append("catalogName", p.getCatalogName()));
	}

	/**
	 * Find a specific Product by Id
	 */
	@Override
	public Product findById(int id) {
		Product product = new Product();
				
		List<Document> products = collection.find().into(new ArrayList<Document>());
		
		for(Document document: products){
			if(document.getInteger("_id") == id){
				product = MongoDBHelper.parseProduct(document);
				return product;
			}
		}
		return null;
	}


	/**
	 * Returns a list of all Products from MongoDB
	 */
	@Override
	public List<Product> findAll() {
		List<Product> output = new ArrayList<>();
				
		List<Document> products = collection.find().into(new ArrayList<Document>());
		
		for(Document document: products){
			output.add(MongoDBHelper.parseProduct(document));
		}
		return output;
	}
	
	public List<Product> findAllManProduct() {
		return findAllWomanOrManProduct("man");
	}
	
	public List<Product> findAllWomanProduct() {
		return findAllWomanOrManProduct("woman");
	}
	
	private List<Product> findAllWomanOrManProduct(String manOrWoman) {
		List<Product> output = new ArrayList<>();

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("sex", manOrWoman);
		
		List<Document> products = collection.find(whereQuery).into(new ArrayList<Document>());
		
		for(Document document: products){
			output.add(MongoDBHelper.parseProduct(document));
		}
		return output;
	}
	

	
	/**
	 * Update a specific Product
	 */
	@Override
	public void update(Product p) {
				
		List<Document> products = collection.find().into(new ArrayList<Document>());
		for(Document document: products){
			if(document.getInteger("_id") == p.getId()){
				collection.updateOne(document, new Document("$set", 
																new Document().append("name", p.getName())
																			  .append("price", p.getPrice())
																			  .append("sex", p.getSex())
																			  .append("supplierid", p.getSupplierid())
																			  .append("catalogName", p.getCatalogName())));
			}
		}
		
		
	}

	
	/**
	 * Delete a specific Product
	 */
	@Override
	public void delete(Product p) {
		try{
			Document query = new Document("_id", p.getId());
					
			collection.deleteOne(query);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
