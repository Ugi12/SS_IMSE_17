package unitTest;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Cart;

public class CartDAOTest extends TestCase{
	
	private DBManager db = DBManager.getInstance();
	
	@Test
	public void testFindById(){
		Cart cart = db.getCartDAO().findById(1);
		assertEquals(1, cart.getId());
	}

}
