package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.Payment;

/**
 * <h1> PaymentDAO</h1>
 * CRUD-Funktions for Payment
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class PaymentDAO implements DAO<Payment> {

	
	private DBManager db;

	protected PaymentDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Payment object) {
		if (object == null)
			throw new IllegalArgumentException("object missing");
		if (object.getDetails() == null || object.getDetails().length() < 3)
			throw new IllegalArgumentException("details too short");

		
		String sql = (null+", '"+object.getDetails()+"', '"+object.getTotal()+"', "+null+",'"+object.getCustomerid()+"'");
		
		try {
			db.getConnection().createStatement().executeUpdate("INSERT INTO payment(id,details,total,paiddate,customerid) VALUES("+ sql +");");
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("payment error");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Payment findById(int id) {
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("SELECT * FROM payment WHERE id=" +id);

			if (result.next())
				return parse(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Payment> findAll() {
		List<Payment> output = new ArrayList<>();
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from payment order by id");

			while (result.next())
				output.add(parse(result));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void update(Payment object) {
		throw new RuntimeException("not implemented yet");		
	}

	@Override
	public void delete(Payment object) {
		throw new RuntimeException("not implemented yet");		
	}
	
	private Payment parse(ResultSet result) throws SQLException {
		Payment payment = new Payment();
		payment.setId(result.getInt("id"));
		payment.setDetails(result.getString("details"));
		payment.setTotal(result.getFloat("total"));
		payment.setCustomerid(result.getInt("customerid"));

		return payment;
	}

}
