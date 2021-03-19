package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.config.JDBCConfiguration;
import com.dao.VilleDAO;
import com.dao.VilleDAOException;
import classp1.Ville_france;

@RestController
public class VilleController {

	//methode get
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public List<Ville_france> appelGet(@RequestParam(required = false, value = "codePostal") String codePostal) {
		System.out.println("appel get");
		
		System.out.println("codePostal "+codePostal);
		
		VilleDAO villeMain = null;
		
		try {
			villeMain = JDBCConfiguration.getImpl();
		} catch (VilleDAOException e) {
			e.printStackTrace();
		}
		
		List<Ville_france> listVilles = villeMain.returnVille();
		
		return listVilles;
	}
}
