package com.sopra.dao;

import java.util.List;

import com.sopra.model.Bloc;

public interface IBlocDAO extends IDAO<Bloc, Integer> {
	public List<Bloc> findWithFigure(int id_figure);
}
