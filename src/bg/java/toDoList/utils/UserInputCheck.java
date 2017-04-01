package bg.java.toDoList.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputCheck {
	private ArrayList<String> errorMessages;

	public ArrayList<String> isInputValid(String firstName, String lastName, String email, String telephone,
			String username, String password) {
		errorMessages = new ArrayList<String>();
		// first name check
		Pattern firstPattern = Pattern.compile(Constants.FIRST_LAST_NAME_PATTERN);
		Matcher firstMatcher = firstPattern.matcher(firstName);
		if (!firstMatcher.find()) {

			errorMessages.add(Constants.ERROR_FIRST_LAST_NAME_PATTERN);
		}
		// last name check
		firstPattern = Pattern.compile(Constants.FIRST_LAST_NAME_PATTERN);
		firstMatcher = firstPattern.matcher(lastName);
		if (!firstMatcher.find()) {

			errorMessages.add(Constants.ERROR_FIRST_LAST_NAME_PATTERN);
		}
		firstPattern = Pattern.compile(Constants.EMAIL_PATTERN);
		firstMatcher = firstPattern.matcher(email);
		if (!firstMatcher.find()) {

			errorMessages.add(Constants.ERROR_EMAIL_PATTERN);
		}
		firstPattern = Pattern.compile(Constants.TELEPHONE_PATTERN);
		firstMatcher = firstPattern.matcher(telephone);
		if (!firstMatcher.find()) {

			errorMessages.add(Constants.ERROR_TELEPHONE_PATTERN);
		}
		firstPattern = Pattern.compile(Constants.USERNAME_PATTERN);
		firstMatcher = firstPattern.matcher(username);
		if (!firstMatcher.find()) {

			errorMessages.add(Constants.ERROR_USERNAME_PATTERN);
		}
		firstPattern = Pattern.compile(Constants.PASSWORD_PATTERN);
		firstMatcher = firstPattern.matcher(password);
		if (!firstMatcher.find()) {
			errorMessages.add(Constants.ERROR_PASSWORD_PATTERN);
		}
		return errorMessages;
	}
	public ArrayList<String> isInputValid(String username, String password) {
		Pattern firstPattern;
		Matcher firstMatcher;
		errorMessages = new ArrayList<String>();
		firstPattern = Pattern.compile(Constants.USERNAME_PATTERN);
		firstMatcher = firstPattern.matcher(username);
		if (!firstMatcher.find()) {
			errorMessages.add(Constants.ERROR_USERNAME_PATTERN);
		}
		firstPattern = Pattern.compile(Constants.PASSWORD_PATTERN);
		firstMatcher = firstPattern.matcher(password);
		if (!firstMatcher.find()) {
			errorMessages.add(Constants.ERROR_PASSWORD_PATTERN);
		}
		return errorMessages;
	}
}
