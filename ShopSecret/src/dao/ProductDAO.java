package dao;

import java.util.List;

import model.Product;

public class ProductDAO implements DAO<Product> {

	
	private DBManager db;

	protected ProductDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Product object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product object) {
		// TODO Auto-generated method stub
		
	}

}
