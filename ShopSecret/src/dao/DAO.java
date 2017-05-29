package dao;

import java.util.List;

public interface DAO<T> {

	/**
	 * save the object in DB
	 * @param object
	 */
	void create(T object);
	
	/**
	 * returns the desired object 
	 * @param id
	 * @return
	 */
	T findById(int id);
	
	/**
	 * returns all object as a list
	 * @return
	 */
	List<T> findAll();
	
	
	/**
	 * updates a desired object
	 * @param object
	 */
	void update(T object);
	
	
	/**
	 * delete a object
	 * @param object
	 */
	void delete(T object);
	
	
	
}
