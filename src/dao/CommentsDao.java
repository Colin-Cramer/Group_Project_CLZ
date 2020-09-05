package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentsDao {

	private Connection connection;
	private final String UPDATE_COMMENT_QUERY = "UPDATE comments SET comment_content = ? WHERE comment_title = ?";
	private final String DELETE_COMMENT_QUERY = "DELETE FROM comments WHERE comment_title = ?";
	
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

}
