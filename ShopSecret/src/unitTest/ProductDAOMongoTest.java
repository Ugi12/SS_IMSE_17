package unitTest;

import org.junit.Test;

import helper.NextId;
import junit.framework.TestCase;
import model.Product;
import mongoDao.ProductDAO;

public class ProductDAOMongoTest extends TestCase{

	ProductDAO productDao = new ProductDAO();
	
	@Test
	public void testCreate(){
		
		NextId id = new NextId();
		
		
		Product product = new Product();
		
		product.setId(id.getNextId("Product"));
		product.setName("TestNamead");
		product.setPrice(14f);
		product.setSex("woman");
		product.setSupplierid(2);
	
		//productDao.create(product);
		
	}
	
	@Test
	public void testFindAll(){
		for(Product p : productDao.findAll()){
			System.out.println(p.getId()+" "+p.getName());
		}
		
	}
}
