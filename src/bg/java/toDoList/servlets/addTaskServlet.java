package bg.java.toDoList.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bg.java.toDoList.services.TaskService;

/**
 * Servlet implementation class addTaskServlet
 */
@WebServlet("/addTaskServlet")
public class addTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String taskName = (String) request.getParameter("task_name");
			String dueDateStr = (String) request.getParameter("due_date");
			Date dueDate = null;	
			SimpleDateFormat df2 = new SimpleDateFormat("yyyy-mm-dd");
			dueDate = df2.parse(dueDateStr);
			TaskService taskService = new TaskService();
			taskService= new TaskService();
			String description = request.getParameter("description");
			String taskStatus = "pending";
			HttpSession session = request.getSession();
			int user_id = (int)session.getAttribute("user_id");
			taskService.addTask(taskName, dueDate, description,taskStatus,user_id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/TodoList/jspNotSecured/TaskAdded.jsp");
	}
}
