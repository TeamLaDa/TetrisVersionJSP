package com.sopra.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="figure")
public class Figure {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(name="FIG_ID")
	private String id;
	
	@Column(name="FIG_ORDRE")
	@NotNull
	private int ordre;
	
	@ManyToOne
	@JoinColumn(name="FIG_TETRIMINO_ID")
	private Tetrimino tetrimino;
	
	@OneToMany(mappedBy="figure")
	private List<Bloc> blocs;

}
