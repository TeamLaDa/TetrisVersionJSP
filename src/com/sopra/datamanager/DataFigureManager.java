package com.sopra.datamanager;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;

import com.sopra.Constantes;
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
		
		//On normalise la position des blocs dans les figures
		this.normalisation(figures);
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
		
		//On normalise la position des blocs dans les figures
		this.normalisation(figures);
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
	
	//Cette methode permet de normaliser la liste des 4 figures, afin de placer le pixel le plus en haut à gauche à (0,0)
	private void normalisation(List<Figure> figures){
		
		int minX = Constantes.tailleMaxTetrimino + 1;
		int minY = Constantes.tailleMaxTetrimino + 1;
		
		for (Figure figure : figures) {
			//On parcourt la liste de tous les blocs pour trouver le plus en haut à gauche
			for (Bloc bloc : figure.getBlocs()) {
				if(minX > bloc.getPositionX()){
					minX = bloc.getPositionX();
				}
				
				if(minY > bloc.getPositionY()){
					minY = bloc.getPositionY();
				}
			}
		}

	
	//Une fois les positions minimales définies, on applique l'offset à chaque bloc
	for (Figure figure : figures) {
		//On parcourt la liste de tous les blocs pour trouver le plus en haut à gauche
		for (Bloc bloc : figure.getBlocs()) {
			int positionX_norm = bloc.getPositionX() - minX;
			int positionY_norm = bloc.getPositionY() - minY;
			
			bloc.setPositionX(positionX_norm);
			bloc.setPositionY(positionY_norm);
		}
		
		}
	}
	
}
