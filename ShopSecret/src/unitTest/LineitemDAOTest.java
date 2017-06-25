package unitTest;

import java.util.List;

import org.junit.Test;

import dao.DBManager;
import junit.framework.TestCase;
import model.Lineitem;

/**
 * @author Ugur Yürük
 */
public class LineitemDAOTest extends TestCase{

	private DBManager db = DBManager.getInstance();
	
	@Test
	public void testCreate(){
		
		Lineitem lineitem = new Lineitem();
		lineitem.setProductid(1);
		lineitem.setQuantity(1);
		lineitem.setCartid(1);
		
		//db.getLineitemDAO().create(lineitem);
		
		List<Lineitem> items = db.getLineitemDAO().findAll();
		for(Lineitem item: items){
			if(item.getId()==1){
				assertEquals(1, item.getProductid());
			}
		}
	}
	
	@Test
	public void testDelete(){
		Lineitem l = new Lineitem();
		l.setProductid(1);
		l.setQuantity(1);
		l.setCartid(1);
		//db.getLineitemDAO().create(l);
		
		List<Lineitem> items = db.getLineitemDAO().findAll();
		for(Lineitem item: items){
			if(item.getProductid() == 1){
				db.getLineitemDAO().delete(l);
				
			}
		}

		
		
	}
}
