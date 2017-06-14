package com.sopra.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="figure")
public class Figure {

	@Column(name="FIG_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name="FIG_ORDRE")
	@NotNull
	private int ordre;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="FIG_TETRIMINO_ID")
	private Tetrimino tetrimino;
	
	@OneToMany(mappedBy="figure")
	private List<Bloc> blocs;
	
	
	

	/**
	 * 
	 */
	public Figure() {
		super();
	}

	/**
	 * @return the ordre
	 */
	public int getOrdre() {
		return ordre;
	}

	/**
	 * @param ordre the ordre to set
	 */
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	/**
	 * @return the tetrimino
	 */
	public Tetrimino getTetrimino() {
		return tetrimino;
	}

	/**
	 * @param tetrimino the tetrimino to set
	 */
	public void setTetrimino(Tetrimino tetrimino) {
		this.tetrimino = tetrimino;
	}

	/**
	 * @return the blocs
	 */
	public List<Bloc> getBlocs() {
		return blocs;
	}

	/**
	 * @param blocs the blocs to set
	 */
	public void setBlocs(List<Bloc> blocs) {
		this.blocs = blocs;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param ordre
	 * @param tetrimino
	 */
	public Figure(int ordre) {
		this.ordre=ordre;
	}
	
	

}
