package service;
import java.util.List;
  
public interface GenerischeDao<T> {
  
	public List<T> findAll();
	  
	public T update(T object);
	  
	public T get(Long id);
	
	public T getDag(int dag);
	  
	public void delete(T object);
	  
	public void insert(T object);
	  
	public void insertAll(List<T> object);
	  
	public boolean exists(Long id) ; 
}
 