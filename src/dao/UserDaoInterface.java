package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDaoInterface {
	// method to get all contacts

	public ArrayList<User> getAllUsers() throws SQLException;

	// method to get a specific contact
	public ArrayList<User> getUsergetUserByName() throws SQLException;

	// method to update a specific contact
	public void changeUser(User user) throws SQLException;

	// method to delete a specific contact
	public void deleteUser(User user) throws SQLException;

	// method to add a contact
	public void addUser() throws SQLException;
	
	public User getUser(int id) throws SQLException;

	// method to print a specific contact
	public void printUser(User user);

}
