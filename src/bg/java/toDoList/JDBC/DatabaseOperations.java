package bg.java.toDoList.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bg.java.toDoList.entites.Task;
import bg.java.toDoList.entites.User;

public class DatabaseOperations {
	//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//static final String DB_URL = "jdbc:mysql://localhost:3306/todo_database";
	// private String addTask ="INSERT INTO tasks
	// (task_name,due_date,description) VALUES (?)";
	// Database credentials
	//static final String USER = "root";
	//static final String PASS = "admin";
	//private Connection conn;

	public DatabaseOperations() {
		try {
			connect();
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

	public void connect() throws SQLException, InstantiationException, IllegalAccessException {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = null;
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_database", "phpmyadmin",
				//	"Kontrolla123@");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_database", "root",
					"admin");
			// change it to user: root pass: admin
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void disconnect() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void addTaskRecord(Task task, int userId) throws ClassNotFoundException, SQLException {

		Statement statement = conn.createStatement();
		String task_name = task.getTaskName();
		Long due_dateLong = task.getDueDate().getTime();
		Date due_date = new Date(due_dateLong);
		String description = task.getDescription();
		String taskStatus = task.getTaskStatus();
		StringBuilder builder = new StringBuilder();
		// INSERT INTO tasks (task_name,due_date,description) VALUES (?,?,?)";
		builder.append("INSERT INTO tasks (task_name,due_date,description,task_status,user_id) VALUES(");
		builder.append("\"");
		builder.append(task_name);
		builder.append("\"");
		builder.append(",");
		builder.append("\'");
		builder.append(due_date);
		builder.append("\'");
		builder.append(",");
		builder.append("\"");
		builder.append(description);
		builder.append("\"");
		builder.append(",");
		builder.append("\"");
		builder.append(taskStatus);
		builder.append("\"");
		builder.append(",");
		builder.append("\"");
		builder.append(userId);
		builder.append("\"");
		builder.append(")");
		statement.executeUpdate(builder.toString());
		statement.close();
	}// end main

	public ArrayList<Task> getTaskRecords(int user_id) throws SQLException {
		try {
			Statement statement = conn.createStatement();
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT * FROM `tasks` WHERE task_status=\"pending\" AND user_id=");
			builder.append(user_id);
			builder.append(" ");
			builder.append("ORDER by id ASC;");
			ResultSet rs = statement.executeQuery(builder.toString());
			ArrayList<Task> taskRecords = new ArrayList<Task>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String task_name = rs.getString("task_name");
				Date due_date = (Date) rs.getDate("due_date");
				String description = rs.getString("description");
				Task task = new Task();
				task.setId(id);
				task.setTaskName(task_name);
				task.setDueDate(due_date);
				task.setDescription(description);
				taskRecords.add(task);
			}
			rs.close();
			statement.close();
			return taskRecords;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void deleteTaskRecord(String taskRecord) throws SQLException {

		Statement statement = conn.createStatement();
		String[] recordList = taskRecord.split("-");
		System.out.println(recordList.length);
		int taskId = Integer.parseInt(recordList[0]);
		String sql = "DELETE from tasks WHERE id =" + taskId;
		statement.executeUpdate(sql);
		statement.close();
	}

	public ArrayList<Task> getCompletedTaskRecords() {
		// SELECT * FROM `tasks` WHERE task_status="completed"
		try {
			Statement statement = conn.createStatement();
			ArrayList<Task> completedTasks = new ArrayList<Task>();
			String sql = "SELECT * FROM tasks WHERE task_status=\"completed\" ORDER by id ASC;";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String task_name = rs.getString("task_name");
				Date due_date = (Date) rs.getDate("due_date");
				String description = rs.getString("description");
				Date dateCompleted = (Date) rs.getDate("date_completed");
				Task task = new Task();
				task.setId(id);
				task.setTaskName(task_name);
				task.setDueDate(due_date);
				task.setDescription(description);
				task.setDateCompleted(dateCompleted);
				completedTasks.add(task);
			}
			rs.close();
			statement.close();
			return completedTasks;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addUser(User user) {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String telephone = user.getTelephone();
		String username = user.getUserName();
		String md5Hash = user.getPassword();
		try {
			Statement statement = conn.createStatement();
			StringBuilder builder = new StringBuilder();
			builder.append(
					"INSERT INTO users (username,password,first_name,last_name,email_address,telephone) VALUES(");
			builder.append("\"");
			builder.append(username);
			builder.append("\"");
			builder.append(",");
			builder.append("\"");
			builder.append(md5Hash);
			builder.append("\"");
			builder.append(",");
			builder.append("\"");
			builder.append(firstName);
			builder.append("\"");
			builder.append(",");
			builder.append("\"");
			builder.append(lastName);
			builder.append("\"");
			builder.append(",");
			builder.append("\"");
			builder.append(email);
			builder.append("\"");
			builder.append(",");
			builder.append("\"");
			builder.append(telephone);
			builder.append("\"");
			builder.append(")");
			statement.executeUpdate(builder.toString());
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User getSpecificUser(String username) {
		User user = new User();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT * FROM users WHERE  username=");
		builder.append("\"");
		builder.append(username);
		builder.append("\" ");
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(builder.toString());
				while (rs.next()) {
					int id = rs.getInt("id");
					String password = rs.getString("password");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					String email = rs.getString("email_address");
					String telephone = rs.getString("telephone");
					user.setId(id);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setEmail(email);
					user.setTelephone(telephone);
					user.setUserName(username);
					user.setPassword(password);
					rs.close();
					statement.close();
					return user;
				}			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
