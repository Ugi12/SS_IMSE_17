package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.Cart;
/**
 * <h1> CartDao</h1>
 * CRUD-Funktions for Cart elements
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class CartDAO implements DAO<Cart> {

	private DBManager db;

	protected CartDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Cart c) {
		if (c == null)
			throw new IllegalArgumentException("object missing");

		
		String sql = (null+", "+null+", '"+c.getCustomerid()+"'");
		
		try {
			db.getConnection().createStatement().executeUpdate("INSERT INTO cart(id,created,customerid) VALUES("+ sql +");");
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("Cart already in use");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Cart findById(int id) {
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from cart where id=" + id);

			if (result.next())
				return parse(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cart> findAll() {
		List<Cart> output = new ArrayList<>();
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from cart order by id");

			while (result.next())
				output.add(parse(result));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void update(Cart object) {
		throw new RuntimeException("not implemented yet");		
	}

	@Override
	public void delete(Cart object) {
		throw new RuntimeException("not implemented yet");		
	}
	
	private Cart parse(ResultSet result) throws SQLException {
		Cart cart = new Cart();
		cart.setId(result.getInt("id"));
		cart.setCreated(result.getDate("created"));
		cart.setCustomerid(result.getInt("customerid"));
	
		return cart;
	}

}
