package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;
import model.Product;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/editcontroller")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DBManager db = DBManager.getInstance();
    
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("product", request.getAttribute("product"));
		request.getRequestDispatcher("/WEB-INF/editproduct.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isUpdated = false;
		if(request.getParameter("event").equals("updateProduct") && request.getParameter("event")!=null){
			
			Product p = new Product();
			
			p.setName(request.getParameter("name"));
			p.setPrice(Float.parseFloat(request.getParameter("price")));
			p.setSex(request.getParameter("sex"));
			p.setId(Integer.parseInt(request.getParameter("id")));
			p.setSupplierid(Integer.parseInt(request.getParameter("supplierid")));
			db.getProductDAO().update(p);
			isUpdated = true;
			RequestDispatcher rd = request.getRequestDispatcher("/admin");
			rd.forward(request, response);
			
		}
		if(!isUpdated){
			doGet(request, response);
		}
		
	}

}
