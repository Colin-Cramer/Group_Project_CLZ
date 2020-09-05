package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CommentsDao;
import dao.PostsDao;
import dao.UsersDao;
import entities.Comments;
import entities.Posts;
import entities.Users;

public class Menu {

	public static void main(String[] args) {
		Menu homeMenu = new Menu();
		homeMenu.startHome();
	}

	private UsersDao usersDao = new UsersDao();
	private PostsDao postsDao = new PostsDao();
	private CommentsDao commentsDao = new CommentsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> optionsHome = Arrays.asList("Create Profile", "Log in Here", "Type '0' to Exit");
	private List<String> options = Arrays.asList(
								"View Profile",
								"View Feed",
								"Make a Post", 
								"Edit a Post", 
								"Delete a Post", 
								"Leave a Comment", 
								"Edit a Comment", 
								"Delete a Comment",
								"Delete Account",
								"Type '0' to Exit");
	
	public void startHome() {
		String selection = "";

		do {
			printHomeMenu();
			selection = scanner.nextLine();

			try {
				if (selection.equals("1")) {
				createProfile();
				} else if (selection.equals("2")) {
					if (!logIn()) {
						logIn();
					} else {
						start();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} while (!selection.equals("0"));
	}
	
	public void start() {
		String subSelection = "";

		do {
			printMenu();
			subSelection = scanner.nextLine();

			try {
				if (subSelection.equals("1")) {
					viewProfile();
				} else if (subSelection.equals("2")) {
					viewFeed();
				} else if (subSelection.equals("3")) {
					createPost();
				} else if (subSelection.equals("4")) {
					editPost();
				} else if (subSelection.equals("5")) {
					deletePost();
				} else if (subSelection.equals("6")) {
					createComment();
				} else if (subSelection.equals("7")) {
					editComment();
				} else if (subSelection.equals("8")) {
					deleteComment();
				} else if (subSelection.contentEquals("9")) {
					deleteAccount();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Press enter to continue");
			scanner.hasNextLine();
		} while (!subSelection.equals("0"));
	}

	private void printHomeMenu() {
		System.out.println("Are you an existing user? \nChoose an option from below: \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < optionsHome.size(); i++) {
			System.out.println(i + 1 + ") " + optionsHome.get(i));
		}
	}

	private void printMenu() {
		System.out.println("Choose one of the following options:\n~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void createProfile() throws SQLException {
		System.out.println("Enter desired username: ");
		String username = scanner.nextLine();
		System.out.println("Enter desired password: ");
		String password = scanner.nextLine();
		System.out.println("Enter your email: ");
		String email = scanner.nextLine();
		System.out.println("Enter your first name: ");
		String firstname = scanner.nextLine();
		System.out.println("Enter your last name: ");
		String lastname = scanner.nextLine();
		usersDao.createUserProfile(username, password, email, firstname, lastname);
	}
	
	private boolean logIn() throws SQLException {
		System.out.println("Enter your credentials to log in");
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
		boolean logInAttempt = usersDao.userLogIn(username, password);
		return logInAttempt;
	}

	private void viewProfile() throws SQLException {
		System.out.println("Enter Username: ");
		String username = scanner.nextLine();
		Users users = usersDao.viewProfileByUsername(username);
		System.out.println("Username: " + users.getUserName() 
		+ "\n" + "Name: " + users.getFirstName() + " " + users.getLastName() + "\n" + "Email: " + users.getEmail());
	}

	private void viewFeed() throws SQLException {
		System.out.println("Whose feed would you like to see?: ");
		String username = scanner.nextLine();
		Posts posts = postsDao.viewUserFeed(username);
		System.out.println("Username: " + posts.getUserName() + "\n" + "Post Title: " + posts.getPostTitle() + "\n" + "Post: " + posts.getPostContent());
		ArrayList<Comments> comments = postsDao.viewCommentFromPost(posts.getPostTitle());
		for (Comments comment : comments) {
			System.out.println("Comment Title: " + comment.getCommentTitle() + "\n" + "Comment: " + comment.getCommentContent());
		}
	}

	private void createPost() throws SQLException {
		System.out.println("Enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Enter a title for your post: ");
		String postTitle = scanner.nextLine();
		System.out.println("Say what's on your mind: ");
		String postContent = scanner.nextLine();
		postsDao.createUserPost(username, postTitle, postContent);
	}
	
	private void editPost() throws SQLException {
		System.out.println("Enter the title of the post you would like to update: ");
		String postTitle = scanner.nextLine();
		System.out.println("Write your new post: ");
		String postContent = scanner.nextLine();
		postsDao.editUserPost(postTitle, postContent);
	}
	
	private void deletePost() throws SQLException {
		System.out.println("Enter the ID to the post you would like to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		postsDao.deleteUserPost(id);
	}
	
	private void createComment() throws SQLException {
		System.out.println("Enter your username: ");
		String username  = scanner.nextLine();
		System.out.println("Enter the title of the post you want to comment on: ");
		String postTitle = scanner.nextLine();
		System.out.println("Enter a title for your comment: ");
		String commentTitle = scanner.nextLine();
		System.out.println("Leave a comment!: ");
		String commentContent = scanner.nextLine();
		commentsDao.createUserComment(username, postTitle, commentTitle, commentContent);
	}
	
	private void editComment() throws SQLException {
		System.out.println("Enter the title of the comment you would like to update: ");
		String commentTitle = scanner.nextLine();
		System.out.println("Write you new comment: ");
		String commentContent = scanner.nextLine();
		commentsDao.editUserComment(commentTitle, commentContent);
	}

	private void deleteComment() throws SQLException {
		System.out.println("Enter the title of the comment you would like to delete: ");
		String commentTitle = scanner.nextLine();
		commentsDao.deleteUserComment(commentTitle);
	}
	
	private void deleteAccount() throws SQLException {
		System.out.println("WARNING! This will permanently delete your account.");
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
		usersDao.deleteUserAccount(username, password);
	}
}
