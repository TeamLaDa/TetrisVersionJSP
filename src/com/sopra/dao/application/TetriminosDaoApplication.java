package com.sopra.dao.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sopra.dao.ITetriminosDao;
import com.sopra.model.Tetrimino;

public class TetriminosDaoApplication implements ITetriminosDao{

	private Map<String, Tetrimino> tetriminos = new HashMap<>();
	public List<Tetrimino> findAll(){
		return new ArrayList<>(this.tetriminos.values());
	}
	
	public boolean delete(Tetrimino tetrimino){
		this.tetriminos.remove(tetrimino.getId());
		return true;
	}
	
	public Tetrimino find(String id){
		return this.tetriminos.get(id);
	}
	
	public Tetrimino save(Tetrimino tetrimino){
		return this.tetriminos.put(tetrimino.getId(), tetrimino);
	}


}
