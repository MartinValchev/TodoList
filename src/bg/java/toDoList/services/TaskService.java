package bg.java.toDoList.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import bg.java.toDoList.JDBC.DatabaseConnection;
import bg.java.toDoList.entites.Task;

public class TaskService {
	private static DatabaseConnection instance;
	Task task;

	public TaskService() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		task = new Task();
		instance = new DatabaseConnection();
	}

	public void addTask(String taskName, Date dueDate, String desc,String taskStatus,int user_id)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		task.setTaskName(taskName);
		task.setDueDate(dueDate);
		task.setDescription(desc);
		task.setTaskStatus(taskStatus);
		instance.addTaskRecord(task,user_id);
		instance.disconnect();
	}

	public ArrayList<Task> getTasks() {
		try {
			ArrayList<Task> taskList = instance.getTaskRecords();
			instance.disconnect();
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
			instance.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Task> getCompletedTasks() {
		ArrayList<Task> taskList = instance.getCompletedTaskRecords();
		instance.disconnect();
		return taskList;
	}
}
