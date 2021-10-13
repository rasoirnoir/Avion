package fr.william.model;

public class Pilote {
	
	private int id;
	private String nom;
	private String site;
	
	public Pilote(int id, String nom, String site) {
		super();
		this.id = id;
		this.nom = nom;
		this.site = site;
	}
	
	public Pilote() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return String.format("%-10d%-20s%-20s", id, nom, site);
	}

}
