package com.sopra.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("joueur")
public class Joueur extends Utilisateur {
	
	

}
