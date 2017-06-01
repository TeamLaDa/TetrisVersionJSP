package com.sopra.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("spectateur")
public class Spectateur extends Utilisateur {

}
