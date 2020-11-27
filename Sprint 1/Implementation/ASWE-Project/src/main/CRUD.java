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
		System.out.println("For any other object like item, type '*'");
		System.out.print("Enter content: ");
		notification.setContent(scanner.nextLine());
		System.out.print("Enter language: ");
		notification.setLanguage(scanner.nextLine());
		System.out.print("Enter channel: ");
		notification.setChannel(scanner.nextLine());

		int flag = 0;
		for (int i = 0; i < notifications.size(); i++) {
			if (notification.getSubject().equalsIgnoreCase(notifications.get(i).getSubject())) {
				System.out.println("This notification is already exists in the system.");
				flag++;
				break;
			}
		}

		if (flag == 0) {
			notifications.add(notification);
			System.out.println("Notification created successfully.");
		}

	}

	public static void read(int index, User user, Scanner scanner) {

		String notificationTemplate = notifications.get(index).getContent();

		int inputs = Integer.valueOf(notifications.get(index).getInputs());
		int placeholders = Integer.valueOf(notifications.get(index).getPlaceholder());

		for (int i = 0; i < notificationTemplate.length(); i++) {

			if (notificationTemplate.charAt(i) == '?') {
				notificationTemplate = notificationTemplate.replace("?", user.getUsername());
				placeholders--;
				inputs--;
			} else if (notificationTemplate.charAt(i) == '$') {
				notificationTemplate = notificationTemplate.replace("$", user.getEmail());
				placeholders--;
				inputs--;
			} else if (notificationTemplate.charAt(i) == '#') {
				notificationTemplate = notificationTemplate.replace("#", user.getPhone());
				placeholders--;
				inputs--;
			} else if (notificationTemplate.charAt(i) == '*') {

				int pVar = placeholders;
				for (int j = 0; j < pVar; j++) {

					System.out.print("Enter placeholder " + (j + 1) + " : ");
					scanner.nextLine();
					String pInput = scanner.nextLine();
					notificationTemplate = notificationTemplate.replace("*", pInput);

					placeholders--;
					inputs--;

				}

			}

		}

		if (placeholders == 0 && inputs == 0) {
			System.out.println(notificationTemplate);
		} else {

			System.out.println(notificationTemplate);

			for (int j = 0; j < inputs; j++) {

				String myInput = scanner.next();
				scanner.nextLine();

			}

		}

	}

	public static void update(Scanner scanner) {

		Notification notification = new Notification();
		System.out.println("Enter the subject for the notification you want to update: ");
		String subInput = scanner.nextLine();
		int f = 0;

		for (int i = 0; i < notifications.size(); i++) {

			if (subInput.equals(notifications.get(i).getSubject())) {
				f++;
				System.out.println("Enter number of inputs for that notification: ");
				notifications.get(i).setInputs(scanner.nextLine());
				System.out.println("Enter number of placeholders for that notification: ");
				notifications.get(i).setPlaceholder(scanner.nextLine());
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
