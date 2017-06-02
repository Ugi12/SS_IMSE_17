package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.Supplier;

/**
 * <h1> SupplierDAO</h1>
 * CRUD-Funktions for Supplier
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
public class SupplierDAO implements DAO<Supplier> {

	
	private DBManager db;

	protected SupplierDAO(DBManager db) {
		this.db = db;
	}
	
	
	
	@Override
	public void create(Supplier s) {
		if (s == null)
			throw new IllegalArgumentException("object missing");
		if (s.getName() == null || s.getName().trim().length() < 3)
			throw new IllegalArgumentException("email too short");

		
		String sql = (null+", '"+s.getName()+"'");
		
		try {
			db.getConnection().createStatement().executeUpdate("INSERT INTO supplier(id,name) VALUES("+ sql +");");
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("Supplier already in use");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Supplier findById(int id) {
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("SELECT * FROM supplier WHERE id=" +id);

			if (result.next())
				return parse(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Supplier> findAll() {
		List<Supplier> output = new ArrayList<>();
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from supplier order by id");

			while (result.next())
				output.add(parse(result));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void update(Supplier object) {
		throw new RuntimeException("not implemented yet");		
	}

	@Override
	public void delete(Supplier s) {
		if (s == null)
			throw new IllegalArgumentException("object missing");
		
		try {
			db.getConnection().createStatement().executeUpdate("DELETE FROM supplier WHERE id="+ s.getId() +";");
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("Lineitem not exist");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	private Supplier parse(ResultSet result) throws SQLException {
		Supplier supplier = new Supplier();
		supplier.setId(result.getInt("id"));
		supplier.setName(result.getString("name"));

		return supplier;
	}
}
