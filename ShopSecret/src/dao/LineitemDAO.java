package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.Lineitem;

/**
 * <h1> Lineitem</h1>
 * CRUD-Funktions for Line items
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class LineitemDAO implements DAO<Lineitem> {

	
	private DBManager db;

	protected LineitemDAO(DBManager db) {
		this.db = db;
	}
	
	
	@Override
	public void create(Lineitem object) {
		if (object == null)
			throw new IllegalArgumentException("object missing");
		
		String sql = (null+", '"+object.getQuantity()+"','"+object.getProduct().getId()+"', "
						  		+ "'"+object.getCartid()+"'");
		
		try {
			db.getConnection().createStatement().executeUpdate("INSERT INTO lineitem(id,quantity,product,cartid) VALUES("+ sql +");");
		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
			throw new IllegalArgumentException("item already in use");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Lineitem findById(int id) {
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("SELECT * FROM lineitem WHERE id=" +id);

			if (result.next())
				return parse(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Lineitem> findAll() {
		List<Lineitem> output = new ArrayList<>();
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from lineitem order by id");

			while (result.next())
				output.add(parse(result));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void update(Lineitem object) {
		throw new RuntimeException("not implemented yet");		
	}

	@Override
	public void delete(Lineitem l) {
		if (l == null)
			throw new IllegalArgumentException("object missing");
		
		try {
			db.getConnection().createStatement().executeUpdate("DELETE FROM lineitem WHERE id="+ l.getId() +";");
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("Lineitem not exist");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	private Lineitem parse(ResultSet result) throws SQLException {
		Lineitem lineitem = new Lineitem();
		lineitem.setId(result.getInt("id"));
		lineitem.setQuantity(result.getInt("quantity"));

		lineitem.setProduct(db.getProductDAO().findById(result.getInt("productid")));
		lineitem.setCartid(result.getInt("cartid"));

		return lineitem;
	}

}
