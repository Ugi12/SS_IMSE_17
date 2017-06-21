package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;
import dao.DBManager;
import model.Customer;

@WebServlet("/register")
public class RegistrierungController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	DBManager db = DBManager.getInstance();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Customer> customers = db.getCustomerDAO().findAll();
		
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/WEB-INF/registrierung.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("event").equals("Registrieren")) {
			Customer c = new Customer();
			String firstname =request.getParameter("Vorname");
			String lastname =request.getParameter("Nachname");
			String email =request.getParameter("RegisterEmail");
			String birthday =request.getParameter("Geburtstag");
			String address =request.getParameter("Adresse");
			String city =request.getParameter("Stadt");
			String country =request.getParameter("Land");
			String password =request.getParameter("Passwort");
			String password2 = request.getParameter("Passwort2");
			
			c.setFirstname(firstname);
			c.setLastname(lastname);
			c.setEmail(email);
			c.setBirthday(birthday);
			c.setAddress(address);
			c.setCity(city);
			c.setCountry(country);
			c.setPassword(password);
			c.setPassword2(password2);
			
			db.getCustomerDAO().create(c);
		}
	}
}
