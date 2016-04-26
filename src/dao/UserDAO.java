package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import demo.ConnectionManager;
import demo.Meni;

public class UserDAO implements UserDaoInterface {

	static Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public ArrayList<User> getAllUsers() throws SQLException {
		

		ArrayList<User> user = new ArrayList<>();

		String query = "SELECT * FROM kontakti";

		ResultSet rs = null;

		
				try(Statement statement = connection.createStatement()) {
					rs = statement.executeQuery(query);

			while (rs.next()) {
				user.add(new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("username"), rs.getString("password"), rs.getString("phoneNumber"),
						rs.getString("address"), rs.getString("city"), rs.getInt("isAdmin")));

				
			}

		}

		return user;
	}

	

	public User getUser(int id) throws SQLException {
		User user = null;		
		String query = "SELECT * FROM kontakti WHERE id = ?";
		
		ResultSet rs = null;
		
		try(PreparedStatement prepared = connection.prepareStatement(query);) {
			prepared.setInt(1, id);
			
			rs = prepared.executeQuery();
			
			if(rs.next()){
				user = new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("username"), rs.getString("password"), rs.getString("phoneNumber"),
						rs.getString("address"), rs.getString("city"), rs.getInt("isAdmin"));
			} else {
				System.out.println("Ne postoji u bazi!");
			}
		}
		
		return user;
	}

	@Override
	public void changeUser(User user) throws SQLException {
		if (user != null) {

			String query = "UPDATE kontakti SET  firstName = ?, lastName = ?, username = ?, password = ?, phoneNumber = ?, address = ?, city = ?, isAdmin= ? WHERE id = ?";
			java.util.Scanner input = new java.util.Scanner(System.in);
			Meni.loginMenu();
			printUser(user);
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

			input.close();

			try (PreparedStatement stmnt = connection.prepareStatement(query);) {

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

				System.out.println("User updated in the database.");
			}
		}
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		if (user != null) {

			String query = "DELETE FROM kontakti WHERE id = ?";

			try (PreparedStatement statement = connection.prepareStatement(query);) {

				statement.setInt(1, user.getId());
				java.util.Scanner input = new java.util.Scanner(System.in);

				Meni.loginMenu();
				printUser(user);
				System.out.println("Are You Sure: (Y/N):");
				String chose = input.next();
				if (chose.startsWith("Y") || chose.startsWith("y")) {
					statement.executeUpdate();
					input.close();

					System.out.println("User deleted from the database.");
				} else
					System.out.println("Decline!");

			} catch (SQLException e) {
				System.err.println(e);
				
			}
			
		}
		
	}

	@Override
	public void addUser() throws SQLException {

		String query = "INSERT INTO kontakti(id,firstName, lastName, username, password, phoneNumber, address , city  VALUES (?,?,?,?,?,?,?,?,?)";

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

		input.close();

		try (

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

	@Override
	public ArrayList<User> getUsergetUserByName() throws SQLException {
		ArrayList<User> user = new ArrayList<>();

		java.util.Scanner input = new java.util.Scanner(System.in);

		String query = "SELECT * FROM kontakti WHERE firstName = ?";

		ResultSet rs = null;
		System.out.println("Enter a name for your search:");
		String name = input.next();

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, name);

			rs = statement.executeQuery();

			if (rs.next()) {

				user.add(new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("username"), rs.getString("password"), rs.getString("phoneNumber"),
						rs.getString("address"), rs.getString("city"), rs.getInt("isAdmin")));

				rs.close();
			}
			input.close();
		}

		return user;

	}

	
	}


