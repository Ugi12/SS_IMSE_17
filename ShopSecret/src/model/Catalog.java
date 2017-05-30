package model;

import java.io.Serializable;

/**
 * @author Ugur Yürük
 */
public class Catalog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int articlequantity;
	
	
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
	 * @return the articlequantity
	 */
	public int getArticlequantity() {
		return articlequantity;
	}
	/**
	 * @param articlequantity the articlequantity to set
	 */
	public void setArticlequantity(int articlequantity) {
		this.articlequantity = articlequantity;
	}

	
	

}
