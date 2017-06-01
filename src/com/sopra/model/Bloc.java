package com.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="bloc")
public class Bloc {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(name="BLO_ID")
	private String id;
	
	@Column(name="BLO_POIDS")
	@NotNull
	private int poids;
	
	@Column(name="BLO_POSITIONX")
	@NotNull
	private int positionX;
	
	@Column(name="BLO_POSITIONY")
	@NotNull
	private int positionY;
	
	@ManyToOne
	@JoinColumn(name="BLO_FIGURE_ID")
	Figure figure;
}
