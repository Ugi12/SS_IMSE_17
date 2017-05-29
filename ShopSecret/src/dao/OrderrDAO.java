package dao;

import java.util.List;

import model.Orderr;

public class OrderrDAO implements DAO<Orderr> {

	
	private DBManager db;

	protected OrderrDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Orderr object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orderr findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orderr> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Orderr object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Orderr object) {
		// TODO Auto-generated method stub
		
	}

}
