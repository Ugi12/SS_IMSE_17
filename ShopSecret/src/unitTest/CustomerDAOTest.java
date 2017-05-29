package unitTest;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Customer;

public class CustomerDAOTest extends TestCase{

	private DBManager db = DBManager.getInstance();
	
	@Test
	public void testFindById(){
		Customer customer = db.getCustomerDAO().findById(2);
		
		assertEquals(2, customer.getId());
		assertEquals("test@mail.com", customer.getEmail());
	}
}
