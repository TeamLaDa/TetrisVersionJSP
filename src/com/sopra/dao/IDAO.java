package com.sopra.dao;

import java.util.List;


import com.sopra.model.Tetrimino;

public interface IDAO {
		
	public List<Tetrimino> findAll();
	public void delete(Tetrimino tetrimino);
	public Tetrimino find(String id);
	public Tetrimino save(Tetrimino tetrimino);
}
