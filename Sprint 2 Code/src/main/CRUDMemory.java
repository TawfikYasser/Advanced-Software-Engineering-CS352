package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CRUDMemory implements CRUD{

	public static ArrayList<NotificationTemplate> notifications;

	public CRUDMemory() {

		
		notifications = new ArrayList<NotificationTemplate>();

	}
	
	@Override
	public void create(Scanner scanner) {


		// TODO Auto-generated method stub
		
		
		NotificationTemplate notificationTemplate = new NotificationTemplate();
		
		System.out.println("Enter template language: ");
		String tempLanguage = scanner.nextLine();
		
		try {
			notificationTemplate.setTemplateLanguage(LanguageEnum.valueOf(tempLanguage));

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Choose from ENGLISH and ARABIC Only");
		}
			
		System.out.println("Enter template type: ");
		String tempType = scanner.nextLine();
		
		try {
			notificationTemplate.setTemplateType(TypeEnum.valueOf(tempType));

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Choose from EMAIL and SMS Only");
		}
			
		
		System.out.print("Enter template subject: ");
		notificationTemplate.setTemplateSubject(scanner.nextLine());
		System.out.println("Enter number of inputs for that notification: ");
		notificationTemplate.setTemplateInputs(scanner.nextLine());
		System.out.println("Enter number of placeholders for that notification: ");
		notificationTemplate.setTemplatePlaceholders(scanner.nextLine());
		
		
		System.out.println("Hint: In content:");
		System.out.println("-------------------");
		System.out.println("username: &");
		System.out.println("email: $");
		System.out.println("phone: #");
		System.out.println("For any other object like item, type '*'");
		System.out.print("Enter template content: ");
		notificationTemplate.setTemplateContent(scanner.nextLine());
		
		int flag = 0;
		for (int i = 0; i < notifications.size(); i++) {
			if (notificationTemplate.getTemplateSubject().equalsIgnoreCase(notifications.get(i).getTemplateSubject())) {
				System.out.println("This notification is already exists in the system.");
				flag++;
				break;
			}
		}

		if (flag == 0) {
			notifications.add(notificationTemplate);
			System.out.println("Notification created successfully.");
		}
	
	}

	@Override
	public void read(int index, User user, Scanner scanner) {

		// TODO Auto-generated method stub
		
		

		String notificationTemplate = notifications.get(index).getTemplateContent();

		int inputs = Integer.valueOf(notifications.get(index).getTemplateInputs());
		int placeholders = Integer.valueOf(notifications.get(index).getTemplatePlaceholders());

		for (int i = 0; i < notificationTemplate.length(); i++) {

			if (notificationTemplate.charAt(i) == '&') {
				notificationTemplate = notificationTemplate.replace("&", user.getUsername());
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
					
					String pInput = scanner.next();
					scanner.nextLine();
					notificationTemplate = notificationTemplate.replaceFirst("(?:\\*)+", pInput);

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

	@Override
	public void update(Scanner scanner) {
		// TODO Auto-generated method stub
		
		
		NotificationTemplate notificationTemplate = new NotificationTemplate();
		System.out.println("Enter the subject for the notification you want to update: ");
		String subInput = scanner.nextLine();
		int f = 0;

		for (int i = 0; i < notifications.size(); i++) {

			if (subInput.equals(notifications.get(i).getTemplateSubject())) {
				f++;
				System.out.println("Enter number of inputs for that notification: ");
				notifications.get(i).setTemplateInputs(scanner.nextLine());
				System.out.println("Enter number of placeholders for that notification: ");
				notifications.get(i).setTemplatePlaceholders(scanner.nextLine());
				System.out.println("Hint: In content:");
				System.out.println("-------------------");
				System.out.println("username: ?");
				System.out.println("email: $");
				System.out.println("phone: #");
				System.out.println("For any other object like item, type '@1' or '@2' and so on");
				System.out.print("Enter content: ");
				notifications.get(i).setTemplateContent(scanner.nextLine());

				break;
			}

		}

		if (f == 0) {
			System.out.println("Notification does not found.");
		}

		
	}

	@Override
	public void delete(Scanner scanner) {


		// TODO Auto-generated method stub
		
		
		String input = "";
		System.out.print("Enter the notification subject to delete: ");
		input = scanner.nextLine();

		int f = 0;
		for (int i = 0; i < notifications.size(); i++) {
			if (notifications.get(i).getTemplateSubject().equalsIgnoreCase(input)) {
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

}
