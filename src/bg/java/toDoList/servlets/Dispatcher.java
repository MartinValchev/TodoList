package bg.java.toDoList.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bg.java.toDoList.entites.Task;
import bg.java.toDoList.services.TaskService;

/**
 * Servlet implementation class Dispatcher
 */
@WebServlet("/Dispatcher")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		if (request.getParameter("addTask") != null) {
			response.sendRedirect("/TodoList/jsp/addTask.jsp");
		} else if (request.getParameter("deleteTask") != null) {
			TaskService taskService;
			try {
				// if tasks already in session
				if (request.getSession().getAttribute("tasks") == null) {
					taskService = new TaskService();
					HttpSession session = request.getSession();
					int user_id = (int) session.getAttribute("user_id");
					ArrayList<Task> taskList = taskService.getTasks(user_id);
					request.getSession().setAttribute("tasks", taskList);
				}
				response.sendRedirect("/TodoList/jsp/deleteTask.jsp");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (request.getParameter("taskCompleted") != null) {
			response.sendRedirect("/CompletedTasksServlet");
		} else if (request.getParameter("taskList") != null) {
			response.sendRedirect("/taskListServlet");
		} else if (request.getParameter("login") != null) {
			response.sendRedirect("jspNotSecured/login.jsp");
		} else if (request.getParameter("register") != null) {
			response.sendRedirect("jspNotSecured/createUser.jsp");
		}
	}

}
