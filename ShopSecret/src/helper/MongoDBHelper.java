package helper;

import org.bson.Document;

import model.Catalog;
import model.Product;
import model.Supplier;

/**
 * this class provides parser methods for retrieved mongod models
 * 
 * @author yemrekanitoglu
 *
 */
public class MongoDBHelper {

	public static Product parseProduct(Document result) {
		Product product = new Product();
		product.setId(result.getInteger("_id"));
		product.setName(result.getString("name"));
		product.setPrice(result.getDouble("price").floatValue());
		product.setSex(result.getString("sex"));
		product.setSupplierid(result.getInteger("supplierid"));
		product.setCatalogName(result.getString("catalogName"));

		return product;
	}
	
	public static Catalog parseCatalog(Document result){
		Catalog catalog = new Catalog();
		catalog.setName(result.getString("name"));
		return catalog;
	}
	
	public static Supplier parseSupplier(Document result){
		Supplier supplier = new Supplier();
		supplier.setId(result.getInteger("_id"));
		supplier.setName(result.getString("name"));
		
		return supplier;
	}
	
}
