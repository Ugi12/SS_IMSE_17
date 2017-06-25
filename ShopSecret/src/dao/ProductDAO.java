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

		
		String sql = (null+", '"+p.getName()+"', '"+p.getPrice()+"', '"+p.getSex()+"', '"+p.getSupplierid()+"'");
		
		try {
			db.getConnection().createStatement().executeUpdate("INSERT INTO product VALUES("+ sql +");");
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
	
	public List<Product> findAllManProduct() {
		return findAllWomanOrManProduct("man");
	}
	
	public List<Product> findAllWomanProduct() {
		return findAllWomanOrManProduct("woman");
	}
	
	private List<Product> findAllWomanOrManProduct(String manOrWoman) {
		List<Product> output = new ArrayList<>();
		
		try {
			ResultSet result = db.getConnection().createStatement().executeQuery("SELECT * FROM product WHERE sex='"+ manOrWoman + "'");

			while (result.next())
				output.add(parse(result));
			
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("Product konnte nicht verändert werden");
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return output;
	}

	@Override
	public void update(Product p) {
		
		if (p == null)
			throw new IllegalArgumentException("object missing");
		
		String sql = ("name='"+p.getName()+"', price='"+p.getPrice()+"', sex='"+p.getSex()+"', supplierid='"+p.getSupplierid()+"'");
		
		try {
			db.getConnection().createStatement().executeUpdate("UPDATE product SET "+sql+" WHERE id="+p.getId());
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("Product konnte nicht verändert werden");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Product p) {
		if (p == null)
			throw new IllegalArgumentException("object missing");
		
		try {
			db.getConnection().createStatement().executeUpdate("DELETE FROM product WHERE id="+ p.getId() +";");
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("Product not exist");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private Product parse(ResultSet result) throws SQLException {
		Product product = new Product();
		product.setId(result.getInt("id"));
		product.setName(result.getString("name"));
		product.setPrice(result.getFloat("price"));
		product.setSupplierid(result.getInt("supplierid"));
		product.setSex(result.getString("sex"));

		return product;
	}

}
