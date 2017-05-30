package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void create(Supplier object) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Supplier object) {
		// TODO Auto-generated method stub
		
	}

	private Supplier parse(ResultSet result) throws SQLException {
		Supplier supplier = new Supplier();
		supplier.setId(result.getInt("id"));
		supplier.setName(result.getString("name"));

		return supplier;
	}
}
