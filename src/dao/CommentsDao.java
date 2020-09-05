package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Comments;

public class CommentsDao {

	private Connection connection;
	private final String UPDATE_COMMENT_QUERY = "UPDATE comments SET comment_content = ? WHERE comment_title = ?";
	private final String DELETE_COMMENT_QUERY = "DELETE FROM comments WHERE comment_title = ?";
	private final String CREATE_COMMENT_QUERY = "INSERT INTO comments(username, post_title, comment_title, comment_content) VALUES(?,?,?,?)";
	
	public CommentsDao() {
		connection = DBConnection.getConnection();
	}
	
	public void createUserComment(String username, String postTitle, String commentTitle, String commentContent) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_COMMENT_QUERY);
		ps.setString(1, username);
		ps.setString(2, postTitle);
		ps.setString(3, commentTitle);
		ps.setString(4, commentContent);
		ps.executeUpdate();
	}
		
	public void editUserComment(String commentTitle, String commentContent) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_COMMENT_QUERY);
		ps.setString(1, commentTitle);
		ps.setString(2, commentContent);
		ps.executeUpdate();
	}

	public void deleteUserComment(String commentTitle) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_COMMENT_QUERY);
		ps.setString(1, commentTitle);
		ps.executeUpdate();
	}

//	private Comments populateComment(String commentTitle, String commentContent) {
//		return new Comments(commentTitle, commentContent);
//	}
}
