package com.sopra.dao;

import java.util.List;

public interface IDao<T> {
		
	public List<T> findAll();
	public T find(String id);
	public boolean delete(T object);
	public T save(T object);
}
