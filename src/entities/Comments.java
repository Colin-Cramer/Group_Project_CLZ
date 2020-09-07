package entities;

public class Comments {
	private String commentTitle;
	private String postTitle;
	private String userName;
	private String commentContent;
	
	public Comments (String commentTitle, String postTitle, String userName, String commentContent) {
		this.commentTitle = commentTitle;
		this.postTitle = postTitle;
		this.userName = userName;
		this.commentContent = commentContent;
	}
	
	public Comments (String postTitle, String commentTitle, String commentContent) {
		this.postTitle = postTitle;
		this.commentTitle = commentTitle;
		this.commentContent = commentContent;
	}

	public String getUserName() {
		return userName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public String getCommentTitle() {
		return commentTitle;
	}

	public String getPostTitle() {
		return postTitle;
	}
}
