package com.sopra.dao;

import java.util.List;

public interface IDAO<T, Key> {
		
	public List<T> findAll();
	public T find(Key id);
	public boolean delete(T object);
	public T save(T object);
}
