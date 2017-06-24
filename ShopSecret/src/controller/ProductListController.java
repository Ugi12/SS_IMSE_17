package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mongoDao.ProductDAO;

/**
 * Servlet implementation class for listing products
 *
 * @author yemrekanitoglu
 */
@WebServlet("/products")
public class ProductListController extends HttpServlet {

	private ProductDAO productMongoDAO = new ProductDAO();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("type").equals("man")){
			
			request.setAttribute("productType","Männer Produkten");
			request.setAttribute("productList", productMongoDAO.findAllManProduct());
	
		} else {
			request.setAttribute("productType","Frauen Produkten");
			request.setAttribute("productList", productMongoDAO.findAllWomanProduct());
		}
		
		request.getRequestDispatcher("/WEB-INF/productList.jsp").forward(request, response);
		
	}
	
}
