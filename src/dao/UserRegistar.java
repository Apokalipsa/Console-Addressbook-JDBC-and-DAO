package dao;

import java.util.ArrayList;

public class UserRegistar {

	private static ArrayList<User> userList = new ArrayList<>();

	static ArrayList<User> getUserList() {
		return userList;
	}

	static void setUserList(ArrayList<User> userList) {
		UserRegistar.userList = userList;
	}

	public static User getUser(String username, String password) {
		User user = null;
		boolean status = false;

		for (int i = 0; i < userList.size(); i++) {
			user = (User) userList.get(i);
			if ((username.equals(user.getUsername())) && (password.equals(user.getPassword()))) {
				status = true;
				break;
			}
		}
		if (status) {
			return user;
		} else {
			return null;
		}
	}

	public static User getUser(String username) {
		User user = null;
		boolean status = false;

		for (int i = 0; i < userList.size(); i++) {
			user = (User) userList.get(i);
			if (username.equals(user.getUsername())) {
				status = true;
				break;
			}
		}
		if (status) {
			return user;
		} else {
			return null;
		}
	}
}
