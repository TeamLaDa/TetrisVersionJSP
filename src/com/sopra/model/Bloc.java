package com.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="bloc")
public class Bloc {
	
	@Column(name="BLO_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name="BLO_POIDS")
	@NotNull
	private int poids;
	
	@Column(name="BLO_POSITIONX")
	@NotNull
	private int positionX;
	
	@Column(name="BLO_POSITIONY")
	@NotNull
	private int positionY;
	
	@Column(name="BLO_PIVOT")
	@NotNull
	private boolean pivot;
	
	/**
	 * @return the pivot
	 */
	public boolean isPivot() {
		return pivot;
	}

	/**
	 * @param pivot the pivot to set
	 */
	public void setPivot(boolean pivot) {
		this.pivot = pivot;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="BLO_FIGURE_ID")
	private Figure figure;

	/**
	 * @return the poids
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * @param poids the poids to set
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}

	/**
	 * @return the positionX
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * @param figure the figure to set
	 */
	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	/**
	 * @param positionX the positionX to set
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	/**
	 * @return the positionY
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * @param positionY the positionY to set
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param poids
	 * @param positionX
	 * @param positionY
	 */
	public Bloc(int poids, int positionX, int positionY) {
		this.poids = poids;
		this.positionX = positionX;
		this.positionY = positionY;
	}

	/**
	 * 
	 */
	public Bloc() {
	}
	
	
}
