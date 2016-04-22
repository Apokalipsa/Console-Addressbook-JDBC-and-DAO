package dao;

import java.sql.SQLException;
import java.util.Scanner;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String phoneNumber;
	private String address;
	private String city;
	private int isAdmin;

	/**
	 * no-arg constructor
	 */
	public User() {

	}

	public User(int id, String firstName, String lastName, String username, String password, String phoneNumber,
			String address, String city, int isAdmin) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", address=" + address + ", city=" + city
				+ ", isAdmin=" + isAdmin + "]";
	}

	public static void userMenu(User currentUser) throws SQLException {

		System.out.println("\n******* Welcome to my addressbook console program *******\n");
		System.out.println("Chose the option\n");
		System.out.println("Option 0:  Log out.");
		System.out.println("Option 1:  Show all contacts.");
		System.out.println("Option 2:  Search individual contact.");

		Scanner userInput = new Scanner(System.in);
		int userChoice = 0;
		try {
			userChoice = userInput.nextInt();
		} catch (Exception e) {
			System.out.println("Ups wrong input, please enter option number.");
			userMenu(currentUser);
			userInput.close();
		}
		switch (userChoice) {
		case 0: {// log out
			System.out.println("Bye...");
		
			UserDAO.loginMenu();

		}
		case 1: { // Show all contact list

			try {
				

			} catch (Exception ex) {
				System.out.println("Ups! Something went wrong. Please try again latter");
				userMenu(currentUser);
			}
			
			userMenu(currentUser);
			break;

		}
		case 2: {// search individual contacts

			userMenu(currentUser);

			break;
		}
		default: {
			System.out.println("Unijeli ste pogresnu vrijednost!");
			userMenu(currentUser);
		}
		}
	}
}
