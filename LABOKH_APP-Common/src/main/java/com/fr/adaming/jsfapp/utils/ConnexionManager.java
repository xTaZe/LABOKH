package com.fr.adaming.jsfapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager {

	public static Connection getConnexion() throws ClassNotFoundException, SQLException {
		Class.forName(IConstants.Connexion.dbDriver);
		Connection conn = DriverManager.getConnection(IConstants.Connexion.dbUrl, IConstants.Connexion.dbUname,
				IConstants.Connexion.dbPwd);
		return conn;
	}
}
