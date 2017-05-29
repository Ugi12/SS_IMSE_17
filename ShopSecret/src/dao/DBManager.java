package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBManager {

	private static DBManager instance = new DBManager();

	private Connection connection;

	private AdminDAO adminDAO;
	private CartDAO cartDAO;
	private CatalogDAO catalogDAO;
	private CustomerDAO customerDAO;
	private LineitemDAO lineitemDAO;
	private OrderrDAO orderrDAO;
	private PaymentDAO paymentDAO;
	private ProductDAO productDAO;
	private SupplierDAO suplierDAO;
	

	private DBManager() {
		adminDAO = new AdminDAO(this);
		cartDAO = new CartDAO(this);
		catalogDAO = new CatalogDAO(this);
		customerDAO = new CustomerDAO(this);
		lineitemDAO = new LineitemDAO(this);
		orderrDAO = new OrderrDAO(this);
		paymentDAO = new PaymentDAO(this);
		productDAO = new ProductDAO(this);
		suplierDAO = new SupplierDAO(this);

	}

	private void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String user = "sql11176925";
			String password = "TNMqjWPsZp";
			connection = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11176925", user, password);
			System.out.println("DB SUCCESS");
		} catch (Exception e) {
			System.out.println("DATABASE ERROR: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * liefert ein instanz dieser klasse
	 * 
	 * @return instance
	 */
	public static DBManager getInstance() {
		return instance;
	}

	/**
	 * liefert eine verbindung zur datenbank. falls noch keine verbindung zur db
	 * besteht, wird versucht eine neue verbindung aufzubauen: dbexception bei
	 * fehler
	 * 
	 * @throws DBException
	 *             bei fehler bei verbindungsaufbau
	 * 
	 * @return connection
	 */
	protected Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				openConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	
	/**
	 * @return the adminDAO
	 */
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	/**
	 * @return the cartDAO
	 */
	public CartDAO getCartDAO() {
		return cartDAO;
	}

	/**
	 * @return the catalogDAO
	 */
	public CatalogDAO getCatalogDAO() {
		return catalogDAO;
	}

	/**
	 * @return the customerDAO
	 */
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	/**
	 * @return the lineitemDAO
	 */
	public LineitemDAO getLineitemDAO() {
		return lineitemDAO;
	}

	/**
	 * @return the orderrDAO
	 */
	public OrderrDAO getOrderrDAO() {
		return orderrDAO;
	}

	/**
	 * @return the paymentDAO
	 */
	public PaymentDAO getPaymentDAO() {
		return paymentDAO;
	}

	/**
	 * @return the productDAO
	 */
	public ProductDAO getProductDAO() {
		return productDAO;
	}

	/**
	 * @return the suplierDAO
	 */
	public SupplierDAO getSuplierDAO() {
		return suplierDAO;
	}

	
	

}
