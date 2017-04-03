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
 * Servlet implementation class taskListServlet
 */
@WebServlet("/taskListServlet")
public class taskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskService taskService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			taskService= new TaskService(); 
			HttpSession session = request.getSession();
			int user_id = (int) session.getAttribute("user_id");
			ArrayList<Task> taskList =taskService.getTasks(user_id);
			request.getSession().setAttribute("tasks", taskList);
			response.sendRedirect("/TodoList/jsp/todoList.jsp");
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
