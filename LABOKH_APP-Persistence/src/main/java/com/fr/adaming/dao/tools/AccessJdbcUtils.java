package com.fr.adaming.dao.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository("accessJdbcUtils")
public class AccessJdbcUtils {

	private static Connection connection;
	static Statement statement;

	public static Connection createConnection(String urlBd) {
		Connection conx = null;
		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + urlBd;
			conx = DriverManager.getConnection(database, "", "");

		} catch (Exception e) {
			System.out.println("Error!");
		}

		return conx;

	}

	public static Connection getConnection(String urlBd) {
		if (AccessJdbcUtils.connection == null)
			return createConnection(urlBd);
		else
			return AccessJdbcUtils.connection;
	}

	public static void setConnection(Connection connection) {
		AccessJdbcUtils.connection = connection;
	}

	public static void buildStatement() throws SQLException {
		statement = connection.createStatement();
	}

	public ResultSet executeQuery(String query, Statement statement) throws SQLException {
		ResultSet resultSet = null;
		boolean foundResults = statement.execute(query);
		if (foundResults) {
			resultSet = statement.getResultSet();
		} else {
			connection.close();
		}
		return resultSet;
	}

	public static String displayResults(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		int columns = metaData.getColumnCount();
		String text = "";

		while (rs.next()) {
			for (int i = 1; i <= columns; ++i) {
				text += "" + metaData.getColumnName(i) + ":\t";
				text += rs.getString(i);
				text += "\n";
			}
			text += "\n";
		}
		return text;
	}

}
