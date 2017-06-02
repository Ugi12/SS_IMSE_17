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
		lineitem.setName("calvindick");
		lineitem.setPrice(39);
		lineitem.setQuantity(1);
		lineitem.setCartid(1);
		
		//db.getLineitemDAO().create(lineitem);
		
		List<Lineitem> items = db.getLineitemDAO().findAll();
		for(Lineitem item: items){
			if(item.getId()==1){
				assertEquals(39, item.getPrice());
			}
		}
	}
	
	@Test
	public void testDelete(){
		Lineitem l = new Lineitem();
		l.setName("calvin klein");
		l.setPrice(39);
		l.setQuantity(1);
		l.setCartid(1);
		//db.getLineitemDAO().create(l);
		
		List<Lineitem> items = db.getLineitemDAO().findAll();
		for(Lineitem item: items){
			if(item.getName().equals("calvin klein")){
				db.getLineitemDAO().delete(l);
				
			}
		}

		
		
	}
}
