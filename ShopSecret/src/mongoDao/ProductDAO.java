package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dao.DAO;
import helper.NextId;
import model.Product;


/**
 * <h1> ProductDAO</h1>
 * CRUD-Funktions for Admin
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class ProductDAO implements DAO<Product> {
	
	NextId nextid = new NextId();
	MongoDatabase db = DBManager.getDatabase();

	public void create(Product p) {
		
		db.getCollection("Product").insertOne(new Document().append("_id", nextid.getNextId("Product"))
															.append("name", p.getName())
															.append("price", p.getPrice())
															.append("sex", p.getSex())
															.append("supplierid", p.getSupplierid()));
		
	}

	@Override
	public Product findById(int id) {
		Product product = new Product();
		
		MongoCollection<Document> collection = DBManager.getDatabase().getCollection("Product");
		
		List<Document> products = collection.find().into(new ArrayList<Document>());
		
		for(Document document: products){
			if(document.getInteger("_id") == id){
				product = parse(document);
				return product;
			}
			
		}
		return null;
		
	}

	@Override
	public List<Product> findAll() {
		List<Product> output = new ArrayList<>();
		
		MongoCollection<Document> collection = DBManager.getDatabase().getCollection("Product");
		
		List<Document> products = collection.find().into(new ArrayList<Document>());
		
		for(Document document: products){
			output.add(parse(document));
		}
		return output;
	}

	@Override
	public void update(Product p) {
		
		MongoCollection<Document> collection = DBManager.getDatabase().getCollection("Product");
		
		List<Document> products = collection.find().into(new ArrayList<Document>());
		for(Document document: products){
			if(document.getInteger("_id") == p.getId()){
				db.getCollection("Product").updateOne(document, new Document("$set", 
																new Document().append("name", p.getName())
																			  .append("price", p.getPrice())
																			  .append("sex", p.getSex())
																			  .append("supplierid", p.getSupplierid())));
			}
			
		}
		
		

		
	}

	@Override
	public void delete(Product p) {
		try{
			Document query = new Document("_id", p.getId());
					
			db.getCollection("Product").deleteOne(query);
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}
	
	private Product parse(Document result) {
		Product product = new Product();
		product.setId(result.getInteger("_id"));
		product.setName(result.getString("name"));
		product.setPrice(result.getDouble("price").floatValue());
		product.setSex(result.getString("sex"));
		product.setSupplierid(result.getInteger("supplierid"));

		return product;
	}
	


}
