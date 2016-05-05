package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDaoInterface {
	// method to get all contacts

	public ArrayList<User> getAllUsers() throws SQLException;

	// method to get a specific contact
	public ArrayList<User> getUserByName(String name) throws SQLException;

	// method to update a specific contact
	public void changeUser(User user) throws SQLException;

	// method to delete a specific contact


	
	public User getUser(int id) throws SQLException;

	
	public User login(String username, String password) throws SQLException;

	void addUser(User user) throws SQLException;

	void deleteUser(int id) throws SQLException;

}
