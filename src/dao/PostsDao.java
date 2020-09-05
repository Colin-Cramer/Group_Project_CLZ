package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostsDao {

	private Connection connection;
	private final String CREATE_POST_QUERY = "INSERT INTO posts(username, post_title, post_content) VALUES(?,?,?)";
	private final String UPDATE_POST_QUERY = "UPDATE posts SET post_content = ? WHERE post_title = ?";
	private final String DELETE_POST_QUERY = "DELETE FROM posts WHERE post_title = ?";
	
	public void createUserPost(String username, String postTitle, String postContent) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_POST_QUERY);
		ps.setString(1, username);
		ps.setString(2, postTitle);
		ps.setString(3, postContent);
		ps.executeUpdate();	
	}

	public void editUserPost(String postTitle, String postContent) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_POST_QUERY);
		ps.setString(1, postTitle);
		ps.setString(2, postContent);
		ps.executeUpdate();
	}

	public void deleteUserPost(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_POST_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
}