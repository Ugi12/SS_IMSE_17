package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;
import model.Admin;
import model.Customer;
import mongoDao.AdminDAO;
import mongoDao.CustomerDAO;

/**
 * this class is the endpoint for servicing requests from path login
 * 
 * @author Julian Thaler
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private DBManager db = DBManager.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
		
//		if (request.getParameter("logout") != null) {
//
//			// session löschen
//			request.getSession().invalidate();
//			System.out.println("logged out");
//
//			// redirect durchführen
//			response.sendRedirect(request.getContextPath() + "/home");
//			return;
//		}
		
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		request.getSession().invalidate();
		/**
		 * SQL-DB
		 */
		/*List<Admin> adminlist = db.getAdminDAO().findAll();
		List<Customer> customerlist = db.getCustomerDAO().findAll();*/
		/**
		 * Mongo-DB
		 */
		AdminDAO adminDao = new AdminDAO();
		CustomerDAO customerDao = new CustomerDAO();
		List<Admin> adminlist = adminDao.findAll();
		List<Customer> customerlist = customerDao.findAll();
		
		String loginEmail =request.getParameter("loginEmail");
		String loginPasswort =request.getParameter("loginPasswort");
		
		
		Boolean found = false;
		
		
		for(Admin admin : adminlist){
			if(loginEmail.trim().toLowerCase().equals(admin.getUsername()) && loginPasswort.trim().toLowerCase().equals(admin.getPassword())){
				request.getSession().setAttribute("credentials", admin);
				response.sendRedirect("admin");
				found = true;
				break;
			}
		}

		if (!found) {
			for(Customer c : customerlist){
				if(loginEmail.trim().toLowerCase().equals(c.getEmail().trim().toLowerCase()) &&
						loginPasswort.trim().toLowerCase().equals(c.getPassword().trim().toLowerCase())){
			
					request.getSession().setAttribute("credentials", c);
					response.sendRedirect("customer");
					found = true;
				}
			}
		}
		
		if(!found){
			doGet(request,response);
		}
		
			
	}

}
