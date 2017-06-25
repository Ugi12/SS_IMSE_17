package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;
import model.Catalog;
import model.Product;
import model.Supplier;
import mongoDao.CatalogDAO;
import mongoDao.ProductDAO;
import mongoDao.SupplierDAO;

/**
 * Servlet implementation class Admin
 * 
 * @author Ugur Yürük
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//SQL-DB
	DBManager db = DBManager.getInstance();
	//MONGO-DB
	ProductDAO productDao = new ProductDAO();
	CatalogDAO catalogDao = new CatalogDAO();
	SupplierDAO supplierDao = new SupplierDAO();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SQL-DB
		/*List<Product> products = db.getProductDAO().findAll();
		List<Catalog> catalogs = db.getCatalogDAO().findAll();
		List<Supplier> suppliers = db.getSuplierDAO().findAll();*/
		//MONGO-DB
		List<Product> products = productDao.findAll();
		List<Catalog> catalogs = catalogDao.findAll();
		List<Supplier> suppliers = supplierDao.findAll();
				
		request.setAttribute("products", products);
		request.setAttribute("catalogs", catalogs);
		request.setAttribute("suppliers", suppliers);
		request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean edited = false;
		
		try{
		
			/*
			 * create a new product
			 */
			if(request.getParameter("event").equals("createProduct") && request.getParameter("event")!=null){
				
				Product p = new Product();
				String name = request.getParameter("name");
				String tmp = request.getParameter("price");
				float price = Float.valueOf(tmp);
				String sex = request.getParameter("optradio");
				String catalogName = request.getParameter("catalog");
				String supplierName = request.getParameter("supplierName");
				
				List<Supplier> suppliers = supplierDao.findAll();
				for(Supplier s : suppliers){
					if(s.getName().equals(supplierName)){
						p.setSupplierid(s.getId());
					}
				}
				
				p.setName(name);
				p.setPrice(price);
				p.setSex(sex);
				p.setCatalogName(catalogName);
				
				//SQL-DB
				//db.getProductDAO().create(p);
				
				//MONGO-DB
				productDao.create(p);
			}
			
			/**
			 * create new catalog
			 */
			if(request.getParameter("event").equals("createCatalog")){
				Catalog c = new Catalog();
				String name = request.getParameter("name");
				c.setName(name);
				//SQL
				//db.getCatalogDAO().create(c);
				
				//MONGO
				catalogDao.create(c);
			}
			
			/**
			 * delete product
			 */
			if(request.getParameter("event").equals("delete") && request.getParameter("event")!=null){
				int productId = Integer.parseInt(request.getParameter("productId"));
				//SQL
				//List<Product> products = db.getProductDAO().findAll();
				
				//mongo
				List<Product> products = productDao.findAll();
				for(Product p : products){
					if(p.getId() == productId){
						//SQL-DB
						//db.getProductDAO().delete(p);
						
						//MONGO-DB
						productDao.delete(p);
					}
				}
			}
			
			
			if(request.getParameter("event").equals("edit") && request.getParameter("event")!=null){
				int productId = Integer.parseInt(request.getParameter("productId_2"));
				//SQL-DB
				//Product product = db.getProductDAO().findById(productId);
				//MONGO-DB
				Product product = productDao.findById(productId);
				request.setAttribute("product", product);
				edited = true;
				RequestDispatcher rd = request.getRequestDispatcher("/editcontroller");
				rd.forward(request, response);
			}
			
			/**
			 * delete catalog
			 */
			if(request.getParameter("event").equals("deleteCatalog")&& request.getParameter("event")!=null){
				
				//SQL
				//List<Catalog> catalogs = db.getCatalogDAO().findAll();
				
				//MONGO
				List<Catalog> catalogs = catalogDao.findAll();
				for(Catalog c : catalogs){
					if(c.getName().equals(request.getParameter("catalogName"))){
						//SQL
						//db.getCatalogDAO().delete(c);
						
						//MONGO
						catalogDao.delete(c);
					}
				}
			}
			
			
			/**
			 * create Supplier
			 */
			if(request.getParameter("event").equals("createSupplier") && request.getParameter("event")!=null){
				Supplier supplier = new Supplier();
				supplier.setName(request.getParameter("name"));
				//SQL
				//db.getSuplierDAO().create(supplier);
				//MONGO
				supplierDao.create(supplier);
			}
			
			
			/**
			 * delete Supplier
			 */
			if(request.getParameter("event").equals("deleteSupplier") && request.getParameter("event")!=null){
				Supplier supplier = new Supplier();
				supplier.setName(request.getParameter("supplierName"));
				//SQL
				//List<Supplier> suppliers = db.getSuplierDAO().findAll();
				
				//MONGO
				List<Supplier> suppliers = supplierDao.findAll();
				for(Supplier s : suppliers){
					if(s.getName().equals(request.getParameter("supplierName"))){
						supplier.setId(s.getId());
					}
				}
				
				//SQL
				//db.getSuplierDAO().delete(supplier);
				
				//MONGO
				supplierDao.delete(supplier);
			}
			
		}catch(IllegalArgumentException e){
			request.getSession().setAttribute("error", "ja");
		}
		
		if(!edited){
			doGet(request, response);
		}
	}

}
