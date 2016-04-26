package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	//Instanciraj klasu
	private static ConnectionManager instance = null;
	
	//Parametri za bazu
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String CONN_STRING = "jdbc:mysql://localhost/imenik";
	private static final String PASS = "root";
	
	//Kreiraj objekat konekcije
	private Connection connection = null;
	
	//Privatni konstruktor
	private ConnectionManager(){
	}
	

	public static String getPass(){
		return PASS;
	}
	

	/**Vraca instancu klase*/
	public static ConnectionManager getInstance(){
		if(instance == null){
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	/**Provjerava da li je konekcija otvorena*/
	private boolean openConnection(){
		try{
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	
	/**Vraca konekciju*/
	public Connection getConnection(){
		if(connection == null){
			if(openConnection()){
				return connection;
			}else{
				return null;
			}
		}
		return connection;
	}
	
	/**Zatvara konekciju*/
	public void close(){
		try{
			connection.close();
			connection = null;
		}catch (Exception e){
			System.err.println(e);
		}
	}
}
