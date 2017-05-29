package dao;

import java.util.List;

import model.Admin;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Admin object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin object) {
		// TODO Auto-generated method stub
		
	}

}
