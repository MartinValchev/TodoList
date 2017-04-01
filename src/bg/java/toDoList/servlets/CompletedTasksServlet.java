package bg.java.toDoList.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.java.toDoList.entites.Task;
import bg.java.toDoList.services.TaskService;

/**
 * Servlet implementation class CompletedTasksServlet
 */
@WebServlet("/CompletedTasksServlet")
public class CompletedTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskService taskService;
		try {
			taskService = new TaskService();
			ArrayList<Task> completedList =taskService.getCompletedTasks();
			request.getSession().setAttribute("completed_tasks", completedList);
			response.sendRedirect("/TodoList/jsp/completedList.jsp");
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
		
	}

}
