package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.Orderr;

/**
 * <h1> OrderrDAO</h1>
 * CRUD-Funktions for Customers order
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class OrderrDAO implements DAO<Orderr> {

	
	private DBManager db;

	protected OrderrDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Orderr object) {
		if (object == null)
			throw new IllegalArgumentException("object missing");


		
		String sql = (null+", '"+object.getTotal()+"', '"+object.getShipto()+"', "+null+",'"+0+"', "
						  		+ "'"+object.getPaymentid()+"', '"+object.getStatus()+"', '"+object.getCustomerid()+"'");
		
		try {
			db.getConnection().createStatement().executeUpdate("INSERT INTO orderr(id,total,shipto,ordered,"
															+ "shipped,paymentid,status,customerid) VALUES("+ sql +");");
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("Order already in use");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
