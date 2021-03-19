package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import classp1.Ville_france;

@Service
public class VilleDAOImpl implements VilleDAO{

	private Connection connexion;

	public VilleDAOImpl(Connection connexion) {
		this.connexion = connexion;
	}
	
	public List<Ville_france> returnVille() {
		Statement statement = null;
		ResultSet resultat = null;
		List<Ville_france> listVilles = new ArrayList<Ville_france>();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT * FROM ville_france;");

			while (resultat.next()) {
				String Code_commune_INSEE = resultat.getString("Code_commune_INSEE");
				String Nom_commune = resultat.getString("Nom_commune");
				String Code_postal = resultat.getString("Code_postal");
				String Libelle_acheminement = resultat.getString("Libelle_acheminement");
				String Ligne_5 = resultat.getString("Ligne_5");
				String Latitude = resultat.getString("Latitude");
				String Longitude = resultat.getString("Longitude");

				Ville_france ville = new Ville_france(Code_commune_INSEE, Nom_commune, Code_postal,
						Libelle_acheminement, Ligne_5, Latitude, Longitude);

				listVilles.add(ville);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listVilles;
	}
}
