package helper;

import org.bson.Document;

import model.Cart;
import model.Catalog;
import model.Customer;
import model.Lineitem;
import model.Product;
import model.Supplier;
import mongoDao.ProductDAO;

/**
 * this class provides parser methods for retrieved mongod models
 * 
 * @author yemrekanitoglu
 *
 */
public class MongoDBHelper {
	
	private static ProductDAO productDAO = new ProductDAO();

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
	
	public static Customer parseCustomer(Document result) {
		Customer customer = new Customer();
		customer.setId(result.getInteger("_id"));
		customer.setFirstname(result.getString("firstname"));
		customer.setEmail(result.getString("email"));
		customer.setPassword(result.getString("password"));
		return customer;
	}
	
	public static Cart parseCart(Document result) {
		Cart cart = new Cart();
		cart.setCreated(result.getDate("created"));
		cart.setCustomerid(result.getInteger("customerid"));
		cart.setId(result.getInteger("_id"));
		cart.setTotal(result.getDouble("total"));
		return cart;
	}
	
	public static Lineitem parseItem(Document result) {
		Lineitem item = new Lineitem();
		item.setCartid(result.getInteger("cartid"));
		item.setId(result.getInteger("_id"));
		item.setProduct(productDAO.findById(result.getInteger("productid")));
		item.setQuantity(result.getInteger("quantity"));
		
		return item;
	}
	
}
