package unitTest;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import model.Admin;
import mongoDao.AdminDAO;
/**
 * @author Ugur Yürük
 */
public class AdminDAOTest extends TestCase{
	
	@Test
	public void testFindAll(){
		 
		AdminDAO a = new AdminDAO();
		List<Admin> admins = a.findAll();
		
		for(Admin ad : admins){
			if(ad.getUsername().equals("admin")){
				assertEquals("admin", ad.getUsername());
				assertEquals("admin", ad.getPassword());
			}
			
		}
		
	}
}
