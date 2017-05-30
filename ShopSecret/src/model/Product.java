package model;

import java.io.Serializable;

/**
 * @author Ugur Yürük
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String name;
	private float price;
	private int supplierid;
	
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the supplierid
	 */
	public int getSupplierid() {
		return supplierid;
	}
	/**
	 * @param supplierid the supplierid to set
	 */
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	
	
	

}
