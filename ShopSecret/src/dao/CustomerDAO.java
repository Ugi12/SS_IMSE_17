package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


import model.Customer;
/**
 * <h1> CustomerDao</h1>
 * CRUD-Funktions for Customer
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class CustomerDAO implements DAO<Customer>{

	private DBManager db;
	
	public CustomerDAO(DBManager db) {
		this.db = db;
	}

	@Override
	public void create(Customer c) {
		if (c == null)
			throw new IllegalArgumentException("object missing");
		if (c.getEmail() == null || c.getEmail().trim().length() < 3)
			throw new IllegalArgumentException("email too short");
		if (c.getPassword() == null || c.getPassword().trim().length() < 3)
			throw new IllegalArgumentException("password too short");
		if (c.getFirstname() == null || c.getFirstname().trim().length() < 3)
			throw new IllegalArgumentException("firstname too short");
		if (c.getLastname() == null || c.getLastname().trim().length() < 3)
			throw new IllegalArgumentException("lastname too short");
		if (c.getAddress() == null || c.getAddress().trim().length() < 3)
			throw new IllegalArgumentException("address too short");
		if (c.getCity() == null || c.getCity().trim().length() < 3)
			throw new IllegalArgumentException("city too short");
		if (c.getCountry() == null || c.getCountry().trim().length() < 3)
			throw new IllegalArgumentException("country too short");

		
		String sql = (null+", '"+c.getEmail()+"', '"+c.getPassword()+"', '"+c.getFirstname() +"','"+c.getLastname()+"', "
						  		+ "'"+c.getAddress()+"', '"+c.getCity()+"', '"+c.getCountry()+"','"+0+"'");
		
		try {
			db.getConnection().createStatement().executeUpdate("INSERT INTO customer(id,email,password,firstname,"
															+ "lastname,address,city,country,isclosed) VALUES("+ sql +");");
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("email already in use");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
	public void update(Customer c) {
		if (c == null)
			throw new IllegalArgumentException("object missing");
		if (c.getEmail() == null || c.getEmail().trim().length() < 3)
			throw new IllegalArgumentException("email too short");
		if (c.getPassword() == null || c.getPassword().trim().length() < 3)
			throw new IllegalArgumentException("password too short");
		if (c.getFirstname() == null || c.getFirstname().trim().length() < 3)
			throw new IllegalArgumentException("firstname too short");
		if (c.getLastname() == null || c.getLastname().trim().length() < 3)
			throw new IllegalArgumentException("lastname too short");
		if (c.getAddress() == null || c.getAddress().trim().length() < 3)
			throw new IllegalArgumentException("address too short");
		if (c.getCity() == null || c.getCity().trim().length() < 3)
			throw new IllegalArgumentException("city too short");
		if (c.getCountry() == null || c.getCountry().trim().length() < 3)
			throw new IllegalArgumentException("country too short");


		
		
		String sql = (null+",'"+c.getEmail()+"','"+c.getPassword()+"','"+c.getFirstname()+"','"+c.getLastname()+"','"+c.getAddress()+"', '"+c.getCity()+"','"+c.getCountry()+"',0");
		
		try {
			//db.getConnection().createStatement().executeUpdate("UPDATE customer VALUES("+ sql +") WHERE id=6;");
			db.getConnection().createStatement().executeUpdate("update customer(id,email,password,firstname,"
															+ "lastname,address,city,country,isclosed) values(null,'changed@live.at','12345678','gio','deStudent','wassergasse','linz','Österreich','0') WHERE id='6'");
			
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("customer not found");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Customer object) {
		throw new RuntimeException("not implemented yet");
		
	}

	private Customer parse(ResultSet result) throws SQLException {
		Customer customer = new Customer();
		customer.setId(result.getInt("id"));
		customer.setFirstname(result.getString("firstname"));
		customer.setLastname(result.getString("lastname"));
		customer.setAddress(result.getString("address"));
		customer.setCity(result.getString("city"));
		customer.setCountry(result.getString("country"));
		customer.setEmail(result.getString("email"));
		customer.setIsClosed(result.getBoolean("isclosed"));
		customer.setPassword(result.getString("password"));

		return customer;
	}

	

}
