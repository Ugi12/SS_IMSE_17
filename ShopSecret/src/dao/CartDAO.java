package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import model.Cart;

public class CartDAO implements DAO<Cart> {

	private DBManager db;

	protected CartDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Cart object) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cart object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cart object) {
		// TODO Auto-generated method stub
		
	}
	
	private Cart parse(ResultSet result) throws SQLException {
		Cart cart = new Cart();
		cart.setId(result.getInt("id"));
		cart.setCreated(result.getDate("created"));
		cart.setCustomerid(result.getInt("customerid"));
	
		return cart;
	}

}
