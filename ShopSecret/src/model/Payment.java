package model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ugur Yürük
 */
public class Payment implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int id;
	private String details;
	private float total;
	private Date paiddate;
	private int customerid;
	
	
	
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
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}
	/**
	 * @return the paiddate
	 */
	public Date getPaiddate() {
		return paiddate;
	}
	/**
	 * @param paiddate the paiddate to set
	 */
	public void setPaiddate(Date paiddate) {
		this.paiddate = paiddate;
	}
	/**
	 * @return the customerid
	 */
	public int getCustomerid() {
		return customerid;
	}
	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	
	
	

}
