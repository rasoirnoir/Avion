package fr.william.main;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import fr.william.model.Avion;
import fr.william.model.Pilote;
import fr.william.model.Vol;
//import fr.william.util.DbAccess;
import fr.william.util.Requetes;
import fr.william.db.DbAccess;



public class Main {

	public static void main(String[] args) throws SQLException {

		Connection co = DbAccess.Connect("avions");
		ArrayList<Avion> avions = Requetes.getAllAvions();
		System.out.println("Liste des avions");
		System.out.println("----------------");
		for (Avion avion : avions) {
			System.out.println(avion);
		}
		System.out.println();
		
		ArrayList<Pilote> pilotes = Requetes.getAllPilotes();
		System.out.println("Liste des pilotes");
		System.out.println("-----------------");
		for (Pilote pilote : pilotes) {
			System.out.println(pilote);
		}
		System.out.println();
		
		ArrayList<Vol> vols = Requetes.getAllVol();
		System.out.println("Liste des vols");
		System.out.println("--------------");
		for (Vol vol : vols) {
			System.out.println(vol);
		}
		System.out.println();
		
		Avion nouvelAvion = new Avion(110, "BOEING", "B3310", 50, "Montreuil");
		System.out.println("Ajout de l'avion");
		System.out.println(nouvelAvion);
		System.out.println("----------------");
		Requetes.addAvion(nouvelAvion);
		System.out.println();
		
		Pilote nouveauPilote = new Pilote(10, "Régis", "Montreuil");
		System.out.println("Ajout d'un nouveau pilote");
		System.out.println(nouveauPilote);
		System.out.println("-------------------------");
		Requetes.addPilote(nouveauPilote);
		System.out.println();
		
		System.out.println("Suppression de l'avion");
		System.out.println(nouvelAvion);
		System.out.println("----------------------");
		Requetes.deleteAvion(nouvelAvion);
		System.out.println();
		
		System.out.println("Suppression du pilote");
		System.out.println(nouveauPilote);
		System.out.println("---------------------");
		Requetes.deletePilote(nouveauPilote);
		System.out.println();
		
		System.out.println("Ajout de l'avion");
		System.out.println(nouvelAvion);
		System.out.println("----------------");
		Requetes.addAvion(nouvelAvion);
		System.out.println();
		
		System.out.println("Ajout d'un nouveau pilote");
		System.out.println(nouveauPilote);
		System.out.println("-------------------------");
		Requetes.addPilote(nouveauPilote);
		System.out.println();
		
		Vol vol1 = new Vol("IT112", nouvelAvion, nouveauPilote, "Montreuil", "Levallois", Time.valueOf("13:30:00"), Time.valueOf("13:45:00"));
		System.out.println("Ajout d'un nouveau vol");
		System.out.println(vol1);
		System.out.println("----------------------");
		Requetes.addVol(vol1);
		System.out.println();
		
		System.out.println("Tentative de suppression du pilote");
		System.out.println(nouveauPilote);
		System.out.println("----------------------------------");
		Requetes.deletePilote(nouveauPilote);
		System.out.println();
		
		System.out.println("Mise à jour de l'avion");
		System.out.println(nouvelAvion);
		System.out.println("Nouvelles valeurs");
		nouvelAvion.setConstructeur("BOUIBOUI");
		System.out.println(nouvelAvion);
		System.out.println("----------------------");
		Requetes.updateAvion(nouvelAvion);
		System.out.println();
		
		System.out.println("Tentative de suppression d'un pilote qui n'existe pas");
		Pilote piloteInconnu = new Pilote(6546, "Robert", "Linconnu");
		System.out.println(piloteInconnu);
		Requetes.deletePilote(piloteInconnu);
		System.out.println();
		
		System.out.println("Mise à jour du pilote");
		System.out.println(nouveauPilote);
		nouveauPilote.setNom("Pablo");
		System.out.println("Nouvelles valeurs");
		System.out.println(nouveauPilote);
		System.out.println("---------------------");
		Requetes.updatePilote(nouveauPilote);
		System.out.println();
		
		System.out.println("Mise à jour du vol");
		System.out.println(vol1);
		System.out.println("Nouvelles valeurs");
		vol1.setHeure_arrivee(Time.valueOf("16:00:00"));
		System.out.println(vol1);
		Requetes.updateVol(vol1);
		System.out.println();
		
		co.close();
	}

}
