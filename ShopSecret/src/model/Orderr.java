package model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ugur Yürük
 */
public class Orderr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private float total;
	private String shipto;
	private Date ordered;
	private Boolean shipped;
	private int paymentid;
	private String status;
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
	 * @return the shipto
	 */
	public String getShipto() {
		return shipto;
	}
	/**
	 * @param shipto the shipto to set
	 */
	public void setShipto(String shipto) {
		this.shipto = shipto;
	}
	/**
	 * @return the ordered
	 */
	public Date getOrdered() {
		return ordered;
	}
	/**
	 * @param ordered the ordered to set
	 */
	public void setOrdered(Date ordered) {
		this.ordered = ordered;
	}
	/**
	 * @return the shipped
	 */
	public Boolean getShipped() {
		return shipped;
	}
	/**
	 * @param shipped the shipped to set
	 */
	public void setShipped(Boolean shipped) {
		this.shipped = shipped;
	}
	/**
	 * @return the paymentid
	 */
	public int getPaymentid() {
		return paymentid;
	}
	/**
	 * @param paymentid the paymentid to set
	 */
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
