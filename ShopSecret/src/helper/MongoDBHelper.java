package helper;

import org.bson.Document;

import model.Product;

/**
 * this class provides parser methods for retrieved mongod models
 * 
 * @author yemrekanitoglu
 *
 */
public class MongoDBHelper {

	public static Product parse(Document result) {
		Product product = new Product();
		product.setId(result.getInteger("_id"));
		product.setName(result.getString("name"));
		product.setPrice(result.getDouble("price").floatValue());
		product.setSex(result.getString("sex"));
		product.setSupplierid(result.getInteger("supplierid"));

		return product;
	}
	
}
