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
import model.Product;
import model.Supplier;
import mongoDao.CatalogDAO;
import mongoDao.ProductDAO;
import mongoDao.SupplierDAO;


/**
 * @author Ugur Yürük
 * Servlet implementation class EditController
 */
@WebServlet("/editcontroller")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DBManager db = DBManager.getInstance();
	CatalogDAO catalogDao = new CatalogDAO();
	SupplierDAO supplierDao = new SupplierDAO();
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("product", request.getAttribute("product"));
		
		//SQL BASED
		/*request.setAttribute("catalogs", db.getCatalogDAO().findAll());
		request.setAttribute("suppliers", db.getSuplierDAO().findAll());*/
		
		//MONGO DB
		request.setAttribute("catalogs", catalogDao.findAll());
		request.setAttribute("suppliers", supplierDao.findAll());
		request.getRequestDispatcher("/WEB-INF/editproduct.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDao = new ProductDAO();
		Boolean isUpdated = false;
		
		/**
		 * Update Product
		 */
		if(request.getParameter("event").equals("updateProduct") && request.getParameter("event")!=null){
			
			Product p = new Product();
			
			p.setName(request.getParameter("name"));
			p.setPrice(Float.parseFloat(request.getParameter("price")));
			p.setSex(request.getParameter("sex"));
			p.setId(Integer.parseInt(request.getParameter("id")));
			p.setCatalogName(request.getParameter("catalog"));
			
			//SQL
			//List<Supplier> suppliers = db.getSuplierDAO().findAll();
			
			//MONGO
			List<Supplier> suppliers = supplierDao.findAll();
			
			for(Supplier s : suppliers){
				if(s.getName().equals(request.getParameter("supplierName"))){
					p.setSupplierid(s.getId());
				}
			}
			
			//SQL
			//db.getProductDAO().update(p);
			//MONGO
			productDao.update(p);
			isUpdated = true;
			RequestDispatcher rd = request.getRequestDispatcher("/admin");
			rd.forward(request, response);
			
		}
		if(!isUpdated){
			doGet(request, response);
		}
		
	}

}
