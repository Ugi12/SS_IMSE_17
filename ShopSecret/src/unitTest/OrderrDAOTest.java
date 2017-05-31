package unitTest;

import java.util.List;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Orderr;


/**
 * @author Ugur Yürük
 */
public class OrderrDAOTest extends TestCase{
	
	private DBManager db = DBManager.getInstance();
	
	
	@Test
	public void testcreate(){
		Orderr orderr = new Orderr();
		orderr.setTotal(198);
		orderr.setPaymentid(1);
		orderr.setShipto("Sensengasse 44, DG TOP 99");
		orderr.setStatus("Pending");
		orderr.setCustomerid(1);
		db.getOrderrDAO().create(orderr);
		
		List<Orderr> orderlist = db.getOrderrDAO().findAll();
		
		for(Orderr o : orderlist){
			if(o.getTotal()==198){
				assertEquals("Sensengasse 44, DG TOP 99", o.getShipto());
			}
		}
	}
}
