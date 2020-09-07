package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Comments;

public class CommentsDao {

	private Connection connection;
	private final String UPDATE_COMMENT_QUERY = "UPDATE comments SET comment_content = ? WHERE comment_title = ?";
	private final String DELETE_COMMENT_QUERY = "DELETE FROM comments WHERE comment_title = ?";
	private final String CREATE_COMMENT_QUERY = "INSERT INTO comments(username, post_title, comment_title, comment_content) VALUES(?,?,?,?)";
	private final String VIEW_COMMENT_QUERY = "SELECT * FROM comments WHERE post_title = ?";
	
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
	
	public ArrayList<Comments> viewCommentFromPost(String postTitle) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(VIEW_COMMENT_QUERY);
		ps.setString(1, postTitle);
		ResultSet rs = ps.executeQuery();
		ArrayList<Comments> comments = new ArrayList<Comments>();
		while(rs.next()) {
			String postTitle1 = rs.getString(2);
			String commentTitle = rs.getString(1);
			String commentContent = rs.getString(4);
			Comments comment = new Comments(postTitle1, commentTitle, commentContent);
			comments.add(comment);
		}
		return comments;
	}
}
