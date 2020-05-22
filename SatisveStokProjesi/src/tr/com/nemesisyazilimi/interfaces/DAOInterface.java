package tr.com.nemesisyazilimi.interfaces;

import java.util.*;
import java.sql.Connection;

public interface DAOInterface<T> {

	public void Insert(T entity);
	public List<T> GetAll();
	public T Delete(T entity);
	public void Upate(T entity);
	public List<T> GetById(int id);
}
