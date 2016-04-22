package demo;

import java.sql.SQLException;

import java.util.Scanner;
import dao.User;
import dao.UserDAO;

public class Admin extends User {
	private static final String adminName = "dijana";
	private static final String adminPassword = "1111";

	public static String getAdminName() {
		return adminName;
	}

	public static String getAdminPassword() {
		return adminPassword;
	}

	public static void adminMenu() throws SQLException {
		UserDAO user = new UserDAO();

		System.out.println("\n-.-.-.- Welcome to Deny addressbook  -.-.-.-\n");
		System.out.println("Chose option please:");
		System.out.println("[1] Add new contacts");
		System.out.println("[2] Delete contatss");
		System.out.println("[3] Show all list of contacts");
		System.out.println("[4] Search contats");
		System.out.println("[5] Update contats");
		System.out.println("[6] Exit from program");
		System.out.println("[0] Log out");

		Scanner adminInput = new Scanner(System.in);
		int adminChoice = 0;

		try {
			adminChoice = adminInput.nextInt();
		} catch (Exception e) {
			System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
			System.out.println("\tUps! Wrong input");
			System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
			adminMenu();
			adminInput.close();
		}
		switch (adminChoice) {
		case 0: {
			System.out.println("\nBye...\n");
			UserDAO.loginMenu();
			break;
		}
		case 1: {
			user.addUser();

			adminMenu();
			break;
		}
		case 2: {
			user.deleteUser(null);

			adminMenu();
			break;
		}
		case 3: {// contact list
			user.getAllUsers();
			adminMenu();
			break;
		}
		case 4: { // get individual contact
			user.getUser(adminChoice);

			adminMenu();
			break;
		}
		case 5: { // update contact
			user.updateUser(null);
			adminMenu();
			break;
		}
		case 6: { // exit from program
			System.out.println("Program will close.");
			System.exit(0);
		}
		default: {
			System.out.println("\nUps! Wrong input, please try again.");
			adminMenu();
		}
		}
	}
}
