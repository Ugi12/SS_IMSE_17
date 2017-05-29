package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDAO implements DAO<Customer>{

	private DBManager db;
	
	public CustomerDAO(DBManager db) {
		this.db = db;
	}

	@Override
	public void create(Customer object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer findById(int id) {
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("SELECT * FROM customer WHERE id=" +id);

			if (result.next())
				return parse(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> output = new ArrayList<>();
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from customer order by id");

			while (result.next())
				output.add(parse(result));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void update(Customer object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer object) {
		// TODO Auto-generated method stub
		
	}

	private Customer parse(ResultSet result) throws SQLException {
		Customer customer = new Customer();
		customer.setId(result.getInt("id"));
		customer.setFirstname(result.getString("firstname"));
		customer.setLastname(result.getString("lastname"));
		customer.setAddress(result.getString("address"));
		customer.setBirthday(result.getDate("birthday"));
		customer.setCity(result.getString("city"));
		customer.setCountry(result.getString("country"));
		customer.setEmail(result.getString("email"));
		customer.setIsClosed(result.getBoolean("isclosed"));
		customer.setOpen(result.getBoolean("open"));
		customer.setPassword(result.getString("password"));

		return customer;
	}

	

}
