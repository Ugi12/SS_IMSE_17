package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;


/**
 * Servlet implementation class Helloworld
 */
@WebServlet("/Helloworld")
public class Helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private DBManager db = DBManager.getInstance();   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in helloworld servlet");
//		request.setAttribute("allCustomer", db.getCustomerDAO().findAll());
		request.getRequestDispatcher("/WEB-INF/helloworld.jsp").forward(request, response);
	}

	

}
