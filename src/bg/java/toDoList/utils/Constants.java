package bg.java.toDoList.utils;

public class Constants {
	public static final String FIRST_LAST_NAME_PATTERN = "[A-Z]{1}([a-z]){1,}";
	public static final String EMAIL_PATTERN = "^(\\b[A-Z0-9a-z\\._-]+@[A-Z0-9a-z_-]{2,}.[a-z]{2,}\\b)$";
	public static final String TELEPHONE_PATTERN = "0[0-9]{3} [0-9]{3} [0-9]{3}";
	public static final String USERNAME_PATTERN = "^([\\w\\.@]+){5,20}$";
	public static final String PASSWORD_PATTERN = "^([\\w\\.@]+){6,20}$";
	public static final String ERROR_FIRST_LAST_NAME_PATTERN = "First name should comply with one of the following criteria:"
			+ "\r"
			+ "non empty values, name at least 2 characters, only word characters are alowed, one capital letter at the start of the name, no spaces alowed";
	public static final String ERROR_EMAIL_PATTERN = "Email should comply with the following format: username@domain.com";
	public static final String ERROR_TELEPHONE_PATTERN = "Telephone number should comply with the following format 0XXX XXX XXX";
	public static final String ERROR_USERNAME_PATTERN = "Username should not contain any spaces, non empty,can contain the following special characters: '_','@','-',~,!,"
			+ "\r" + "Username length at between 5 and 20 characters";
	public static final String ERROR_PASSWORD_PATTERN = "Password should not contain any spaces, non empty,can contain the following special characters: '_','@','-',~,!,"
			+ "\r" + "Password length at between 6 and 20 characters";
	
}
