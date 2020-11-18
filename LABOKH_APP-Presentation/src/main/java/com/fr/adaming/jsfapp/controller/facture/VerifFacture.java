package com.fr.adaming.jsfapp.controller.facture;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import com.fr.adaming.jsfapp.model.Facture;

public class VerifFacture {
	// JDBC driver name and database URL
	static String JDBC_DRIVER;
	static String DB_URL;
	// Database credentials
	static String USER;
	static String PASS;

	public static void chargerProperties() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "databaseView.properties";
			input = VerifFacture.class.getClassLoader().getResourceAsStream(filename);

			// input = new FileInputStream("databaseView.properties");
			// load a properties file
			prop.load(input);

			// get the property value and print it out
			setPASS(prop.getProperty("jdbc.password"));
			setUSER(prop.getProperty("jdbc.username"));
			setDB_URL(prop.getProperty("jdbc.url"));
			setJDBC_DRIVER(prop.getProperty("jdbc.driverClassName"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static Facture rechercherFacture(String numFacture) {
		Connection conn = null;
		Statement stmt = null;
		Facture facture = new Facture();
		chargerProperties();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT NumFacture,DateFacturation,NumClient,OrdreAtelier,NumCommande,MontantTTC  FROM Facturation  where NumFacture='"
					+ numFacture + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {

				facture.setDateFacture(rs.getDate("DateFacturation"));
				facture.setNumFacture(rs.getString("NumFacture"));
				facture.setTotalPrix((long) rs.getDouble("MontantTTC"));

				String NumeroFacture = rs.getString("NumFacture");
				// String age = rs.getString("NumClient");
				Date DateFacture = rs.getDate("DateFacturation");
				double TotalPrix = rs.getDouble("MontantTTC");

				// Display values
				System.out.print("NUM FACTURE: " + NumeroFacture);
				System.out.print("; DateFacture : " + DateFacture);
				System.out.println(", TotalPrix: " + TotalPrix);
				System.out.println("-------------------------------------------------------------");
			} else {
				System.out.println("0 resultat");
				facture = null;
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		return facture;
	}

	public static Boolean rechercherCVC(String numCVC) {
		Connection conn = null;
		Statement stmt = null;
		Boolean b = false;
		chargerProperties();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT NumCommande,NumClient  FROM Commande where numcommande = '" + numCVC + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {

				String NumeroFacture = rs.getString("NumCommande");

				// Display values
				System.out.print("NUM FACTURE: " + NumeroFacture);
				System.out.println("-------------------------------------------------------------");
				b = true;
			} else {
				System.out.println("0 resultat");
				b = false;
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		return b;
	}

	public static Boolean rechercherNumOR(String numOR) {
		Connection conn = null;
		Statement stmt = null;
		Boolean b = false;
		chargerProperties();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT OrdreAtelier,NumClient  FROM OrdreAtelier  Where OrdreAtelier ='" + numOR + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {

				String NumeroFacture = rs.getString("OrdreAtelier");

				// Display values
				System.out.print("NUM FACTURE: " + NumeroFacture);
				System.out.println("-------------------------------------------------------------");
				b = true;
			} else {
				System.out.println("0 resultat");
				b = false;
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		return b;
	}

	public static Facture rechercherFactureParCvcOR(String numFacture) {
		Connection conn = null;
		Statement stmt = null;
		chargerProperties();

		Facture facture = new Facture();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT NumFacture,DateFacturation,NumClient,OrdreAtelier,NumCommande,MontantTTC FROM Facturation  where OrdreAtelier = '"
					+ numFacture + "'  or numcommande ='" + numFacture + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {

				facture.setDateFacture(rs.getDate("DateFacturation"));
				facture.setNumFacture(rs.getString("NumFacture"));
				facture.setTotalPrix((long) rs.getDouble("MontantTTC"));

				String NumeroFacture = rs.getString("NumFacture");
				// String age = rs.getString("NumClient");
				Date DateFacture = rs.getDate("DateFacturation");
				double TotalPrix = rs.getDouble("MontantTTC");

				// Display values
				System.out.print("NUM FACTURE: " + NumeroFacture);
				System.out.print("; DateFacture : " + DateFacture);
				System.out.println(", TotalPrix: " + TotalPrix);
				System.out.println("-------------------------------------------------------------");
			} else {
				System.out.println("0 resultat");
				facture = null;
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		return facture;
	}

	public static String getJDBC_DRIVER() {
		return JDBC_DRIVER;
	}

	public static void setJDBC_DRIVER(String jDBC_DRIVER) {
		JDBC_DRIVER = jDBC_DRIVER;
	}

	public static String getDB_URL() {
		return DB_URL;
	}

	public static void setDB_URL(String dB_URL) {
		DB_URL = dB_URL;
	}

	public static String getUSER() {
		return USER;
	}

	public static void setUSER(String uSER) {
		USER = uSER;
	}

	public static String getPASS() {
		return PASS;
	}

	public static void setPASS(String pASS) {
		PASS = pASS;
	}

}// end FirstExample
