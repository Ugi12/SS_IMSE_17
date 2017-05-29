package dao;

import java.util.List;

import model.Catalog;

public class CatalogDAO implements DAO<Catalog> {

	
	private DBManager db;

	protected CatalogDAO(DBManager db) {
		this.db = db;
	}
	
	
	@Override
	public void create(Catalog object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Catalog findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Catalog> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Catalog object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Catalog object) {
		// TODO Auto-generated method stub
		
	}

}
