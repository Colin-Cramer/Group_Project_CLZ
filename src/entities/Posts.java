package entities;

public class Posts {
	private String postTitle;
	private String userName;
	private String postContent;
	
	public Posts (String postTitle, String userName, String postContent) {
		this.postTitle = postTitle;
		this.userName = userName;
		this.postContent = postContent;
	}
	
	public Posts (String userName, String postContent) {
		this.postContent = postContent;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPostContent() {
		return postContent;
	}

	public String getPostTitle() {
		return postTitle;
	}
}
