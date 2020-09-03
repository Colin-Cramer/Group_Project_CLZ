package entities;

public class Comments {
	private int id;
	private int postId;
	private String userName;
	private String commentContent;
	private String timeStamp;
	
	public Comments (int id, int postId, String userName, String commentContent, String timeStamp) {
		this.setId(id);
		this.setPostId(postId);
		this.setUserName(userName);
		this.setCommentContent(commentContent);
		this.setTimeStamp(timeStamp);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
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
}
