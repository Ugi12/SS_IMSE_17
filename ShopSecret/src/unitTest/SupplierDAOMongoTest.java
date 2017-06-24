package unitTest;

import org.junit.Test;

import junit.framework.TestCase;
import model.Supplier;
import mongoDao.SupplierDAO;

/**
 * @author Ugur Yürük
 */
public class SupplierDAOMongoTest extends TestCase{

	SupplierDAO supplierDao = new SupplierDAO();
	
	@Test
	public void testCreateSupplier(){
		Supplier s = new Supplier();
		s.setName("Ugi da ExpressLieferer");
		supplierDao.create(s);
		
		supplierDao.findAll();
	}
	
}
