package unitTest;

import org.junit.Test;

import junit.framework.TestCase;
import mongoDao.MongoDBManager;

public class MongoDBManagerTest extends TestCase{
	
	@Test
	public void testaddDefaultAdmin(){
		MongoDBManager.getDatabase();
	
	}
}
