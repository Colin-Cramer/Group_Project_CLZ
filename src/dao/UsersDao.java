package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Users;

public class UsersDao {
	
	private Connection connection;
	private PostsDao postsDao;
	private CommentsDao commentsDao;
	private final String CREATE_PROFILE_QUERY = "INSERT INTO users(username, password, email, first_name, last_name) VALUES(?,?,?,?,?)";
	private final String VIEW_PROFILE_QUERY = "SELECT first_name, last_name, email FROM users WHERE username = ?";
	private final String USER_LOGIN_QUERY = "SELECT username, password FROM users WHERE username = ? AND password = ?";
	
	public UsersDao() {
		connection = DBConnection.getConnection();
		postsDao = new PostsDao();
		commentsDao = new CommentsDao();
	}
	
	public void createUserProfile(String username, String password, String email, String firstname, String lastname) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_PROFILE_QUERY);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, email);
		ps.setString(4, firstname);
		ps.setString(5, lastname);
		ps.executeUpdate();
	}
	
	public Users viewProfileByUsername(String username) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(VIEW_PROFILE_QUERY);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateUsers(rs.getString(1), rs.getString(2), rs.getString(3));
	}
	
	public boolean userLogIn(String username, String password) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(USER_LOGIN_QUERY);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return true;
	}
	
	private Users populateUsers(String firstName, String lastName, String email) {
		return new Users(firstName, lastName, email);
	}
}
