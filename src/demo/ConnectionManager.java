package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// ovo je singleton clasa koja se moze instancirati samo jednom
public class ConnectionManager {
    
	private static ConnectionManager instance = null;   // singleton klasa koja sama sebe instancirati samo jednom
	
    private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/imenik";

	private Connection connection = null;

	private ConnectionManager() {  

	}

	public static ConnectionManager getInstance() {       // metoda koja kontrolise da li je ta klasa vec instancirana
		if (instance == null) {                           // ona osigurava da se ova klasa samo jednom instancirana
			instance = new ConnectionManager();           // ako je null pravi novu ako nije ispisuje postojecu
		}
		return instance;
	}

	private boolean openConnection() {
		try {
			Connection connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				System.out.println(" Connection opened.");
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	public void close() {
		System.out.println("Connection closed.");
		try {
			connection.close();
			connection = null;

		} catch (Exception e) {
		}
	}

}
