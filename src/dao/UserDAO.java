package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDAO implements UserDaoInterface {

	static Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public ArrayList<User> getAllUsers() throws SQLException {

		ArrayList<User> user = new ArrayList<>();

		String query = "SELECT * FROM kontakti";

		ResultSet rs = null;

		try (Statement statement = connection.createStatement()) {
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

		try (PreparedStatement prepared = connection.prepareStatement(query);) {
			prepared.setInt(1, id);

			rs = prepared.executeQuery();

			if (rs.next()) {
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
	public void changeUser(User user) throws SQLException { // vratiti tamo sve
															// tamou
		if (user != null) {

			String query = "UPDATE kontakti SET  firstName = ?, lastName = ?, username = ?, password = ?, phoneNumber = ?, address = ?, city = ?, isAdmin= ? WHERE id = ?";

			try (PreparedStatement stmnt = connection.prepareStatement(query);) {

				stmnt.setString(1, user.getFirstName());
				stmnt.setString(2, user.getLastName());
				stmnt.setString(3, user.getUsername());
				stmnt.setString(4, user.getPassword());
				stmnt.setString(5, user.getPhoneNumber());
				stmnt.setString(6, user.getAddress());
				stmnt.setString(7, user.getCity());
				stmnt.setInt(8, user.getIsAdmin());
				stmnt.setInt(9, user.getId());
				stmnt.executeUpdate();

				System.out.println("User updated in the database.");
			}
		}
	}

	@Override
	public void deleteUser(int id) throws SQLException {

		String query = "DELETE FROM kontakti WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e);

		}

	}

	@Override
	public void addUser(User user) throws SQLException {

		String query = "INSERT INTO kontakti(firstName, lastName, username, password, phoneNumber, address , city, isAdmin )  VALUES (?,?,?,?,?,?,?,?)";

		try (PreparedStatement stmnt = connection.prepareStatement(query);) {

			stmnt.setString(1, user.getFirstName());
			stmnt.setString(2, user.getLastName());
			stmnt.setString(3, user.getUsername());
			stmnt.setString(4, user.getPassword());
			stmnt.setString(5, user.getPhoneNumber());
			stmnt.setString(6, user.getAddress());
			stmnt.setString(7, user.getCity());
			stmnt.setInt(8, user.getIsAdmin());
			stmnt.executeUpdate();

		}

	}

	@Override
	public ArrayList<User> getUserByName(String name) throws SQLException {
		
		ArrayList<User> user = new ArrayList<>();

		String query = "SELECT * FROM kontakti WHERE firstName = ?";

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, name);

			rs = statement.executeQuery();

			while (rs.next()) {

				user.add(new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("username"), rs.getString("password"), rs.getString("phoneNumber"),
						rs.getString("address"), rs.getString("city"), rs.getInt("isAdmin")));

			}
			rs.close();
		}

		return user;

	}

	
	@Override
	public User login(String username, String password) throws SQLException {

		User user = null;

		String query = "SELECT * FROM kontakti WHERE userName = ? AND password = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, username);
			statement.setString(2, password);

			try (ResultSet rs = statement.executeQuery()) {
				
				if (rs.next()) {
					user = new User(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
							rs.getString("username"), rs.getString("password"), rs.getString("phoneNumber"),
							rs.getString("address"), rs.getString("city"), rs.getInt("isAdmin"));
				}
			}
		}
		return user;

	}

}
