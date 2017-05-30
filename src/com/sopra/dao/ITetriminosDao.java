package com.sopra.dao;

import java.util.List;

import com.sopra.model.Tetrimino;

public interface ITetriminosDao extends IDao<Tetrimino>{
	
	public List<Tetrimino> findAll();
	public Tetrimino find(String id);
	public boolean delete(Tetrimino object);
	public Tetrimino save(Tetrimino object);

}
