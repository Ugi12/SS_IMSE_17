package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Orderr;
import model.Payment;

public class PaymentDAO implements DAO<Payment> {

	
	private DBManager db;

	protected PaymentDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Payment object) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Payment object) {
		// TODO Auto-generated method stub
		
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
