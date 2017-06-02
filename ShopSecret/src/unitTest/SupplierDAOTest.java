package unitTest;

import java.util.List;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Supplier;

/**
 * @author Ugur Yürük
 */
public class SupplierDAOTest extends TestCase{
	
	private DBManager db = DBManager.getInstance();
	
	@Test
	public void testCreate(){
		Supplier supplier = new Supplier();
		supplier.setName("UPS");
		//db.getSuplierDAO().create(supplier);
		
		List<Supplier> suppliers = db.getSuplierDAO().findAll();
		for(Supplier s : suppliers){
			if(s.getId()==2){
				assertEquals("UPS", s.getName());
			}
		}
	}
	
	@Test
	public void testDelete(){
		Supplier supplier = new Supplier();
		supplier = db.getSuplierDAO().findById(2);
		db.getSuplierDAO().delete(supplier);
		
	}
}
