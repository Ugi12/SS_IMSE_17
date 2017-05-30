package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Lineitem;
import model.Orderr;

public class OrderrDAO implements DAO<Orderr> {

	
	private DBManager db;

	protected OrderrDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Orderr object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orderr findById(int id) {
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("SELECT * FROM orderr WHERE id=" +id);

			if (result.next())
				return parse(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Orderr> findAll() {
		List<Orderr> output = new ArrayList<>();
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from orderr order by id");

			while (result.next())
				output.add(parse(result));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void update(Orderr object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Orderr object) {
		// TODO Auto-generated method stub
		
	}
	
	private Orderr parse(ResultSet result) throws SQLException {
		Orderr orderr = new Orderr();
		orderr.setId(result.getInt("id"));
		orderr.setTotal(result.getFloat("total"));
		orderr.setShipto(result.getString("shipto"));
		orderr.setOrdered(result.getDate("ordered"));
		orderr.setShipped(result.getBoolean("shipped"));
		orderr.setPaymentid(result.getInt("paymentid"));
		orderr.setStatus(result.getString("status"));
		orderr.setCustomerid(result.getInt("customerid"));

		return orderr;
	}

}
