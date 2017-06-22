package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;
import model.Customer;



@WebServlet("/register")
public class RegistrierungController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private DBManager db = DBManager.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/registrierung.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Customer> customers = db.getCustomerDAO().findAll();
		
		String firstname =request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		String email =request.getParameter("email");
		String address =request.getParameter("adress");
		String city =request.getParameter("city");
		String country =request.getParameter("country");
		String password =request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		
	 	
		if(!password.equals(password2)){
			throw new ServletException("Passwörter sind nicht gleich!");
		}
		
		for (Customer c : customers) {
			if(c.getEmail().equals(email)) {
				throw new ServletException("Benutzer mit dieser E-Mail gibt es schon!");
			}
		}
		
		Customer customer = new Customer();
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setCountry(country);
		customer.setPassword(password);
		
		db.getCustomerDAO().create(customer);
		
		response.sendRedirect(request.getContextPath() + "/login");


	}
}
