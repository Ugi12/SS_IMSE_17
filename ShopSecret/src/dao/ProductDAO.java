package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Orderr;
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
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("SELECT * FROM product WHERE id=" +id);

			if (result.next())
				return parse(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> findAll() {
		List<Product> output = new ArrayList<>();
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from product order by id");

			while (result.next())
				output.add(parse(result));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void update(Product object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product object) {
		// TODO Auto-generated method stub
		
	}
	
	private Product parse(ResultSet result) throws SQLException {
		Product product = new Product();
		product.setId(result.getInt("id"));
		product.setName(result.getString("name"));
		product.setPrice(result.getFloat("price"));
		product.setSupplierid(result.getInt("supplierid"));

		return product;
	}

}
