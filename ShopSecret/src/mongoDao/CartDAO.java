package mongoDao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import dao.DAO;
import helper.MongoDBHelper;
import helper.NextId;
import model.Cart;
import model.Lineitem;
import model.Product;

/**
 * this class provides a services for mongodb implentation of cart dao
 * 
 * @author yemrekanitoglu
 *
 */
public class CartDAO implements DAO<Cart>{

	MongoCollection<Document> collection;
	MongoCollection<Document> itemCollection;
	
	public CartDAO() {
		 collection = DBManager.getDatabase().getCollection("Cart");
		 itemCollection = DBManager.getDatabase().getCollection("Lineitem");
	}
	
	@Override
	public void create(Cart object) {
		object.setId(NextId.getNextId("Cart"));
		collection.insertOne(new Document().append("_id", object.getId())
				.append("customerid", object.getCustomerid())
				.append("total", object.getTotal())
				.append("created", object.getCreated()));

	}
	
	public Cart findByCustomerId(int customerid) {
		List<Document> products = collection.find().into(new ArrayList<Document>());
		
		for(Document document: products){
			if(document.getInteger("customerid") == customerid){
				return MongoDBHelper.parseCart(document);
			}
		}
		return null;
	}

	@Override
	public Cart findById(int id) {
		
		List<Document> products = collection.find().into(new ArrayList<Document>());
		
		for(Document document: products){
			if(document.getInteger("_id") == id){
				return MongoDBHelper.parseCart(document);
			}
		}
		return null;
	}
	
	public Lineitem findLineItemById(int itemId) {
		List<Document> products = itemCollection.find().into(new ArrayList<Document>());
		
		for(Document document: products){
			if(document.getInteger("_id") == itemId){
				return MongoDBHelper.parseItem(document);
			}
		}
		return null;
	}

	@Override
	public List<Cart> findAll() {
		throw new RuntimeException("not implemented yet");
	}

	@Override
	public void update(Cart object) {
		List<Document> carts = collection.find().into(new ArrayList<Document>());
		for(Document document: carts){
			if(document.getInteger("_id") == object.getId()){
				collection.updateOne(document, new Document("$set", 
																new Document().append("created", object.getCreated())
																			  .append("total", object.getTotal())
																			  .append("customerid", object.getCustomerid())));
			}
		}
		
	}

	@Override
	public void delete(Cart object) {
		throw new RuntimeException("not implemented yet");
	}
	
	public List<Lineitem> findAllLineItemsByCustomerId(int customerid) {
		List<Lineitem> items = new ArrayList<>();
		
		Cart cart = findByCustomerId(customerid);
		
		if (cart == null) 
			return items;
		
		List<Document> allItems = itemCollection.find().into(new ArrayList<Document>());
		
		for (Document document : allItems) {
			if (document.getInteger("cartid") == cart.getId()) {
				items.add(MongoDBHelper.parseItem(document));
			}
		}
		
		return items;
	}
	
	public List<Lineitem> findAllLineItemsByCartId(int cartid) {
		List<Lineitem> items = new ArrayList<>();
		
		Cart cart = findById(cartid);
		
		if (cart == null) 
			return items;
		
		List<Document> allItems = itemCollection.find().into(new ArrayList<Document>());
		
		for (Document document : allItems) {
			if (document.getInteger("cartid") == cart.getId()) {
				items.add(MongoDBHelper.parseItem(document));
			}
		}
		
		return items;
	}
	
	public void addOrUpdateItemIntoCart(Lineitem item) {
		List<Document> items = itemCollection.find().into(new ArrayList<Document>());

		for(Document document: items){
			if(document.getInteger("_id") == item.getId()){
				itemCollection.updateOne(document, new Document("$set", 
																new Document().append("quantity", item.getQuantity() + 1)));
				updateCartTotalForCartid(item.getCartid());
				return;
			}
		}
		
		itemCollection.insertOne(new Document().append("_id", NextId.getNextId("Lineitem"))
				.append("productid", item.getProduct().getId())
				.append("quantity", 1)
				.append("cartid", item.getCartid()));
		
		updateCartTotalForCartid(item.getCartid());
	}
	
	public void updateCartTotalForCartid(int cartid) {
		double total = 0;
		for (Lineitem item : findAllLineItemsByCartId(cartid)) {
			total += (double) (item.getProduct().getPrice() * item.getQuantity());
		}
		Cart cart = findById(cartid);
		cart.setTotal(total);
		update(cart);
	}
	
	public void removeOrUpdateItemIntoCart(Lineitem item) {
		List<Document> items = itemCollection.find().into(new ArrayList<Document>());

		for(Document document: items){
			if(item.getQuantity() == 1) {
				break;
			}
			if(document.getInteger("_id") == item.getId()){
				itemCollection.updateOne(document, new Document("$set", 
																new Document().append("quantity", item.getQuantity() - 1)));
				updateCartTotalForCartid(item.getCartid());
				return;
			}
		}
				
		Document query = new Document("_id", item.getId());

		itemCollection.deleteOne(query);
		updateCartTotalForCartid(item.getCartid());
	}
	
}
