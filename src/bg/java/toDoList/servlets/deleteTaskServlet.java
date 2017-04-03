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
 * Servlet implementation class deleteTaskServlet
 */
@WebServlet("/deleteTaskServlet")
public class deleteTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String taskRecord = request.getParameter("taskRecord");
			TaskService taskService = new TaskService();
			taskService.deleteTask(taskRecord);
			HttpSession session = request.getSession();
			int user_id = (int) session.getAttribute("user_id");
			ArrayList<Task> taskList =taskService.getTasks(user_id);
			request.getSession().setAttribute("tasks", taskList);
			response.sendRedirect("/TodoList/jspNotSecured/taskDeleted.jsp");
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
