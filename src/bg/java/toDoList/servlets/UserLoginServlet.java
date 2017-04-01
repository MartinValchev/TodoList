package bg.java.toDoList.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService;
	UserInputCheck userInputCheck;
	User user;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		userInputCheck = new UserInputCheck();
		ArrayList<String> errorMessages = new ArrayList<String>();
		errorMessages = userInputCheck.isInputValid(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("errorMessages", errorMessages);
		if (errorMessages.size() > 0) {
			response.sendRedirect("/TodoList/jspNotSecured/login.jsp");
		} else {
			userService = new UserService();
			String hashmd5 = userService.generateMD5(password);
			if (userService.isUserAuthenticated(username, hashmd5)) {
				User user = userService.getUser(username);
				int user_id = user.getId();
				session = request.getSession();
				session.setAttribute("user", username);
				session.setAttribute("user_id", user_id);
				session.setMaxInactiveInterval(30 * 60);
				Cookie cookie = new Cookie("user", username);
				cookie.setMaxAge(30 * 60);
				response.addCookie(cookie);
				response.sendRedirect("/TodoList/jsp/menu.jsp");
			} else {
				response.sendRedirect("/TodoList/jspNotSecured/login.jsp");
			}
		}
	}
}
