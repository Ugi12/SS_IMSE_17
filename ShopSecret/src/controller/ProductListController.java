package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MongoDBManager;
import model.Catalog;
import model.Product;

/**
 * Servlet implementation class for listing products
 *
 * @author yemrekanitoglu
 */
@WebServlet("/products")
public class ProductListController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products;
		
		if(request.getParameter("type").equals("man")){
			
			//products = MongoDBManager.getDatabase()..getProductDAO().findAll();	//search by man		
			request.setAttribute("productType","Männer Produkten");

		} else {
			request.setAttribute("productType","Frauen Produkten");
			//products = db.getProductDAO().findAll(); //search by frau	
		}
		
		request.getRequestDispatcher("/WEB-INF/productList.jsp").forward(request, response);
		
	}
	
}
