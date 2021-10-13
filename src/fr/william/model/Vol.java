package fr.william.model;

import java.sql.Time;

public class Vol {

	private String id;
	private Avion avion;
	private Pilote pilote;
	private String site_depart;
	private String site_arrivee;
	private Time heure_depart;
	private Time heure_arrivee;
	
	public Vol() {}

	public Vol(String id, Avion avion, Pilote pilote, String site_depart, String site_arrivee, Time heure_depart,
			Time heure_arrivee) {
		super();
		this.id = id;
		this.avion = avion;
		this.pilote = pilote;
		this.site_depart = site_depart;
		this.site_arrivee = site_arrivee;
		this.heure_depart = heure_depart;
		this.heure_arrivee = heure_arrivee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Pilote getPilote() {
		return pilote;
	}

	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}

	public String getSite_depart() {
		return site_depart;
	}

	public void setSite_depart(String site_depart) {
		this.site_depart = site_depart;
	}

	public String getSite_arrivee() {
		return site_arrivee;
	}

	public void setSite_arrivee(String site_arrivee) {
		this.site_arrivee = site_arrivee;
	}

	public Time getHeure_depart() {
		return heure_depart;
	}

	public void setHeure_depart(Time heure_depart) {
		this.heure_depart = heure_depart;
	}

	public Time getHeure_arrivee() {
		return heure_arrivee;
	}

	public void setHeure_arrivee(Time heure_arrivee) {
		this.heure_arrivee = heure_arrivee;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-10d%-10d%-20s%-20s%-10s%-10s", id, avion.getId(), pilote.getId(), site_depart, site_arrivee, heure_depart, heure_arrivee);
	}
	
	
	
}
