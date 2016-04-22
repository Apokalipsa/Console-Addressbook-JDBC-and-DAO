package demo;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.User;
import dao.UserDAO;

public class DaoTest {
public static void main(String[] args) throws SQLException {
		
		UserDAO studentDAO = new UserDAO();

		//get all students
		ArrayList<User> users = studentDAO.getAllUsers();
		

		//print all students
		for (User e : users) {
			studentDAO.printUser(e);
		}
//		
//		//print student
//		studentDAO.printUser(studentDAO.getUser(1));
//		
//		//update student
//		studentDAO.updateUser(studentDAO.getUser(1));	
//		
//		//delete student
//		studentDAO.deleteUser(studentDAO.getUser(1));
//		
//		//add a student
//		studentDAO.addUser();
//		
		//close the connection
		ConnectionManager.getInstance().close();
	}

        

//        // Obtain UserDAO.
//        UserDAO userDAO = new UserDAO();
//     
//
//        // Create user.
//        User user = new User();
//        user.setId(36);
//        user.setFirstName("Lorem");
//        user.setLastName("Ipsum");
//        user.setUsername("lora");
//        user.setPassword("lorica");
//        user.setPhoneNumber("066111000");
//        user.setAddress("Nike Neznanovic");
//        user.setCity("London");
//        user.setIsAdmin(0);
//        
//      
//
//      userDAO.addUser(user);
//        System.out.println("User successfully created: " + user);

//        // Create another user.
//        User anotherUser = new User();
//        anotherUser.setEmail("bar@foo.com");
//        anotherUser.setPassword("anotherPassword");
//        anotherUser.setFirstname("Bar");
//        anotherUser.setLastname("Foo");
//        anotherUser.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse("1978-03-26"));
//        userDAO.create(anotherUser);
//        System.out.println("Another user successfully created: " + anotherUser);
//
//        // Update user.
//        user.setFirstname("Foo");
//        user.setLastname("Bar");
//        userDAO.update(user);
//        System.out.println("User successfully updated: " + user);
//
//        // Update user.
//        user.setFirstname("Foo");
//        user.setLastname("Bar");
//        userDAO.update(user);
//        System.out.println("User successfully updated: " + user);
//
//        // List all users.
//        ArrayList<User> users = userDAO.getAllUser();
//        System.out.println("List of users successfully queried: " + users);
//        System.out.println("Thus, amount of users in database is: " + users.size());
//
//        // Delete user.
//        userDAO.delete(user);
//        System.out.println("User successfully deleted: " + user);
//
//        // Check if email exists.
//        boolean exist = userDAO.existEmail("foo@bar.com");
//        System.out.println("This email should not exist anymore, so this should print false: " + exist);
//
//        // Change password.
//        anotherUser.setPassword("newAnotherPassword");
//        userDAO.changePassword(anotherUser);
//        System.out.println("Another user's password successfully changed: " + anotherUser);
//
//        // Get another user by email and password.
//        User foundAnotherUser = userDAO.find("bar@foo.com", "newAnotherPassword");
//        System.out.println("Another user successfully queried with new password: " + foundAnotherUser);
//
//        // Delete another user.
//        userDAO.delete(foundAnotherUser);
//        System.out.println("Another user successfully deleted: " + foundAnotherUser);

//        // List all users again.
//        users = userDAO.getAllUser();
//        System.out.println("List of users successfully queried: " + users);
//        System.out.println("Thus, amount of users in database is: " + users.size());
//    }
//
}



