package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.Product;


/**
 * <h1> ProductDAO</h1>
 * CRUD-Funktions for Admin
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class ProductDAO implements DAO<Product> {

	
	private DBManager db;

	protected ProductDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Product p) {
		if (p == null)
			throw new IllegalArgumentException("object missing");
		if (p.getName() == null || p.getName().trim().length() < 3)
			throw new IllegalArgumentException("email too short");

		
		String sql = (null+", '"+p.getName()+"', '"+p.getPrice()+"', '"+p.getSupplierid()+"'");
		
		try {
			db.getConnection().createStatement().executeUpdate("INSERT INTO product(id,name,price,supplierid) VALUES("+ sql +");");
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("Product already in use");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Product findById(int id) {
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("SELECT * FROM product WHERE id=" +id);

			if (result.next())
				return parse(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> findAll() {
		List<Product> output = new ArrayList<>();
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from product order by id");

			while (result.next())
				output.add(parse(result));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void update(Product object) {
		throw new RuntimeException("not implemented yet");		
	}

	@Override
	public void delete(Product object) {
		throw new RuntimeException("not implemented yet");		
	}
	
	private Product parse(ResultSet result) throws SQLException {
		Product product = new Product();
		product.setId(result.getInt("id"));
		product.setName(result.getString("name"));
		product.setPrice(result.getFloat("price"));
		product.setSupplierid(result.getInt("supplierid"));

		return product;
	}

}
