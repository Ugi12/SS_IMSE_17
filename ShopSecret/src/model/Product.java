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
	private String sex;
	private int supplierid;
	private String catalogName;
	
	
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
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the catalogName
	 */
	public String getCatalogName() {
		return catalogName;
	}
	/**
	 * @param catalogName the catalogName to set
	 */
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	
	
	

}
