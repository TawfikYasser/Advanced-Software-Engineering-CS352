import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class First_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String num = validate("pwd>1");
		// System.out.println(num);
		
		User user = new User();
		user.users.add(new User("Ahmed" ,"a@gmail.com","123456"       ,"01129348206","user" ,true));
		user.users.add(new User("kareem","k@gmail.com","1234155484956","01229348206","admin",true));
		
		for(int i=0;i<user.users.size();i++) {
			
			if(user.users.get(i).getRole().equalsIgnoreCase("admin")) {
				System.out.println("ADMIN");
			}else {
				System.out.println("USER");
			}
		}
		
		Notification notification = new Notification();
		notification.notifications.add(new Notification("Book item","Dear x","EN","SMS"));
		notification.notifications.add(new Notification("forget","Dear x","EN","SMS"));
		notification.notifications.add(new Notification("conforim","Dear x","EN","SMS"));

		
		
		for(int i =0;i<notification.notifications.size();i++) {
			
			System.out.println(notification.notifications.get(i).getSubject());
			
		}
		

		String input = "Dear username , your booking of the itemname is confirmed. thanks for using our store :) ";
		input = input.replace("username", "Ahmed");
		input = input.replace("itemname", "Book");
		// System.out.println(input);


		/*
		 * 
		 * Sign up or login sign up - new user true
		 * 
		 * 
		 * main: book item / logout
		 * 
		 * signup login
		 * 
		 * email/password forget password - email
		 * 
		 * username,email,phone,password
		 * 
		 * Verify - Not Now Verify - Not Now
		 * 
		 * 
		 */

//		ArrayList<User> users = new ArrayList<User>();
//		users.add(new User("Ahmed","a@gmail.com","123456","01129348206",true));
//		users.add(new User("kareem","k@gmail.com","1234155484956","01229348206",true));
//
//		
//		
//		for(int i=0;i<users.size();i++) {
//			System.out.println((i+1)+" Username: "+users.get(i).getUsername()+" - Email: "+users.get(i).getEmail()+" - Password: "+users.get(i).getPassword());
//		}

		/*
		 * Scanner scanner = new Scanner(System.in); String s = scanner.nextLine();
		 * 
		 * Pattern pattern = Pattern.compile("([1-5][m-r][2-4])*"); Matcher matcher =
		 * pattern.matcher(s); boolean found = matcher.find(); if(found) {
		 * 
		 * System.out.println("Pattern found: "+s);
		 * 
		 * }else { System.out.println("Pattern not found."); }
		 */

		// ***************************************
		// 1. [1-5][m-r][2-4]
		// 2. \\d[m-r]\\d
		// 3. \\d[m-r]\\d?

//		Scanner scanner = new Scanner(System.in);
//		String s,d;
//		
//		s = scanner.nextLine();
//
//		
//		
//        wordpattern("pwd>", s);

	}

	protected static boolean wordpattern(String pattern, String input) {
		Map<Character, Integer> patternItemNumbers = new HashMap<>();
		StringBuilder regularExpression = new StringBuilder();
		int groupCount = 1;

		for (char patternItem : pattern.toCharArray()) {
			Integer group = patternItemNumbers.get(patternItem);

			// first occurrence: create new fetching group
			if (group == null) {
				regularExpression.append("(.+)");
				patternItemNumbers.put(patternItem, groupCount++);
			}

			// every next occurrence: reuse group by identifier
			else {
				regularExpression.append('\\');
				regularExpression.append(group);
			}
		}

		String regexp = regularExpression.toString();
		boolean matches = Pattern.matches(regexp, input);

		System.out.println("pattern: " + pattern);
		System.out.println("regular expression: " + regexp);
		System.out.println("matches: " + matches);

		return matches;
	}

	static String validate(String pattern) {
		String input = "";
		boolean validInput = false;
		do {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				input = br.readLine();
				if (input.matches(pattern))
					validInput = true;
			} catch (Exception e) {
				System.out.println("" + e);
			}
		} while (!validInput);
		return input;
	}

}
