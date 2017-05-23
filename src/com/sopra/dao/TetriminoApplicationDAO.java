package com.sopra.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sopra.model.Tetrimino;

public class TetriminoApplicationDAO {
	public static Map<String, Tetrimino> tetriminos = new HashMap<>();
	
	public static List<Tetrimino> findAll(){
		return new ArrayList<>(tetriminos.values());
	}
	
	public static void delete(Tetrimino tetrimino){
		tetriminos.remove(tetrimino.getId());
	}
	
	public static Tetrimino find(String id){
		return tetriminos.get(id);
	}
	
	public static Tetrimino save(Tetrimino tetrimino){
		return tetriminos.put(tetrimino.getId(), tetrimino);
	}
}
