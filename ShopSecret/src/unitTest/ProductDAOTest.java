package unitTest;

import java.util.List;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Product;

/**
 * @author Ugur Yürük
 */
public class ProductDAOTest extends TestCase{
	
	private DBManager db = DBManager.getInstance();
	
	@Test
	public void testCreate(){
		Product product = new Product();
		product.setName("Nike Regenjacke");
		product.setPrice(99);
		product.setSupplierid(1);
		//db.getProductDAO().create(product);
		
		List<Product> products = db.getProductDAO().findAll();
		
		for(Product p: products){
			if(p.getName().equals("Nike Regenjacke")){
				assertEquals(1, p.getSupplierid());
			}
		}
	}

}
