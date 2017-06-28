package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;
import model.Customer;
import mongoDao.CustomerDAO;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	
	
	private DBManager db = DBManager.getInstance();
	
	private CustomerDAO customerDAO = new CustomerDAO();
	
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in CustomerController");
		Customer value = (Customer) request.getSession().getAttribute("credentials");
		System.out.println("Session for : "+value.getEmail());
		
		//TODO hier weiter machen YUNUS 
		
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}


}
