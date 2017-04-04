package bg.java.toDoList.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import bg.java.toDoList.JDBC.DatabaseConnection;
import bg.java.toDoList.entites.Task;

public class TaskService {
	private DatabaseConnection instance;
	Task task;

	public TaskService() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		task = new Task();
		ServletContext sc
	}

	public void addTask(String taskName, Date dueDate, String desc,String taskStatus,int user_id)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		task.setTaskName(taskName);
		task.setDueDate(dueDate);
		task.setDescription(desc);
		task.setTaskStatus(taskStatus);
		
		instance.addTaskRecord(task,user_id);
	}

	public ArrayList<Task> getTasks(int user_id) {
		try {
			ArrayList<Task> taskList = instance.getTaskRecords(user_id);
			return taskList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void deleteTask(String taskRecord) {
		try {
			instance.deleteTaskRecord(taskRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Task> getCompletedTasks() {
		ArrayList<Task> taskList = instance.getCompletedTaskRecords();
		return taskList;
	}
}
