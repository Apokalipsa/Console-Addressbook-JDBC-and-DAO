package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager instance = null;

	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String CONN_STRING = "jdbc:mysql://localhost/imenik";
	private static final String PASS = "root";

	private Connection connection = null;

	private ConnectionManager() {
	}

	public static String getPass() {
		return PASS;
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	private boolean openConnection() {
		try {
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	public void close() {
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
