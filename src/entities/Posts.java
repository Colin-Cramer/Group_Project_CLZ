package entities;

public class Posts {
	private int id;
	private int userId;
	private String userName;
	private String postContent;
	private String timeStamp;
	
	public Posts (int id, int userId, String userName, String postContent, String timeStamp) {
		this.setId(id);
		this.setUserId(userId);
		this.setUserName(userName);
		this.setPostContent(postContent);
		this.setTimeStamp(timeStamp);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
