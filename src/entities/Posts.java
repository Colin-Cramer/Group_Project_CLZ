package entities;

public class Posts {
	private String postTitle;
	private String userName;
	private String postContent;
	private String timeStamp;
	
	public Posts (String postTitle, String userName, String postContent, String timeStamp) {
		this.setPostTitle(postTitle);
		this.setUserName(userName);
		this.setPostContent(postContent);
		this.setTimeStamp(timeStamp);
	}
	
	public Posts (String userName, String postContent) {
		this.setPostContent(postContent);
		this.setUserName(userName);
	}
	
	public Posts (String postTitle, String userName, String postContent) {
		this.setPostTitle(postTitle);
		this.setUserName(userName);
		this.setPostContent(postContent);
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

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
}
