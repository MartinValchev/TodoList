package bg.java.toDoList.utils;

import java.util.ArrayList;

public class testUtils {

	public static void main(String[] args) {
		UserInputCheck inputCheck = new UserInputCheck();
		ArrayList<String> errors  = inputCheck.isInputValid("p", "123");

	}

}
