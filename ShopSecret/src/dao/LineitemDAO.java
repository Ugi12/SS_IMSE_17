package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Lineitem;

public class LineitemDAO implements DAO<Lineitem> {

	
	private DBManager db;

	protected LineitemDAO(DBManager db) {
		this.db = db;
	}
	
	
	@Override
	public void create(Lineitem object) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Lineitem object) {
		// TODO Auto-generated method stub
		
	}
	
	private Lineitem parse(ResultSet result) throws SQLException {
		Lineitem lineitem = new Lineitem();
		lineitem.setId(result.getInt("id"));
		lineitem.setQuantity(result.getInt("quantity"));
		lineitem.setPrice(result.getFloat("price"));
		lineitem.setCartid(result.getInt("cartid"));

		return lineitem;
	}

}
