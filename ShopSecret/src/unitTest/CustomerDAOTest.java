package unitTest;

import java.util.List;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Customer;

public class CustomerDAOTest extends TestCase{

	private DBManager db = DBManager.getInstance();
	
	@Test
	public void testFindById(){
		Customer customer = db.getCustomerDAO().findById(2);
		List<Customer> customers = db.getCustomerDAO().findAll();
		assertEquals(2, customer.getId());
		assertEquals("test@mail.com", customer.getEmail());
		
		for(Customer c : customers){
			if(c.getId() == 1){
				assertEquals("ugi@gmail.com", c.getEmail());
			}
		}
	}
}
