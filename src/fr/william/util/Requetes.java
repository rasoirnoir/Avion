package fr.william.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.william.model.Avion;
import fr.william.model.Pilote;
import fr.william.model.Vol;

import fr.william.db.DbAccess;

public class Requetes {

	/**
	 * Récupère la liste de tous les avions de la base de données
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Avion> getAllAvions() throws SQLException {
		ArrayList<Avion> avions = new ArrayList<Avion>();
		
		String requete = "SELECT * FROM avion";
		ResultSet resultat = DbAccess.executerQuery(requete);
		while(resultat.next()) {
			Avion avion = new Avion();
			avion.setId(resultat.getInt("AV_ID"));
			avion.setConstructeur(resultat.getString("AV_CONST"));
			avion.setModele(resultat.getString("AV_MODELE"));
			avion.setCapacite(resultat.getInt("AV_CAPACITE"));
			avion.setSite(resultat.getString("AV_SITE"));
			
			avions.add(avion);
		}
		
		return avions;
	}
	
	/**
	 * Récupère la liste de tous le pilotes de la base de donnée
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Pilote> getAllPilotes() throws SQLException{
		ArrayList<Pilote> pilotes = new ArrayList<Pilote>();
		
		ResultSet resultat = DbAccess.executerQuery("SELECT * FROM pilote");
		while(resultat.next()) {
			Pilote pilote = new Pilote();
			pilote.setId(resultat.getInt("PI_ID"));
			pilote.setNom(resultat.getString("PI_NOM"));
			pilote.setSite(resultat.getString("PI_SITE"));
			
			pilotes.add(pilote);
		}
		return pilotes;
	}
	
	/**
	 * Récupère la liste de tous les vols de la base de données
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Vol> getAllVol() throws SQLException{
		ArrayList<Vol> vols = new ArrayList<Vol>();
		
		ResultSet resultat = DbAccess.executerQuery("SELECT * FROM vol");
		while(resultat.next()) {
			Vol vol = new Vol();
			vol.setId(resultat.getString("VO_ID"));
			vol.setAvion(getAvionById(resultat.getInt("VO_AVION")));
			vol.setPilote(getPiloteById(resultat.getInt("VO_PILOTE")));
			vol.setSite_depart(resultat.getString("VO_SITE_DEPART"));
			vol.setSite_arrivee(resultat.getString("VO_SITE_ARRIVEE"));
			vol.setHeure_depart(resultat.getTime("VO_HEURE_DEPART"));
			vol.setHeure_arrivee(resultat.getTime("VO_HEURE_ARRIVEE"));
			
			vols.add(vol);
		}
		return vols;
	}
	
	/**
	 * Récupère un avion à partir de son ID
	 * @param id l'id de l'avion
	 * @return Un avion
	 * @throws SQLException
	 */
	public static Avion getAvionById(int id) throws SQLException {
		Avion avion = new Avion();
		ResultSet resultat = DbAccess.executerQuery("SELECT * FROM avion WHERE avion.AV_ID = " + id);
		while(resultat.next()) {
			avion.setId(resultat.getInt("AV_ID"));
			avion.setConstructeur(resultat.getString("AV_CONST"));
			avion.setModele(resultat.getString("AV_MODELE"));
			avion.setCapacite(resultat.getInt("AV_CAPACITE"));
			avion.setSite(resultat.getString("AV_SITE"));
		}
		return avion;
	}
	
	/**
	 * Récupère un pilote à partir de son ID
	 * @param id l'id du pilote
	 * @return Le pilote
	 * @throws SQLException
	 */
	public static Pilote getPiloteById(int id) throws SQLException {
		Pilote pilote = new Pilote();
		Object[] params = {id};
		ResultSet resultat = DbAccess.executerQuery("SELECT * FROM pilote WHERE pilote.PI_ID = ?", params);
		while(resultat.next()) {
			pilote.setId(resultat.getInt("PI_ID"));
			pilote.setNom(resultat.getString("PI_NOM"));
			pilote.setSite(resultat.getString("PI_SITE"));
		}
		return pilote;
	}
	
