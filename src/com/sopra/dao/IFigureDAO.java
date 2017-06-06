package com.sopra.dao;

import java.util.List;

import com.sopra.model.Figure;

public interface IFigureDAO extends IDAO<Figure, Integer> {
	public List<Figure> findWithTetrimino(String id_tetrimino);
}
