package com.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * 
 * @author javahunk
 * This is used to provide connection to 
 * the user
 */
public class ConnectionUtils {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/rab3tech_db";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "mysql@1234";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		return conn;
	}

}
