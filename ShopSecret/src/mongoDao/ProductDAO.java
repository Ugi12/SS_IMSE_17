package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dao.DAO;
import model.Admin;
import model.Product;


/**
 * <h1> ProductDAO</h1>
 * CRUD-Funktions for Admin
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class ProductDAO implements DAO<Product> {

	

	public void create(Product p) {
		MongoDatabase db = DBManager.getDatabase();
		db.getCollection("Product").insertOne(new Document().append("_id", p.getId())
															.append("name", p.getName())
															.append("price", p.getPrice())
															.append("sex", p.getSex())
															.append("supplierid", p.getSupplierid()));
		
	}

	@Override
	public Product findById(int id) {
		throw new RuntimeException("not implemented yet");
		
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
		
		
	}

	@Override
	public void delete(Product p) {
		
		
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
