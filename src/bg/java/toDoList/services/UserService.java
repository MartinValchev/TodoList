package bg.java.toDoList.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import bg.java.toDoList.JDBC.DatabaseConnection;
import bg.java.toDoList.entites.User;

public class UserService {
	private DatabaseConnection instance;
	User user;

	public UserService()
	 {		
		user = new User();
		instance = new DatabaseConnection();

	}

	public boolean addUser(User user) {
		String username = user.getUserName();
		String md5hash = generateMD5(user.getPassword());
		user.setPassword(md5hash);
		if (getUser(username) ==null) {
			instance.addUser(user);
			return true;
		}else{
			return false;
		}

		// user.setPassword
	}

	public String generateMD5(String input) {
		String plaintext = input;
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(plaintext.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			String hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32
			// chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	public User getUser(String username){
		
		user = instance.getSpecificUser(username);
	return user;
	}
	public boolean isUserAuthenticated(String username,String password) {
		User user = new User();
		user = instance.getSpecificUser(username);
		
		// check if user exists in the database
		if (user !=null){
			String passwordDB =user.getPassword();
			if(password.equals(passwordDB)){
				return true;
			}
			return false;
		}else{
			return false;
		}
	}
	
	public void logInUser(String username){
	
	}

}
