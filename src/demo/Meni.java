package demo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.User;
import dao.UserDAO;
import demo.ConnectionManager;

public class Meni {

	static java.util.Scanner input = new java.util.Scanner(System.in);

	public static void loginMenu() throws SQLException {

		System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
		System.out.println("Chose option please: \n1 : Admin;\n2 : User");
		System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

		int option;
		do {
			option = input.nextInt();
			if (option < 1 || option > 2)
				System.out.println("Ups! Wrong input, please try again.");
		} while (option < 1 || option > 2);
		if (option == 1) {
			System.out.println("Enter password:");
			String pass = input.next();
			if (pass.equals(ConnectionManager.getPass()))
				adminMenu();
			else {
				System.out.println("Wrong input!");
				loginMenu();
			}
		}
		if (option == 2)
			userMenu();
	}

	public static void adminMenu() throws SQLException {
		UserDAO user = new UserDAO();
		ArrayList<User> list = user.getAllUsers();

		System.out.println("\n-.-.-.- Welcome to Deny addressbook  -.-.-.-\n");
		System.out.println("Chose option please:");
		System.out.println("[1] Add new contacts");
		System.out.println("[2] Delete contatss");
		System.out.println("[3] Show all list of contacts");
		System.out.println("[4] Change contats");
		System.out.println("[5] Exit from program");
		System.out.println("[0] Log out");
		System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

		int adminChoice = 0;

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
			Meni.loginMenu();
			break;
		}
		case 1: { // add contact
			user.addUser();

			break;
		}
		case 2: { // delete contact
			System.out.println("Enter id:");
			int id = input.nextInt();
			user.deleteUser(user.getUser(id));
			break;

		}
		case 3: { // contact list
			for (User contact : list)
				user.printUser(contact);

			break;
		}
		case 4: { // update contact list
			System.out.println("Enter id:");
			int id = input.nextInt();
			user.changeUser(user.getUser(id));
			break;

		}
		case 5: { // exit from program
			System.out.println("Program will close.");
			System.exit(0);
		}
		default: {
			System.out.println("\nUps! Wrong input, please try again.");
			adminMenu();
		}
		}

	}

	public static void userMenu() throws SQLException {
		UserDAO user = new UserDAO();

		System.out.println("\n-.-.-.- Welcome to Deny addressbook  -.-.-.-\n");
		System.out.println("Chose option please:");
		System.out.println("[0] Log out.");
		System.out.println("[1]  Show all contacts.");
		System.out.println("[2]  Search individual contact.");
		System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

		int userChoice = 0;
		try {
			userChoice = input.nextInt();
		} catch (Exception e) {
			System.out.println("Ups wrong input, please enter option number.");
			userMenu();
			input.close();
		}
		switch (userChoice) {
		case 0: {// log out
			System.out.println("Bye...");

			Meni.loginMenu();

		}
		case 1: { // Show all contact list

			ArrayList<User> list = user.getAllUsers();

			userMenu();
			for (User contacts : list) {
				user.printUser(contacts);
			}
			;

			break;
		}
		case 2: {// search individual contacts
			ArrayList<User> individualC = user.getUsergetUserByName();

			for (User contact : individualC) {
				user.printUser(contact);
			}
			;

			break;
		}
		default: {
			System.out.println("Ups! Wrong input!");
			userMenu();
			break;
		}
		}
	}

}
