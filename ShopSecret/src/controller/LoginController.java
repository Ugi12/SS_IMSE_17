package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;
import dao.DBManager;
import model.Admin;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LoginController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
	
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		DBManager db = DBManager.getInstance();
		List<Admin> adminlist = db.getAdminDAO().findAll();
		
		CustomerDAO customerdao = new CustomerDAO(null);
		
		String loginEmail =request.getParameter("loginEmail");
		String loginPasswort =request.getParameter("loginPasswort");
		
		
		
		
		System.out.println(loginEmail+" "+loginPasswort);
		HttpSession session = request.getSession();
		
		Boolean found = false;
		
		/*
		 * compare input field with admin table in DB
		 */
		for(Admin a : adminlist){
			if(loginEmail.trim().toLowerCase().equals(a.getUsername()) && loginPasswort.trim().toLowerCase().equals(a.getPassword())){
				response.sendRedirect("admin");
				found = true;
				
			}
			
			
		}
		
		if(!found){
			doGet(request,response);
		}
		
			
	}

}
