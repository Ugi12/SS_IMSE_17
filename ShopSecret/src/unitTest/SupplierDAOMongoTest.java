package unitTest;

import org.junit.Test;

import junit.framework.TestCase;
import model.Supplier;
import mongoDao.SupplierDAO;

public class SupplierDAOMongoTest extends TestCase{

	SupplierDAO supplierDao = new SupplierDAO();
	
	@Test
	public void testCreateSupplier(){
		Supplier s = new Supplier();
		s.setName("Ugi da Expesser");
		supplierDao.create(s);
	}
	
	@Test
	public void testDeleteSupplier(){
		Supplier s = new Supplier();
		s.setId(2);
		//supplierDao.delete(s);
	}
}
