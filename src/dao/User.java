package dao;

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

	
	 // no-arg constructor
	 
	public User() {

	}

	// constructor for database comunication
	public User(int id, String firstName, String lastName, String username, String password, String phoneNumber,
			String address, String city, int isAdmin) {

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

	// constructor for creation new user into database
	public User(String firstName, String lastName, String username, String password, String phoneNumber, String address,
			String city, int isAdmin) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.isAdmin = 0;
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
}
