package com.sopra.datamanager;

import java.util.ArrayList;
import java.util.List;


import com.sopra.model.Bloc;
import com.sopra.model.Figure;

//Classe gérant la création des nouvelles figures après récuperation des blocs dans le formulaire d'édition/création
public class DataFigureManager {

	public List<Figure> extractFigureFromBlocs(List<Bloc> blocs){
		List<Figure> figures = new ArrayList<>();
		Figure figure = new Figure();
		figure.setBlocs(blocs);
		figure.setOrdre(0);
		figures.add(figure);
		
		//On cherche le pivot
		Bloc pivot = this.findPivot(blocs);
		
		System.out.println(pivot.getPositionX() +"," +pivot.getPositionY());
		
		//On applique la rotation sur tous les blocs des figures suivantes
		for(int i=1; i<4; ++i){
			Figure figureRot = new Figure();
			figureRot.setOrdre(i);
			figureRot.setBlocs(figures.get(i-1).getBlocs());
			for (Bloc bloc : figureRot.getBlocs()) {
				int x_rot = -bloc.getPositionY() + pivot.getPositionY() + pivot.getPositionX();
				int y_rot = bloc.getPositionX() - pivot.getPositionY() + pivot.getPositionY();
				
				bloc.setPositionX(x_rot);
				bloc.setPositionY(y_rot);
			}
			
			figures.add(figureRot);
		}
		
		System.out.println(figures.get(1).getOrdre());
		System.out.println(figures.get(1).getBlocs().size());
		
		return figures;
	}
	
	//Renvoie les quatre meme figures
	public List<Figure> extractFigureFromBlocsWithoutPivot(List<Bloc> blocs){
		List<Figure> figures = new ArrayList<>();
		
		for(int i=0; i<4; ++i){
			Figure figure = new Figure();
			figure.setBlocs(blocs);
			figure.setOrdre(i);
			figures.add(figure);
		}
		
		return figures;
	}
	
	//Renvoie le pivot sur une liste de blocs
	private Bloc findPivot(List<Bloc> blocs){
		
		for (Bloc bloc : blocs) {
			if(bloc.isPivot()){
				return bloc;
			}
		}

		return null;
	}
}
