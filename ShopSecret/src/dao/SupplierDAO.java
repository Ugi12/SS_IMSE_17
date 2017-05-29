package dao;

import java.util.List;

import model.Supplier;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Supplier object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Supplier object) {
		// TODO Auto-generated method stub
		
	}

}
