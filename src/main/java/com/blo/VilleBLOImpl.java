package com.blo;

import java.util.List;

import com.config.JDBCConfiguration;
import com.dao.VilleDAO;
import com.dao.VilleDAOException;

import classp1.Ville_france;

public class VilleBLOImpl {

	public List<Ville_france> gestionCallBdd(String param) {
		VilleDAO villeMain = null;
		List<Ville_france> listVilles = villeMain.returnVille();
		try {
			villeMain = JDBCConfiguration.getImpl();
		} catch (VilleDAOException e) {
			e.printStackTrace();
		}
		
		if(param==null) {
			listVilles = villeMain.returnVille();
		}else {
			listVilles = villeMain.returnVille();
		}
		
		return listVilles;
	}
}
