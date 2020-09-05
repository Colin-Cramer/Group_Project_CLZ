package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Comments;
import entities.Posts;

import java.sql.ResultSet;

public class PostsDao {

	private Connection connection;
	private final String CREATE_POST_QUERY = "INSERT INTO posts(username, post_title, post_content) VALUES(?,?,?)";
	private final String UPDATE_POST_QUERY = "UPDATE posts SET post_content = ? WHERE post_title = ?";
	private final String DELETE_POST_QUERY = "DELETE FROM posts WHERE post_title = ?";
	private final String VIEW_POST_COMMENT_QUERY = "SELECT p.username, p.post_title, p.post_content, c.comment_title, c.comment_content "
												+ "FROM posts p INNER JOIN comments c ON c.username = p.username WHERE p.username = ?";
	private final String VIEW_COMMENT_QUERY = "SELECT * FROM comments WHERE post_title = ?";
	
	public PostsDao() {
		connection = DBConnection.getConnection();
	}
	
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

	public Posts viewUserFeed(String username) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(VIEW_POST_COMMENT_QUERY);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePost(rs.getString(1), rs.getString(2), rs.getString(3));
	}
	
	@SuppressWarnings("null")
	public ArrayList<Comments> viewCommentFromPost(String postTitle) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(VIEW_COMMENT_QUERY);
		ps.setString(1, postTitle);
		ResultSet rs = ps.executeQuery();
		ArrayList<Comments> comments = null;
		while(rs.next()) {
			String commentTitle = rs.getString(1);
			String commentContent = rs.getString(2);
			Comments comment = new Comments(commentTitle, commentContent);
			comments.add(comment);
		}
		return comments;
		
	}
	
	private Posts populatePost(String username, String postTitle, String postContent) {
		return new Posts(username, postTitle, postContent);
	}
	
}