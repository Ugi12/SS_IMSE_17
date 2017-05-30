package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LoginController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Benutzerverwaltung benutzerverwaltung = new Benutzerverwaltung();
		String LoginEmail =request.getParameter("LoginName");
		String LoginPasswort =request.getParameter("LoginPasswort");
		HttpSession session = request.getSession();
		
		int id = 0;
		boolean anmelden = benutzerverwaltung.anmelden(LoginEmail, LoginPasswort);
		if (anmelden == false) {
			throw new ServletException("Name und Passwort stimmen nicht überein oder sie existieren nicht!");
		}	
	}

}
