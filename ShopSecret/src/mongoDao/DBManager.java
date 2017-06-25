package mongoDao;

import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import model.Admin;

/**
 * DB Connection to MongoDB
 * @author yemrekanitoglu
 *
 */
public class DBManager {
	
	private static MongoDatabase db;
	
	private AdminDAO adminDAO;
	private CatalogDAO catalogDAO;
	private ProductDAO productDao;
	private SupplierDAO supplierDao;
	
	private DBManager() {
		this.adminDAO = new AdminDAO(); 
		this.catalogDAO = new CatalogDAO();
		this.productDao = new ProductDAO();
		this.supplierDao = new SupplierDAO();
	}

	public static MongoDatabase getDatabase() {
		
		if (db == null) {
			
			db = new MongoClient("localhost", 27017).getDatabase("IMSE");
			addDefaultAdmin();
			return db;
		}
		
		return db;
	}
	
	
	/**
	 * Create a default admin if default admin not exist
	 */
	private static void addDefaultAdmin() {
		AdminDAO adminDao = new AdminDAO();
		List<Admin> adminList = adminDao.findAll();
		if(adminList.isEmpty()){
			db.getCollection("Admin").insertOne(new Document()
					.append("username", "admin").append("password", "admin"));
		}
		
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public CatalogDAO getCatalogDAO() {
		return catalogDAO;
	}

	public void setCatalogDAO(CatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}

	public ProductDAO getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}

	public SupplierDAO getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDAO supplierDao) {
		this.supplierDao = supplierDao;
	}
	
}
