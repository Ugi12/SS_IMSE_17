package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.DefaultButtonModel;

import dao.DBManager;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/customer/*")
public class CustomerController extends HttpServlet {
	
	
	private DBManager db = DBManager.getInstance();
	
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("customer", db.getCustomerDAO().findById(1));
		request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
	}


}
