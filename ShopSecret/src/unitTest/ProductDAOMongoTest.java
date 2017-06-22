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
	
	@Test
	public void testDeleteProduct(){
		Product product = new Product();
		product.setId(4);
		productDao.delete(product);
	}
	
	@Test
	public void testUpdateProduct(){
		Product product = new Product();
		product.setId(8);
		product.setName("gio");
		product.setPrice(20f);
		product.setSex("woman");
		product.setSupplierid(10);
		productDao.update(product);
	}
	
	@Test
	public void testFindById(){
		Product product = productDao.findById(8);
		System.out.println("oo: "+product.getName());
	}
}
