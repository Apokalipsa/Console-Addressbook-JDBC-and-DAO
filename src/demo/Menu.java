package demo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.User;
import dao.UserDAO;

public class Menu {

	static UserDAO usDao = new UserDAO();

	static Scanner input = new Scanner(System.in);

	/**
	 * @return
	 * @throws SQLException
	 */
	public static int firstStrat() throws SQLException {
		System.out.println("********************************");
		System.out.println("Welcome to Deny  Address Book");
		System.out.println("1 - Login\n2 - Exit");
		System.out.println("********************************");
		int option = -1;

		do {
			option = input.nextInt();
			if (option == 1) {
				login();
			} else if (option == 2) {

				System.out.println("**Bye my master**");
				System.exit(0);
			} else {

				System.out.println("Ups! Wrong input, please try again.");
			}

		} while (option < 1 || option > 2);

		return option;
	}

	/**
	 * @throws SQLException
	 * 
	 */
	public static void login() throws SQLException {
		boolean isLoggedIn = false;
		int attempt = 2;
		String username = "";
		String password = "";
		User loggedUser = null;

		do {
			System.out.print("Enter username: ");
			username = input.next();
			System.out.println("Enter password:");
			password = input.next();

			loggedUser = usDao.login(username, password);

			if (loggedUser == null) {
				System.out.println("Login failed, pelase try again! You have " + (attempt + 1) + " attempt.");
				attempt--;
			} else {

				if (loggedUser.getIsAdmin() == 0) {
					userMenu();
				} else {
					adminMenu();
				}

				isLoggedIn = true;
				loggedUser = null;
			}

			if (attempt < 0) {
				System.out.println("To manny attempts! Backing to first start.");
				firstStrat();
			}

		} while (!isLoggedIn);

	}

	public static void userMenu() throws SQLException {

		int userChoice = -1;
		do {
			System.out.println("\n-.-.-.- Welcome to Deny  Address Book  -.-.-.-\n");
			System.out.println("Chose option please:");
			System.out.println("[0] Log out.");
			System.out.println("[1]  Show all contacts.");
			System.out.println("[2]  Search individual contact.");
			System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

			try {
				userChoice = input.nextInt();
			} catch (Exception e) {
				System.out.println("Ups wrong input, please enter option number.");
			}

			if (userChoice == 0) {
				System.out.println("Bye...");
				firstStrat();

			} else if (userChoice == 1) {
				ArrayList<User> list = usDao.getAllUsers();

				for (User contacts : list) {
					System.out.println(contacts);
					
				}

			} else if (userChoice == 2) {
				input.nextLine();
				System.out.print("Input search name: ");
				String name = input.nextLine();

				ArrayList<User> individualC = usDao.getUserByName(name);
				if (individualC.isEmpty()) {
					System.out.println("Not found!");
				} else {
					for (User contact : individualC) {
						System.out.println(contact);
					}
				}
			} else {
				System.out.println("Ups! Wrong input!");
			}
		} while (userChoice > 0 || userChoice <= 2);
	}

	public static void adminMenu() throws SQLException {
		// ArrayList<User> listUsers = usDao.getAllUsers();
		int adminChoice = 0;

		do {
			System.out.println("\n-.-.-.- Welcome to Deny addressbook  -.-.-.-\n");
			System.out.println("Chose option please:");
			System.out.println("[1] Add new contacts");
			System.out.println("[2] Delete contatss");
			System.out.println("[3] Show all list of contacts");
			System.out.println("[4] Change contats");
			System.out.println("[5] Exit from program");
			System.out.println("[0] Log out");
			System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

			try {
				adminChoice = input.nextInt();
			} catch (Exception e) {
				System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
				System.out.println("\tUps! Wrong input");
				System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
				adminMenu();

			}

			switch (adminChoice) {
			case 0: {
				System.out.println("\nBye...\n");
				firstStrat();
				break;
			}
			case 1: { // add contact scener inputi???
				User user = new User();
				usDao.addUser(userInfo(user));
				System.out.println();

				break;
			}
			case 2: { // delete contact
				System.out.println("Enter id:");
				int id = input.nextInt();
				System.out.println("Are You Sure: (Y/N):");
				String chose = input.next();
				if (chose.startsWith("Y") || chose.startsWith("y")) {
					usDao.deleteUser(id);
					
					System.out.println("User deleted from the database.");
				} else
					System.out.println("Decline!");
				break;

			}
			case 3: { // contact list
				ArrayList<User> listUsers = usDao.getAllUsers();
				for (User contact : listUsers)
					System.out.println(contact);

				break;
			}
			case 4: { // update contact list
				System.out.println("Enter id:");
				int id = input.nextInt();

				User editedUser = usDao.getUser(id);
				System.out.println(editedUser);

				usDao.changeUser(userInfo(editedUser));
				break;

			}
			case 5: { // exit from program
				System.out.println("Program will close.");
				System.exit(0);
			}
			default: {
				System.out.println("\nUps! Wrong input, please try again.");

			}
			}
		} while (adminChoice >= 0 || adminChoice <= 5);

	}
	
	public static User userInfo(User user){
		
		System.out.print("Enter user first name: ");
		String firstName = input.next();

		System.out.print("Enter user last name: ");
		String lastName = input.next();

		System.out.print("Enter user username: ");
		String username = input.next();

		System.out.print("Enter user password: ");
		String password = input.next();

		System.out.print("Enter user phoneNumber: ");
		String phoneNumber = input.next();

		System.out.print("Enter user address: ");
		String address = input.nextLine();

		System.out.print("Enter user city: ");
		String city = input.next();

		System.out.print("Enter user isAdmin: ");
		int isAdmin = input.nextInt();

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setIsAdmin(isAdmin);
		user.setAddress(address);
		user.setCity(city);
		user.setPassword(password);
		user.setUsername(username);
		user.setPhoneNumber(phoneNumber);
		
		return user;
		
		
	}
}
