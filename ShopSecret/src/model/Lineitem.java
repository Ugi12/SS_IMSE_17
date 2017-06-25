package model;

import java.io.Serializable;


/**
 * @author Ugur Yürük
 */
public class Lineitem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int quantity;
	private int productid;
	private int cartid;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the productid
	 */
	public float getProductid() {
		return productid;
	}
	/**
	 * @param productid the productid
	 */
	public void setProductid(int productid) {
		this.productid = productid;
	}
	/**
	 * @return the cartid
	 */
	public int getCartid() {
		return cartid;
	}
	/**
	 * @param cartid the cartid to set
	 */
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

}
