package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;

@WebServlet("/register")
public class RegistrierungController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public RegistrierungController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/registrierung.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDAO customerdao = new CustomerDAO(null);
		
		String firstname =request.getParameter("Vorname");
		String lastname =request.getParameter("Nachname");
		String email =request.getParameter("RegisterEmail");
		String birthday =request.getParameter("Geburtstag");
		String adress =request.getParameter("Adresse");
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
	}
}
