package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dao.VilleDAO;
import com.dao.VilleDAOException;
import com.dao.VilleDAOImpl;

public class JDBCConfiguration {
	
	public JDBCConfiguration() {
		
	}

	static public VilleDAO getImpl() throws VilleDAOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e2) {
			throw new VilleDAOException("Impossible de se connecter Ã  la base de donnÃ©es");
		}
		
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/maven?user=root&password=network");
		} catch(SQLException e1) {
			throw new VilleDAOException("Impossible de se connecter Ã  la base de donnÃ©es 2");
		}
		
		
		return (VilleDAO) new VilleDAOImpl(connexion);
	}
}