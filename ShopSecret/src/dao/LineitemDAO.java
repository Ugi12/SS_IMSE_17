package dao;

import java.util.List;

import model.Lineitem;

public class LineitemDAO implements DAO<Lineitem> {

	
	private DBManager db;

	protected LineitemDAO(DBManager db) {
		this.db = db;
	}
	
	
	@Override
	public void create(Lineitem object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lineitem findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lineitem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Lineitem object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Lineitem object) {
		// TODO Auto-generated method stub
		
	}

}
