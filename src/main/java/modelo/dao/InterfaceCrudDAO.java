package modelo.dao;

import java.util.List;


public interface InterfaceCrudDAO<T> {
	
	public boolean insert(T obj);  // (INSERT/CREATE)
	
	public boolean update(T obj);  // (UPDATE)
	
	public boolean delete(T obj);  	// (DELETE)
		
	public List<T> recupera(); 		// (RECUPERA CONJUNTO)
	
	public T recupera(String identificador);  //  (RECUPERA UM ELEMENTO)
	

	
	
}
