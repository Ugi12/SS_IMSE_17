package dao;

import java.util.List;

import model.Payment;

public class PaymentDAO implements DAO<Payment> {

	
	private DBManager db;

	protected PaymentDAO(DBManager db) {
		this.db = db;
	}
	
	@Override
	public void create(Payment object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payment findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Payment object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Payment object) {
		// TODO Auto-generated method stub
		
	}

}
