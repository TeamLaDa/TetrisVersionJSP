package com.sopra.datamanager;

import java.util.ArrayList;
import java.util.List;

import com.sopra.model.Bloc;

//Classe gérant la création des nouveaux blocs après récuperation des coordonées des blocs dans le formulaire d'édition/création
public class DataBlocManager {
	
	private Integer[] extractCoordinates(String data){
			int coordX = Integer.parseInt(data.split("--")[0]);
			int coordY = Integer.parseInt(data.split("--")[1]);
			
			Integer[] coord= {coordX, coordY};
			
			return coord;
	}
	
	
	public List<Bloc> extractBlocsFromCoordinates(String[] data_blocs, String data_pivot){
		
		List<Bloc> blocs = new ArrayList<>();
		Integer[] coordPivot = this.extractCoordinates(data_pivot);
		
		for (String coordString : data_blocs) {
			Integer[] coord = this.extractCoordinates(coordString);
			
			Bloc bloc = new Bloc();
			bloc.setPoids(1);
			bloc.setPositionX(coord[0]);
			bloc.setPositionY(coord[1]);
			bloc.setPivot(false);
			
			if(bloc.getPositionX() == coordPivot[0] && bloc.getPositionY() == coordPivot[1]){
				bloc.setPivot(true);
			}
			
			blocs.add(bloc);
		}		
		return blocs;
		
	}
	
	public List<Bloc> extractBlocsFromCoordinatesWithoutPivot(String[] data_blocs){
		List<Bloc> blocs = new ArrayList<>();
		
		for (String coordString : data_blocs) {
			Integer[] coord = this.extractCoordinates(coordString);
			
			Bloc bloc = new Bloc();
			bloc.setPoids(1);
			bloc.setPositionX(coord[0]);
			bloc.setPositionY(coord[1]);
			bloc.setPivot(false);
			
			blocs.add(bloc);
	}
		return blocs;
	}
}
