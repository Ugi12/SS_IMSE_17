package unitTest;

import java.util.List;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Catalog;

/**
 * @author Ugur Yürük
 */
public class CatalogDAOTest extends TestCase{
	private DBManager db = DBManager.getInstance();
	
	@Test
	public void testcreate(){
		Catalog catalog = new Catalog();
		catalog.setName("Hosen");
		catalog.setArticlequantity(11);
		//db.getCatalogDAO().create(catalog);
		
		List<Catalog> catalogs = db.getCatalogDAO().findAll();
		
		for(Catalog c: catalogs){
			if(c.getName().equals("Hosen")){
				assertEquals(11, c.getArticlequantity());
			}
		}
	}
	
	@Test
	public void testDelete(){
		Catalog catalog = new Catalog();
		catalog.setName("Tshirt");
		db.getCatalogDAO().create(catalog);
		db.getCatalogDAO().delete(catalog);
		
		 List<Catalog> catalogs = db.getCatalogDAO().findAll();
		 
		 for(Catalog c : catalogs){
			 if(c.getName().equals("Tshirt")){
				 assertEquals(false, c.getName());
			 }
		 }
		
	}
}
