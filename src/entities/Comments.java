package entities;

public class Comments {
	private String commentTitle;
	private String postTitle;
	private String userName;
	private String commentContent;
	private String timeStamp;
	
	public Comments (int id, int postId, String userName, String commentContent, String timeStamp) {
		this.setCommentTitle(timeStamp);
		this.setPostTitle(timeStamp);
		this.setUserName(userName);
		this.setCommentContent(commentContent);
		this.setTimeStamp(timeStamp);
	}
	
	public Comments (String commentTitle, String commentContent) {
		this.setCommentTitle(commentTitle);
		this.setCommentContent(commentContent);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getCommentTitle() {
		return commentTitle;
	}


	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}


	public String getPostTitle() {
		return postTitle;
	}


	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
}
