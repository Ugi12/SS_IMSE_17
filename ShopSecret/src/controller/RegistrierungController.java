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
import model.Product;

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
		
		CustomerDAO customerdao = new CustomerDAO(null);
		
		//Daten werden von registrierung.jsp geholt
		String firstname =request.getParameter("Vorname");
		String lastname =request.getParameter("Nachname");
		String email =request.getParameter("RegisterEmail");
		String birthday =request.getParameter("Geburtstag");
		String address =request.getParameter("Adresse");
		String city =request.getParameter("Stadt");
		String country =request.getParameter("Land");
		String password =request.getParameter("Passwort");
		String password2 = request.getParameter("Passwort2");
		HttpSession session = request.getSession();
		
		
		if(!password.equals(password2)){
			throw new ServletException("Passw�rter sind nicht gleich!");
		}
		
		for (int i = 0; i<customerdao.findAll().size();i++) {
			if(customerdao.findAll().get(i).getLastname().equals(lastname)) {
				throw new ServletException("Benutzer mit diesem Namen gibt es schon!");
			}
		}

		for (int i = 0; i<customerdao.findAll().size();i++) {
			if(customerdao.findAll().get(i).getEmail().equals(email)) {
				throw new ServletException("Benutzer mit dieser E-Mail gibt es schon!");
			}
		}
		
		//hoechste id wird gesucht, neuer user bekommt eine id um 1 hoeher
		int id = 0;
		for (int i = 0; i<customerdao.findAll().size(); i++) {
			if(customerdao.findAll().get(i).getId() > id) {
			      id = customerdao.findAll().get(i).getId();
			}
		}
		id++;
		session.setAttribute("Id", id);
		
		customerdao.create();
		//email, password, password2, firstname, lastname, address, city, country, birthday
		
		
		//folgender befehl wird benoetigt um email im darauffolgenden jsp zu bekommen		
		session.setAttribute("loginEmail", email);
		Customer customer = customerdao.findById(id);
		session.setAttribute("Customer", customer);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