	/**
	 * Insert un avion dans la base de données
	 * @param avion
	 * @throws SQLException
	 */
	public static void addAvion(Avion avion) throws SQLException {
		Object[] params = {
				avion.getId(),
				avion.getConstructeur(),
				avion.getModele(),
				avion.getCapacite(),
				avion.getSite()
		};
		DbAccess.executerUpdate("INSERT INTO avion (AV_ID, AV_CONST, AV_MODELE, AV_CAPACITE, AV_SITE) VALUES (?, ?, ?, ?, ?)", params);
	}
	
	/**
	 * Insert un nouveau pilote dans la base de données
	 * @param pilote
	 * @throws SQLException
	 */
	public static void addPilote(Pilote pilote) throws SQLException {
		Object[] params = {
				pilote.getId(),
				pilote.getNom(),
				pilote.getSite()
		};
		DbAccess.executerUpdate("INSERT INTO pilote (PI_ID, PI_NOM, PI_SITE) VALUES (?, ?, ?)", params);
	}
	
	/**
	 * insert un nouveau Vol dans la base de données
	 * @param vol
	 * @throws SQLException
	 */
	public static void addVol(Vol vol) throws SQLException {
		Object[] params = {
				vol.getId(),
				vol.getAvion().getId(),
				vol.getPilote().getId(),
				vol.getSite_depart(),
				vol.getSite_arrivee(),
				vol.getHeure_depart(),
				vol.getHeure_arrivee()
		};
		DbAccess.executerUpdate("INSERT INTO vol (VO_ID, VO_AVION, VO_PILOTE, VO_SITE_DEPART, VO_SITE_ARRIVEE, VO_HEURE_DEPART, VO_HEURE_ARRIVEE) VALUES (?, ?, ?, ?, ?, ?, ?)", params);
	}
	
	/**
	 * Supprime un avion de la liste
	 * @param avion
	 * @throws SQLException 
	 */
	public static void deleteAvion(Avion avion) throws SQLException {
		Object[] params = {
				avion.getId(),
		};
		DbAccess.executerUpdate("DELETE FROM avion WHERE avion.AV_ID = ?", params);
	}
	
	/**
	 * Supprime un pilote de la liste
	 * @param pilote
	 * @throws SQLException 
	 */
	public static void deletePilote(Pilote pilote) throws SQLException {
		Object[] params = {
				pilote.getId(),
		};
		DbAccess.executerUpdate("DELETE FROM pilote WHERE pilote.PI_ID = ?", params);
	}
	
	/**
	 * Supprime un vol de la liste
	 * @param vol
	 * @throws SQLException 
	 */
	public static void deleteVol(Vol vol) throws SQLException {
		Object[] params = {
				vol.getId(),
		};
		DbAccess.executerUpdate("DELETE FROM vol WHERE vol.VO_ID = ?", params);
	}
	
	/**
	 * Met à jour un avion dans la base
	 * @param avion
	 * @throws SQLException
	 */
	public static void updateAvion(Avion avion) throws SQLException {
		Object[] params = {				
				avion.getConstructeur(),
				avion.getModele(),
				avion.getCapacite(),
				avion.getSite(),
				avion.getId()
		};
		DbAccess.executerUpdate("UPDATE avion SET AV_CONST=?, AV_MODELE=?, AV_CAPACITE=?, AV_SITE=? WHERE avion.AV_ID = ?", params);
	}
	
	/**
	 * Met à jour un pilote dans la base
	 * @param pilote
	 * @throws SQLException
	 */
	public static void updatePilote(Pilote pilote) throws SQLException {
		Object[] params = {
				pilote.getNom(),
				pilote.getSite(),
				pilote.getId()
		};
		DbAccess.executerUpdate("UPDATE pilote SET PI_NOM=?, PI_SITE=? WHERE PI_ID=?", params);
	}
	
	/**
	 * Met à jour un vl dans la base
	 * @param vol
	 * @throws SQLException
	 */
	public static void updateVol(Vol vol) throws SQLException {
		Object[] params = {
				vol.getAvion().getId(),
				vol.getPilote().getId(),
				vol.getSite_depart(),
				vol.getSite_arrivee(),
				vol.getHeure_depart(),
				vol.getHeure_arrivee(),
				vol.getId()
		};
		DbAccess.executerUpdate("UPDATE vol SET VO_AVION=?, VO_PILOTE=?, VO_SITE_DEPART=?, VO_SITE_ARRIVEE=?, VO_HEURE_DEPART=?, VO_HEURE_ARRIVEE=? WHERE VO_ID=?", params);
	}
}
