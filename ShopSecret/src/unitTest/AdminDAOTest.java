package unitTest;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import model.Admin;
import mongoDao.AdminDAO;

public class AdminDAOTest extends TestCase{
	
	@Test
	public void testFindAll(){
		 
		AdminDAO a = new AdminDAO();
		List<Admin> admins = a.findAll();
		
		for(Admin ad : admins){
			System.out.println(ad.getUsername() +" "+ ad.getPassword());
		}
		
	}
}
