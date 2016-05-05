package demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

	/**
	 * This class is created to test input from user
	 * 
	 */

	public static int inputInt() {
		Scanner input = new Scanner(System.in);
		int i = 0;
		boolean isOk = false;

		do {
			try {
				i = input.nextInt();
				isOk = true;
			} catch (InputMismatchException e) {
				System.out.println("You are not entered int value. Try again.");
				input.nextLine();
			}

		} while (!isOk);

		input.close();
		return i;
	}

	public static String inputNext() {
		Scanner input = new Scanner(System.in);
		String str = "";
		boolean isOk = false;

		do {
			try {
				str = input.nextLine();
				isOk = true;
			} catch (InputMismatchException e) {
				System.out.println("You are not entered String value. Try again.");
				input.nextLine();
			}

		} while (!isOk);

		input.close();
		return str;
	}

}
