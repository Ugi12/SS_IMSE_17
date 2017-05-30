package unitTest;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Customer;

/**
 * @author Ugur Yürük
 */
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
	
	@Test
	public void testcreate() throws ParseException{
		
		Customer customer = new Customer();
		customer.setEmail("ugur@shopsecret.com");
		customer.setPassword("admin");
		customer.setFirstname("ugur");
		customer.setLastname("yuruk");
		customer.setAddress("sensengasse");
		customer.setCity("wien");
		customer.setCountry("Oesterreich");
		
		db.getCustomerDAO().create(customer);
		
		List<Customer> customers = db.getCustomerDAO().findAll();
		for(Customer c: customers){
			if(c.getEmail().equals("ugur@shopsecret.com")){
				assertEquals("ugur", c.getFirstname());
			}
		}
	}
}
