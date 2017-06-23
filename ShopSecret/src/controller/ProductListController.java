package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import helper.MongoDBHelper;
import model.Product;
import mongoDao.DBManager;

/**
 * Servlet implementation class for listing products
 *
 * @author yemrekanitoglu
 */
@WebServlet("/products")
public class ProductListController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> productListForMan = new ArrayList<>();
		List<Product> productListForWoman = new ArrayList<>();
		
		MongoCollection<Document> collection = DBManager.getDatabase().getCollection("Product");
		
		List<Document> products = collection.find().into(new ArrayList<Document>());
		
		for(Document document: products){
			Product product = MongoDBHelper.parse(document);
			if (product.getSex().equals("man")) {
				productListForMan.add(product);
			} else {
				productListForWoman.add(product);
			}
			
		}
		
		if(request.getParameter("type").equals("man")){
			
			request.setAttribute("productType","Männer Produkten");
			request.setAttribute("productList", productListForMan);
	
		} else {
			request.setAttribute("productType","Frauen Produkten");
			request.setAttribute("productList", productListForWoman);
		}
		
		request.getRequestDispatcher("/WEB-INF/productList.jsp").forward(request, response);
		
	}
	
}
