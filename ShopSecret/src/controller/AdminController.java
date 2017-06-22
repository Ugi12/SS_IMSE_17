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

/**
 * Servlet implementation class Admin
 * 
 * @author Ugur Yürük
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DBManager db = DBManager.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> products = db.getProductDAO().findAll();
		List<Catalog> catalogs = db.getCatalogDAO().findAll();
		
		request.setAttribute("products", products);
		request.setAttribute("catalogs", catalogs);
		request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean edited = false;
		
		try{
			
		
			/*
			 * if new product button pushed then create a new product
			 */
			if(request.getParameter("event").equals("createProduct") && request.getParameter("event")!=null){
				Product p = new Product();
				String name = request.getParameter("name");
				String tmp = request.getParameter("price");
				float price = Float.valueOf(tmp);
				String sex = request.getParameter("optradio");
				
				p.setName(name);
				p.setPrice(price);
				p.setSex(sex);
				p.setSupplierid(1);
				
				db.getProductDAO().create(p);
			}
			
			/**
			 * create new catalog
			 */
			if(request.getParameter("event").equals("createCatalog")){
				Catalog c = new Catalog();
				String name = request.getParameter("name");
				c.setName(name);
				db.getCatalogDAO().create(c);
			}
			
			if(request.getParameter("event").equals("delete") && request.getParameter("event")!=null){
				int productId = Integer.parseInt(request.getParameter("productId"));
				List<Product> products = db.getProductDAO().findAll();
				for(Product p : products){
					if(p.getId() == productId){
						db.getProductDAO().delete(p);
					}
				}
			}
			
			
			if(request.getParameter("event").equals("edit") && request.getParameter("event")!=null){
				int productId = Integer.parseInt(request.getParameter("productId_2"));
				Product product = db.getProductDAO().findById(productId);
				request.setAttribute("product", product);
				edited = true;
				RequestDispatcher rd = request.getRequestDispatcher("/editcontroller");
				rd.forward(request, response);
			}
			
			if(request.getParameter("event").equals("deleteCatalog")&& request.getParameter("event")!=null){
				
				
				List<Catalog> catalogs = db.getCatalogDAO().findAll();
				for(Catalog c : catalogs){
					if(c.getName().equals(request.getParameter("catalogName"))){
						db.getCatalogDAO().delete(c);
					}
				}
			
				
			}
		}catch(IllegalArgumentException e){
			request.getSession().setAttribute("error", "ja");
			//response.sendRedirect(request.getContextPath() + "/admin");
		}
		
		if(!edited){
			doGet(request, response);
		}
	}

}
