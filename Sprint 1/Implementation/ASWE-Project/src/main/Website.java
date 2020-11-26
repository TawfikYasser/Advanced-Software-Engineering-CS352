package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Website {

	public static ArrayList<User> users;
	public static CRUD crud;
	public static Scanner inputMain = new Scanner(System.in);


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		users = new ArrayList<User>();
		crud = new CRUD();
		// Adding the basic notifications
		crud.notifications.add(new Notification("Confirmation Mail", "Please, Verify your account by entering -v-",
				"EN", "Email", "0", "1"));
		crud.notifications
				.add(new Notification("Forget Password", "Please, Enter a new password ", "EN", "Email", "0", "1"));
		crud.notifications.add(new Notification("Welcome", "Welcome to our booking system", "EN", "Email", "0", "0"));

		crud.notifications.add(new Notification("Book Item",
				"Dear ? , your booking of the @ is confirmed. thanks for using our store :) ", "EN", "Email", "2",
				"2"));
		crud.notifications.add(new Notification("Cancel booking",
				"Dear ? , your booking of the @ is canceled. thanks for using our store :)", "EN", "Email", "2", "2"));
		crud.notifications.add(
				new Notification("Feedback", "Please write your feedback about our store", "EN", "Email", "0", "1"));

		// Adding the admins to the DB
		users.add(new User("Alamir", "a@gmail.com", "0123456", "123456", "admin", false, false));
		users.add(new User("Mohamed", "m@gmail.com", "0123456", "123456", "admin", false, false));
		users.add(new User("Mostafa", "ms@gmail.com", "0123456", "123456", "admin", false, false));
		users.add(new User("Tawfik", "t@gmail.com", "0123456", "123456", "admin", false, false));
		users.add(new User("Ahmed", "as@gmail.com", "0123456", "123456", "admin", false, false));
		mainMenu();
	}

	public static void mainMenu() {
		// SignUp / Login

		String choice = "";

		System.out.println("Welcome to the booking system ----------------");
		System.out.println("1. SignUp");
		System.out.println("2. Login");



		do {
			
			choice = inputMain.nextLine();
			//inputMain.nextLine();
			
			
			if (choice.equals("1")) {
				signUp();
			} else if (choice.equals("2")) {
				
				login();
			} else {
				System.out.println("Please choose 1 or 2 only!");
			}

		} while (!choice.equals("1") && !choice.equals("2"));

		
	}

	public static void signUp() {
		//Scanner signupInput = new Scanner(System.in);
		User signUpUser = new User();
		String currentEmail = "";
		System.out.println("--------------------------- SignUp -----------------------------");
		System.out.print("Enter your username: ");
		signUpUser.setUsername(inputMain.nextLine());
		System.out.print("Enter your email: ");
		signUpUser.setEmail(inputMain.nextLine());
		currentEmail = signUpUser.getEmail();
		System.out.print("Enter your phone: ");
		signUpUser.setPhone(inputMain.nextLine());
		System.out.print("Enter your password: ");
		signUpUser.setPassword(inputMain.nextLine());
		signUpUser.setRole("user");
		signUpUser.setStatus(true);
		signUpUser.setVerified(false);

		for (int i = 0; i < users.size(); i++) {
			if (signUpUser.getEmail().equalsIgnoreCase(users.get(i).getEmail())) {
				System.out.println("This user is already exists in the system.");
				login();
				break;
			}
		}

		users.add(signUpUser);
		System.out.println("Account created successfully.");
		//signupInput.close();
		// Confirmation mail
		//Scanner scanners = new Scanner(System.in);
		String verify = "";
		do {
			System.out.println(crud.notifications.get(0).getContent());

			verify = inputMain.nextLine();

			if (verify.equals("v")) {

				for (int i = 0; i < users.size(); i++) {

					if (currentEmail.equalsIgnoreCase(users.get(i).getEmail())) {

						users.get(i).setVerified(true);
						break;
					}

				}
				System.out.println("Account verified successfully.");
				userMenu();
			} else {
				System.out.println("Account not verified.");
				System.out.println("\n\n");
			}
		} while (!verify.equals("v"));

	}

	public static void login() {
		String check = "";
		//Scanner loginInput = new Scanner(System.in);

		do {

			System.out.println("--------------------------- Login -----------------------------");
			System.out.print("Enter your email: ");
			String email = inputMain.nextLine();
			//inputMain.nextLine();
			System.out.print("Enter your password: ");
			String password = inputMain.nextLine();
			//inputMain.nextLine();
			int flagy = 0;
			for (int i = 0; i < users.size(); i++) {

				if (email.equalsIgnoreCase(users.get(i).getEmail())
						&& password.equalsIgnoreCase(users.get(i).getPassword())) {
					
					flagy++;
					
					if (users.get(i).getRole().equals("user")) {
						users.get(i).setStatus(true);
						userMenu();
						break;
					} else {
						users.get(i).setStatus(true);
						adminMenu(i);
						break;
					}

				}
			}
			
			if(flagy==0) {
				do {
					//Scanner scanner = new Scanner(System.in);

					System.out.println("Enter 1 to renter - 0 to create new password");

					check = inputMain.nextLine();
					if (check.equals("0")) {
						// Forget Password

					}else {
						
						mainMenu();
						
					}
					//scanner.close();

				} while (!check.equals("0") || !check.equals("1"));
			}
			
			//loginInput.close();

		} while (check.equals("1"));

	}

	public static void userMenu() {
		//Scanner scanner = new Scanner(System.in);

		// Welcome message notification **************

		System.out.println("Select one feature: ");
		// Print the array list -> subject from the notification list

		int i;
		for (i = 0; i < crud.notifications.size(); i++) {

			System.out.println((i + 1) + ". " + crud.notifications.get(i).getSubject());

		}
		System.out.println(i + ". Logout");

		int input = inputMain.nextInt();
		input--;

		if (input == crud.notifications.size()) {

			// Logout

		} else {

			for (int j = 0; j < crud.notifications.size(); j++) {
				if (input == j) {

					// Call read from CRUD with the index(j) of the notification

				}
			}

		}

	}

	public static void adminMenu(int i) {

		System.out.println("1. Create a new notification");
		System.out.println("2. Update an existing notification");
		System.out.println("3. Delete a notification");
		System.out.println("4. Logout");
		//Scanner scanner = new Scanner(System.in);
		int input;
		do {

			input = inputMain.nextInt();
			inputMain.nextLine();
			switch (input) {
			case 1: {
				// Call create function
				crud.create(inputMain);
				mainMenu();
				break;
			}
			case 2: {
				// Call update function
				crud.update(inputMain);
				mainMenu();
				break;
			}
			case 3: {
				// Call delete function
				crud.delete(inputMain);
				mainMenu();
				break;
			}
			case 4: {
				// Logout
				users.get(i).setStatus(false);
				mainMenu();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + input);
			}

		} while (input < 1 || input > 4);
		//scanner.close();
	}

	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> users) {
		Website.users = users;
	}

}