package com.surveillance.db.utilitiy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.apache.log4j.Logger;

public class OracleDatabaseUtils {

	protected static final Logger log = Logger.getLogger(OracleDatabaseUtils.class);

	public static Connection conn;

	/**
	 * This method is used to connect to Oracle database by using properties
	 * mentioned in properties file.
	 */
	public static void connectToOracleDB(String host, String userName, String pwd) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host, userName, pwd);
			System.out.println("connection is successful");

		} catch (Exception e) {
			// log.error("", e);
			System.out.println("connection is not successful");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to close the Oracle connection.
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			log.error("", e);
		}
	}
	
	/**
	 * This method is used to return ResultSet for given query
	 * 
	 * @param query
	 * @return
	 */
	public static ResultSet executeSelectQuery(String query) {
		ResultSet dbResultset = null;
		try {
			Statement statement = conn.createStatement();
			dbResultset = statement.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return dbResultset;
	}

	/**
	 * This method is used to execute delete query in database.
	 *
	 * @param conn  : Connection object
	 * @param query :  query
	 */
	public static void executeDeleteQuery(String query) {
		try {
			Statement dbStatement = conn.createStatement();
			dbStatement.execute(query);
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
	}

	
}