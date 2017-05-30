package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Catalog;

/**
 * <h1> CatalogDao</h1>
 * CRUD-Funktions for Catalog elements
 * included DB-query	
 * 
 * @author Ugur Yürük
 */
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
		
		return null;
	}

	@Override
	public List<Catalog> findAll() {
		List<Catalog> output = new ArrayList<>();
		try {
			ResultSet result = db.getConnection().createStatement()
					.executeQuery("select * from catalog order by name");

			while (result.next())
				output.add(parse(result));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void update(Catalog object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Catalog object) {
		// TODO Auto-generated method stub
		
	}
	
	private Catalog parse(ResultSet result) throws SQLException {
		Catalog catalog = new Catalog();
		catalog.setName(result.getString("name"));
		catalog.setArticlequantity(result.getInt("ArticleQuantity"));
	
		return catalog;
	}


}
