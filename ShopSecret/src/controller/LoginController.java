package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		DBManager db = DBManager.getInstance();
		List<Admin> adminlist = db.getAdminDAO().findAll();
		
		
		
		String loginEmail =request.getParameter("loginEmail");
		String loginPasswort =request.getParameter("loginPasswort");

		
		Boolean found = false;
		
		/*
		 * compare input field with admin table in DB
		 */
		for(Admin admin : adminlist){
			if(loginEmail.trim().toLowerCase().equals(admin.getUsername()) && loginPasswort.trim().toLowerCase().equals(admin.getPassword())){
				request.getSession().setAttribute("credentials", admin);
				response.sendRedirect("admin");
				found = true;
				
			}
			
		}
		
		if(!found){
			doGet(request,response);
		}
		
			
	}

}
