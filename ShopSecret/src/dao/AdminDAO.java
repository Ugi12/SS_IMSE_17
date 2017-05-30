package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Customer;
import model.Supplier;

public class AdminDAO implements DAO<Admin> {

	private DBManager db;

	protected AdminDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Admin object) {

		
	}

	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAll() {
		List<Admin> output = new ArrayList<>();
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from admin order by username");

			while (result.next())
				output.add(parse(result));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void update(Admin object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin object) {
		// TODO Auto-generated method stub
		
	}
	
	private Admin parse(ResultSet result) throws SQLException {
		Admin admin = new Admin();
		admin.setUsername(result.getString("username"));
		admin.setPassword(result.getString("password"));

		return admin;
	}

}
