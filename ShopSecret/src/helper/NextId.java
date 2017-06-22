package helper;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import mongoDao.DBManager;
/**
 * <h1> NextId</h1>
 * This method returns the next free _id of a collection	
 * @param col is the name of the specific collection
 * 
 * @author Ugur Yürük
 */
public class NextId {
	
	public int getNextId(String col){
		
		int nextid = 0;
		
		MongoCollection<Document> collection = DBManager.getDatabase().getCollection(col);
		
		List<Document> list = collection.find().into(new ArrayList<Document>());
		
		if(list.isEmpty()){
			nextid = 1;
		}else{
			for(Document document: list){
				if(nextid < document.getInteger("_id")){
					nextid = document.getInteger("_id");
				}
				 
			}
		}
		
		
		return ++nextid;
	}
}
