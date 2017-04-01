package bg.java.toDoList.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bg.java.toDoList.entites.User;
import bg.java.toDoList.services.UserService;
import bg.java.toDoList.utils.UserInputCheck;

/**
 * Servlet implementation class addUserServlet
 */
@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private UserInputCheck userInputCheck;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		userInputCheck = new UserInputCheck();
		ArrayList<String> errorMessages = new ArrayList<String>();
		errorMessages = userInputCheck.isInputValid(firstName, lastName, email, telephone, username,
				password);
		HttpSession session = request.getSession();
		session.setAttribute("errorMessages", errorMessages);
		if (errorMessages.size() > 0) {
			response.sendRedirect("/TodoList/jspNotSecured/createUser.jsp");
		} else {
			userService = new UserService();
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setTelephone(telephone);
			user.setPassword(password);
			user.setUserName(username);

			boolean isUserAdded = userService.addUser(user);
			if (isUserAdded) {
				request.getSession().setAttribute("username", username);
				User userDB = userService.getUser(username);
				int userId = userDB.getId();
				session = request.getSession();
				session.setAttribute("user_id", userId);
				session.setMaxInactiveInterval(30 * 60);
				Cookie cookie = new Cookie("user", username);
				cookie.setMaxAge(30 * 60);
				response.addCookie(cookie);
				response.sendRedirect("/TodoList/jspNotSecured/userAdded.jsp");
			} else {
				response.sendRedirect("/TodoList/jspNotSecured/userAlreadyExists.jsp");
			}
		}

	}

}
