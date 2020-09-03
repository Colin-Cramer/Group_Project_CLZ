package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CommentsDao;
import dao.PostsDao;
import dao.UsersDao;
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
	private List<String> optionsHome = Arrays.asList("Log in Here", "Create Profile");
	private List<String> options = Arrays.asList(
								"View Profile",
								"View Feed",
								"Make a Post", 
								"Edit a Post", 
								"Delete a Post", 
								"Leave a Comment", 
								"Edit a Comment", 
								"Delete a Comment",
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
					if (logIn()) {
						String subSelection = "";

						do {
							printMenu();
							selection = scanner.nextLine();

							try {
								if (subSelection.equals("2")) {
									viewProfile();
								} else if (subSelection.equals("3")) {
									// viewFeed();
								} else if (subSelection.equals("4")) {
									createPost();
								} else if (subSelection.equals("5")) {
									// editPost();
								} else if (subSelection.equals("6")) {
									// deletePost();
								} else if (subSelection.equals("7")) {
									// makeComment();
								} else if (subSelection.equals("8")) {
									// editComment();
								} else if (subSelection.equals("9")) {
									// deleteComment();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							System.out.println("Press enter to continue");
							scanner.hasNextLine();
						} while (!selection.equals("0"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} while (!selection.equals("0"));
	}

	private void printHomeMenu() {
		System.out.println("Are you an existing user?\n~~~~~~~~~~~~~~~~~~~~~~~~~~");
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

	private void viewProfile() throws SQLException {
		System.out.println("Enter Username: ");
		String username = scanner.nextLine();
		Users users = usersDao.viewProfileByUsername(username);
		System.out.println(users.getUserName() + "\n" + users.getFirstName() + " " + users.getLastName() + "\n"
				+ users.getEmail());
	}

	private void createPost() throws SQLException {
		System.out.println("Say what's on your mind: ");
		String postContent = scanner.nextLine();
		postsDao.createUserPost(postContent);
	}

	private boolean logIn() throws SQLException {
		System.out.println("Enter your credentials to log in");
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
		usersDao.userLogIn(username, password);
		return true;
	}
}
