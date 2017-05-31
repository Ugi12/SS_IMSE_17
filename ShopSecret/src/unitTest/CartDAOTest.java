package unitTest;

import java.util.List;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Cart;

/**
 * @author Ugur Yürük
 */
public class CartDAOTest extends TestCase{
	
	private DBManager db = DBManager.getInstance();
	
	@Test
	public void testFindById(){
		Cart cart = db.getCartDAO().findById(1);
		assertEquals(1, cart.getId());
	}
	
	@Test
	public void testCreate(){
		Cart cart = new Cart();
		cart.setCustomerid(1);
		db.getCartDAO().create(cart);
		
		List<Cart> carts = db.getCartDAO().findAll();
		
		for(Cart c: carts){
			if(c.getId()==2){
				assertEquals(1, c.getCustomerid());
			}
		}
		
	}

}
