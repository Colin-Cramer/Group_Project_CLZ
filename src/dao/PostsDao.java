package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostsDao {

	private Connection connection;
	private UsersDao usersDao;
	private CommentsDao commentsDao;
	private final String CREATE_POST_QUERY = "INSERT INTO posts(post_content) VALUES(?)";
	
	public void createUserPost(String postContent) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_POST_QUERY);
		ps.setString(1, postContent);
		ps.executeUpdate();	
	}
	
}