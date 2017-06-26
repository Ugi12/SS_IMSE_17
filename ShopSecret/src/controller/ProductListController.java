package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;
import dao.LineitemDAO;
import model.Cart;
import model.Lineitem;
import mongoDao.CartDAO;
import mongoDao.CustomerDAO;
import mongoDao.ProductDAO;

/**
 * Servlet implementation class for listing products
 *
 * @author yemrekanitoglu
 */
@WebServlet("/products")
public class ProductListController extends HttpServlet {
	
	private DBManager db = DBManager.getInstance();

	private ProductDAO productMongoDAO = new ProductDAO();
	private CartDAO cartDAO = new CartDAO();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("type").equals("man")){
			
			request.setAttribute("productType","Männer Produkten");
			
			//SQL
			//request.setAttribute("productList", db.getProductDAO().findAllManProduct());
			
			//MONGO
			request.setAttribute("productList", productMongoDAO.findAllManProduct());
	
		} else {
			request.setAttribute("productType","Frauen Produkten");
			
			//SQL
			//request.setAttribute("productList", db.getProductDAO().findAllWomanProduct());
			
			//MONGO
			request.setAttribute("productList", productMongoDAO.findAllWomanProduct());
		}
		
		//TODO change customer id dynamic
		//MONGO
		request.setAttribute("lineItems", cartDAO.findAllLineItemsByCustomerId(1));
		request.setAttribute("cart", cartDAO.findByCustomerId(1));
		request.getRequestDispatcher("/WEB-INF/productList.jsp").forward(request, response);
		
	}
	
	//cart 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if(request.getParameter("typ").equals("cart")){
			//to cart
			
			boolean oldElement = false;
			
			//TODO change dynamic
			Cart cart = cartDAO.findByCustomerId(1);
			if (cart == null) {
				cart = new Cart();
				cart.setCreated(new Date());
				cart.setCustomerid(1);
				cart.setTotal(0);
				cartDAO.create(cart);
			}
			
			int productId = Integer.parseInt(request.getParameter("productId"));
			
			List<Lineitem> items = cartDAO.findAllLineItemsByCustomerId(cart.getCustomerid());
			
			for (Lineitem item : items) {
				if (item.getProduct().getId() == productId) {
					oldElement = true;
					cartDAO.addOrUpdateItemIntoCart(item);
				}
			}
			
			if (!oldElement) {
				Lineitem item = new Lineitem();
				item.setProduct(productMongoDAO.findById(productId));
				item.setQuantity(1);
				item.setCartid(cart.getId());
				cartDAO.addOrUpdateItemIntoCart(item);
			}
			
			
		} else if (request.getParameter("typ").equals("decrease")) {
			//decrease quantity
			int itemId = Integer.parseInt(request.getParameter("itemId"));

			Lineitem item = cartDAO.findLineItemById(itemId);
			cartDAO.removeOrUpdateItemIntoCart(item);
			
		} else if (request.getParameter("typ").equals("increase")){
			//increase quantity
			int itemId = Integer.parseInt(request.getParameter("itemId"));

			Lineitem item = cartDAO.findLineItemById(itemId);
			cartDAO.addOrUpdateItemIntoCart(item);
		} else {
			int itemId = Integer.parseInt(request.getParameter("itemId"));

			Lineitem item = cartDAO.findLineItemById(itemId);
			item.setQuantity(1);
			cartDAO.removeOrUpdateItemIntoCart(item);
		}

		doGet(request, response);
		
	}
	
}
