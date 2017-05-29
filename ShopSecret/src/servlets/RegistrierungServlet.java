package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RegistrierungServlet")
public class RegistrierungServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public RegistrierungServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Benutzerverwaltung benutzerverwaltung = new Benutzerverwaltung();
		
		String RegisterName =request.getParameter("RegisterName");
		String RegisterEmail =request.getParameter("RegisterEmail");
		String RegisterPasswort =request.getParameter("RegisterPasswort");
		String RegisterPasswort2 = request.getParameter("RegisterPasswort2");
		HttpSession session = request.getSession();
		
		
		if(!RegisterPasswort.equals(RegisterPasswort2)){
			throw new ServletException("Passwörter sind nicht gleich!");
		}
		
		for (int i = 0; i<benutzerverwaltung.getAlleBenutzer().size();i++) {
			if(benutzerverwaltung.getAlleBenutzer().get(i).getBenutzerName().equals(RegisterName)) {
				throw new ServletException("Benutzer mit diesem Namen gibt es schon!");
			}
		}

		for (int i = 0; i<benutzerverwaltung.getAlleBenutzer().size();i++) {
			if(benutzerverwaltung.getAlleBenutzer().get(i).getEmailAdresse().equals(RegisterEmail)) {
				throw new ServletException("Benutzer mit dieser E-Mail gibt es schon!");
			}
		}
	}
}
