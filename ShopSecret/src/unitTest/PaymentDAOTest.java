package unitTest;

import java.util.List;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Payment;

/**
 * @author Ugur Yürük
 */
public class PaymentDAOTest extends TestCase{

	private DBManager db = DBManager.getInstance();
	
	@Test
	public void testCreate(){
		Payment payment = new Payment();
		payment.setCustomerid(1);
		payment.setDetails("Studentenangebot (free shipping)");
		payment.setTotal(111);
		db.getPaymentDAO().create(payment);
		
		List<Payment> payments = db.getPaymentDAO().findAll();
		for(Payment p : payments){
			if(p.getTotal()==111){
				assertEquals("Studentenangebot (free shipping)", p.getDetails());
			}
		}
	}
	
	
}
