package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import demo.Admin;
import demo.ConnectionManager;

public class UserDAO implements UserDaoInterface {

	// connect to the database
	static Connection connection = ConnectionManager.getInstance().getConnection();

	public static void loginMenu() throws SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
		System.out.println("Enter your username and password: ");
		String name = input.next();
		String password = input.next();

		validate(name, password);
		input.close();
	}

	public static void validate(String name, String password) throws SQLException {
		if ((name.equals(Admin.getAdminName()) && password.equals(Admin.getAdminPassword()))) {

			System.out.println("\nSuccessfuly login as admin.");
			System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

			Admin.adminMenu();

		} else {

			User user = UserRegistar.getUser(name, password);
			if (user != null) {
				System.out.println("\nSuccessfuly login as user.");
				System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
				User.userMenu(user);

			} else {

				System.out.println("Invalid username and password!\nPlease try again.");
				loginMenu();
			}
			
		}
		
	}
	
	@Override
	public ArrayList<User> getAllUsers() throws SQLException {

		// create an array list to hold students
		ArrayList<User> user = new ArrayList<>();

		// create an SELECT SQL query
		String query = "SELECT * FROM kontakti";

		// create a new ResultSet
		ResultSet rs = null;

		try (
				// java.sql.Statement
				Statement statement = connection.createStatement();) {

			// execute the query
			rs = statement.executeQuery(query);

			// add students to the arrayList
			while (rs.next()) {
				user.add(new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("username"), rs.getString("password"), rs.getString("phoneNumber"),
						rs.getString("address"), rs.getString("city"), rs.getInt("isAdmin")));

				System.out.println("Student: " + rs.getString("firstName") + " added to students");
			}

		}

		return user;
	}

	// @Override
	public User getUser(int id) throws SQLException {

		// null student
		User user = null;

		// create an SELECT SQL query
		String query = "SELECT * FROM kontakti WHERE id = ?";

		// create a new ResultSet
		ResultSet rs = null;

		try (
				// java.sql.Statement
				PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);

			// execute the query
			rs = statement.executeQuery();

			// set the cursor
			if (rs.next()) {

				// populate student
				user = new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("username"), rs.getString("password"), rs.getString("phoneNumber"),
						rs.getString("address"), rs.getString("city"), rs.getInt("isAdmin"));

				// close the ResultSet
				rs.close();
			}
		}

		return user;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		if (user != null) {

			// create an SELECT SQL query
			String query = "UPDATE kontakti SET id = ?, firstName = ?, lastName = ?, username = ?, password = ?, phoneNumber = ?, address = ?, city = ? WHERE id = ?";

			// new Scanner

			try (
					// java.sql.Statement
					PreparedStatement stmnt = connection.prepareStatement(query);) {

				// fill in the placeholders/parameters
				stmnt.setInt(1, user.getId());
				stmnt.setString(2, user.getFirstName());
				stmnt.setString(3, user.getLastName());
				stmnt.setString(4, user.getUsername());
				stmnt.setString(5, user.getPassword());
				stmnt.setString(6, user.getPhoneNumber());
				stmnt.setString(7, user.getAddress());
				stmnt.setString(8, user.getCity());
				stmnt.setInt(9, user.getIsAdmin());
				stmnt.executeUpdate();

				// execute the query

				System.out.println("User updated in the database.");
			}
		}
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		if (user != null) {
			// create an SELECT SQL query
			String query = "DELETE FROM kontakti WHERE id = ?";

			try (
					// java.sql.Statement
					PreparedStatement statement = connection.prepareStatement(query);) {

				// fill in the placeholders/parameters
				statement.setInt(1, user.getId());

				// execute the query
				statement.executeUpdate();

				System.out.println("User deleted from the database.");
			}
		}
	}

	@Override
	public void addUser() throws SQLException {

		// create an SELECT SQL query
		String query = "INSERT INTO kontakti(id,firstName, lastName, username, password, phoneNumber, address , city  VALUES (?,?,?,?,?,?,?,?,?)";

		// new Scanner
		java.util.Scanner input = new java.util.Scanner(System.in);

		System.out.print("Enter user first name: ");
		String firstName = input.next();

		System.out.print("Enter user last name: ");
		String lastName = input.next();

		System.out.print("Enter user username): ");
		String username = input.next();

		System.out.print("Enter user password: ");
		String password = input.next();

		System.out.print("Enter user phoneNumber): ");
		String phoneNumber = input.next();

		System.out.print("Enter user address: ");
		String address = input.next();

		System.out.print("Enter user city): ");
		String city = input.next();

		System.out.print("Enter user isAdmin: ");
		int isAdmin = input.nextInt();

		// close the scanner
		input.close();

		try (
				// java.sql.Statement
				PreparedStatement stmnt = connection.prepareStatement(query);) {


			stmnt.setString(1, firstName);
			stmnt.setString(2, lastName);
			stmnt.setString(2, firstName);
			stmnt.setString(4, username);
			stmnt.setString(5, password);
			stmnt.setString(6, phoneNumber);
			stmnt.setString(7, address);
			stmnt.setString(8, city);
			stmnt.setInt(9, isAdmin);
			stmnt.executeUpdate();

			System.out.println("User added to the database.");
		}

	}

	@Override
	public void printUser(User user) {
		if (user != null) {
			System.out.println("id: " + user.getId() + ", First Name: " + user.getFirstName() + ", Last Name: "
					+ user.getLastName() + ", Username: " + user.getUsername() + ", Password: " + user.getPassword()
					+ ", Phone Number: " + user.getPhoneNumber() + ", Address: " + user.getAddress() + ", City: "
					+ user.getCity() + ", Is User Admin: " + user.getIsAdmin()

			);
		} else {
			System.out.println("No user to print.");
		}
	}

}
