package com.fr.adaming.jsfapp.utils;

public interface IConstants {
	public static final String SCHEMA = "labo";

	interface Connexion {
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/serveurresultat";
		String dbUname = "root";
		String dbPwd = "";
	}

	interface NatureMouvement {
		String facture = "Facture";
		String conversion = "Conversion";

	}

	interface UpladImage {
		/*
		 * Après la modification des ces deux champs dans server.xml <host> ...
		 * <Context docBase="C:\ADAMING_DEV\Upload\PackFid" path="/static"
		 * reloadable="true"/> </host>
		 */
		// interface PackFid {
		// String PATH_TO_UPLOAD = "C:\\ADAMING_DEV\\Upload\\PackFid\\";
		// // String PATH_TO_READ = "http://192.168.1.16:8787/static/";
		// String PATH_TO_READ = "http://localhost:8080/";
		// }

		interface PackFid {
			// String PATH_TO_UPLOAD = "C:\\ITALCARFID\\Upload\\PackFid";
			String PATH_TO_UPLOAD = "C:\\ADAMING_DEV\\Upload\\PackFid\\";
			String PATH_TO_READ = Utilitaire.getLocalAdress();
		}

	}

}
