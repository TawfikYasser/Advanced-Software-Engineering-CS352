package main;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {

	public static ArrayList<Notification> notifications;

	public CRUD() {
		notifications = new ArrayList<Notification>();
	}

	public static void create(Scanner scanner) {

		Notification notification = new Notification();
		//Scanner scanner = new Scanner(System.in);
		System.out.print("Enter subject: ");
		notification.setSubject(scanner.nextLine());
		System.out.println("Enter number of inputs for that notification: ");
		notification.setInputs(scanner.nextLine());
		System.out.println("Enter number of placeholders for that notification: ");
		notification.setPlaceholder(scanner.nextLine());

		System.out.println("Hint: In content:");
		System.out.println("-------------------");
		System.out.println("username: ?");
		System.out.println("email: $");
		System.out.println("phone: #");
		System.out.println("For any other object like item, type '@1' or '@2' and so on");
		System.out.print("Enter content: ");
		notification.setContent(scanner.nextLine());
		System.out.print("Enter language: ");
		notification.setLanguage(scanner.nextLine());
		System.out.print("Enter channel: ");
		notification.setChannel(scanner.nextLine());

		int flag =0;
		for (int i = 0; i < notifications.size(); i++) {
			if (notification.getSubject().equalsIgnoreCase(notifications.get(i).getSubject())) {
				System.out.println("This notification is already exists in the system.");
				flag++;
				break;
			}
		}

		if(flag==0) {
			notifications.add(notification);
			System.out.println("Notification created successfully.");
		}

		//scanner.close();

	}

	public static void read() {

	}

	public static void update(Scanner scanner) {

		Notification notification = new Notification();
		//Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the subject for the notification you want to update: ");
		String subInput = scanner.nextLine();
		int f = 0;

		for (int i = 0; i < notifications.size(); i++) {

			if (notification.getSubject().equalsIgnoreCase(notifications.get(i).getSubject())) {
				f++;

				System.out.println("Hint: In content:");
				System.out.println("-------------------");
				System.out.println("username: ?");
				System.out.println("email: $");
				System.out.println("phone: #");
				System.out.println("For any other object like item, type '@1' or '@2' and so on");
				System.out.print("Enter content: ");
				notifications.get(i).setContent(scanner.nextLine());

				break;
			}

		}

		if (f == 0) {
			System.out.println("Notification does not found.");
		}

	}

	public static void delete(Scanner scanner) {

		//Scanner scanner = new Scanner(System.in);
		String input = "";
		System.out.print("Enter the notification subject to delete: ");
		input = scanner.nextLine();

		int f = 0;
		for (int i = 0; i < notifications.size(); i++) {
			if (notifications.get(i).getSubject().equalsIgnoreCase(input)) {
				notifications.remove(i);
				f++;
				System.out.println("Notification deleted successfully.");
				break;
			}
		}

		if (f == 0) {
			System.out.println("Notification does not found.");
		}

	}

	public ArrayList<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(ArrayList<Notification> notifications) {
		this.notifications = notifications;
	}

}
