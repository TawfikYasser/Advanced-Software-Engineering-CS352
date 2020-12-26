package com.example.NotificationManagement;

import com.example.NotificationManagement.api.NotificationTemplateController;
import com.example.NotificationManagement.dao.DBNotificationDataAccessLayer;
import com.example.NotificationManagement.dao.MemoryNotificationDataAccessLayer;
import com.example.NotificationManagement.model.NotificationTemplate;
import com.example.NotificationManagement.model.User;
import com.example.NotificationManagement.service.NotificationTemplateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication
public class NotificationManagementApplication {

    public static Scanner inputMain = new Scanner(System.in);
    public static User currentUser = new User();
    public static ArrayList<User> users;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        initDefaultData();
        mainMenu();
        SpringApplication.run(NotificationManagementApplication.class, args);
    }

    public static void initDefaultData() {

        // Adding the admins to the DB
        users = new ArrayList<User>();
        users.add(new User("Alamir", "a@gmail.com", "0123456", "123456", "admin", false, false));
        users.add(new User("Mohamed", "m@gmail.com", "0123456", "123456", "admin", false, false));
        users.add(new User("Mostafa", "ms@gmail.com", "0123456", "123456", "admin", false, false));
        users.add(new User("Tawfik", "t@gmail.com", "0123456", "123456", "admin", false, false));
        users.add(new User("Ahmed", "as@gmail.com", "0123456", "123456", "admin", false, false));

    }

    public static void mainMenu() {
        // SignUp / Login

        String choice = "";

        System.out.println("---------------- Welcome to the booking system ----------------");
        System.out.println("1. SignUp");
        System.out.println("2. Login");

        do {

            choice = inputMain.next();
            inputMain.nextLine();

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
        currentUser = signUpUser;
        System.out.println("Account created successfully.");
        // Confirmation mail
        String verify = "";
        do {
            //System.out.println(accessLayerMemory.notifications.get(0).getTemplateContent()); Get notification from database

            verify = inputMain.nextLine();

            if (verify.equals("v")) {

                for (int i = 0; i < users.size(); i++) {

                    if (currentEmail.equalsIgnoreCase(users.get(i).getEmail())) {

                        users.get(i).setVerified(true);
                        break;
                    }

                }
                System.out.println("Account verified successfully.");
                userMenu(signUpUser);
            } else {
                System.out.println("Account not verified.");

            }
        } while (!verify.equals("v"));

    }

    public static void login() {

        String check = "";

        do {

            System.out.println("--------------------------- Login -----------------------------");
            System.out.print("Enter your email: ");
            String email = inputMain.nextLine();
            System.out.print("Enter your password: ");
            String password = inputMain.nextLine();
            int flagy = 0;
            for (int i = 0; i < users.size(); i++) {

                if (email.equalsIgnoreCase(users.get(i).getEmail())
                        && password.equalsIgnoreCase(users.get(i).getPassword())) {

                    flagy++;

                    if (users.get(i).getRole().equals("user")) {
                        users.get(i).setStatus(true);
                        userMenu(users.get(i));
                        break;
                    } else {
                        users.get(i).setStatus(true);
                        adminMenu(i);
                        break;
                    }

                }
            }

            if (flagy == 0) {
                do {
                    System.out.println("Enter 1 to renter - 0 to create new password");

                    check = inputMain.next();
                    inputMain.nextLine();
                    if (check.equals("0")) {
                        // Forget Password

                        //System.out.println(accessLayerMemory.notifications.get(1).getTemplateContent()); Get notification from database
                        String newPassword = inputMain.nextLine();
                        currentUser.setPassword(newPassword);
                        System.out.println("Password saved.");
                        check = "1";

                    } else {

                        mainMenu();

                    }
                } while (!check.equals("0") || !check.equals("1"));
            }
        } while (check.equals("1"));

    }

    public static void userMenu(User user) {


        // Welcome message notification **************

        //accessLayerMemory.notifications.get(0).getTemplateContent(); Get notification from database

        String check = "";

        do {

//            System.out.println("Select one feature: ");
//            // Print the array list -> subject from the notification list
//
//            int i;
//            for (i = 3; i < accessLayerMemory.notifications.size(); i++) {
//
//                System.out.println((i - 2) + ". " + accessLayerMemory.notifications.get(i).getTemplateSubject());
//
//            }
//            System.out.println((i - 2) + ". Logout");
//
//            int input = inputMain.nextInt();
//            input = input + 2;
//
//            if (input == accessLayerMemory.notifications.size()) {
//                // Logout
//                user.setStatus(false);
//                mainMenu();
//
//            } else {
//
//                accessLayerMemory.read(input, user, inputMain);
//
//            }

            System.out.println("To choose again type 'yes'");
            check = inputMain.next();
            inputMain.nextLine();
            if (!check.equalsIgnoreCase("yes")) {
                mainMenu();
            }

        } while (check.equalsIgnoreCase("yes"));

    }

    public static void adminMenu(int i) {

        System.out.println("1. Create a new notification");
        System.out.println("2. Update an existing notification");
        System.out.println("3. Delete a notification");
        System.out.println("4. Logout");
        int input;
        do {

            input = inputMain.nextInt();
            inputMain.nextLine();
            switch (input) {
                case 1: {
                    // Call create function

                    NotificationTemplateController notificationTemplateControllerDB
                            = new NotificationTemplateController(new NotificationTemplateService(new DBNotificationDataAccessLayer()));
                    notificationTemplateControllerDB.createNotification(new NotificationTemplate(UUID.randomUUID(),
                            "Hello", "Hello World!", "Spanish", "Email"));

                    NotificationTemplateController notificationTemplateControllerMemory
                            = new NotificationTemplateController(new NotificationTemplateService(new MemoryNotificationDataAccessLayer()));
                    notificationTemplateControllerMemory.createNotification(new NotificationTemplate(UUID.randomUUID(),
                            "Hello", "Hello World!", "Arabic", "Email"));
                    NotificationTemplateController notificationTemplateControllerMemory2
                            = new NotificationTemplateController(new NotificationTemplateService(new MemoryNotificationDataAccessLayer()));
                    notificationTemplateControllerMemory2.createNotification(new NotificationTemplate(UUID.randomUUID(),
                            "Hello 2", "Hello World! 2", "Arabic 2", "Email 2"));
                    break;
                }
                case 2: {
                    // Call update function
                    List<NotificationTemplate> notificationTemplateList = new ArrayList<>();
                    NotificationTemplateController notificationTemplateController
                            = new NotificationTemplateController(new NotificationTemplateService(new DBNotificationDataAccessLayer()));
                    notificationTemplateList = notificationTemplateController.getAllNotifications();
                    for (int j = 0; j < notificationTemplateList.size(); j++) {
                        System.out.println(notificationTemplateList.get(j).getId()+" - "+notificationTemplateList.get(j).getTemplateSubject());
                    }

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose an ID from above and type it below: ");
                    String uId = scanner.next();

                    NotificationTemplateController notificationTemplateController1
                            = new NotificationTemplateController(new NotificationTemplateService(new DBNotificationDataAccessLayer()));
                    notificationTemplateController1.updateNotification(UUID.fromString(uId),new NotificationTemplate(UUID.fromString(uId),"New Subject","New Content"
                            ,"New Lang","New Type"));
                    break;
                }
                case 3: {
                    // Call delete function

                    List<NotificationTemplate> notificationTemplateList = new ArrayList<>();
                    NotificationTemplateController notificationTemplateController
                            = new NotificationTemplateController(new NotificationTemplateService(new DBNotificationDataAccessLayer()));
                    notificationTemplateList = notificationTemplateController.getAllNotifications();
                    for (int j = 0; j < notificationTemplateList.size(); j++) {
                        System.out.println(notificationTemplateList.get(j).getId()+" - "+notificationTemplateList.get(j).getTemplateSubject());
                    }

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose an ID from above and type it below: ");
                    String uId = scanner.next();

                    NotificationTemplateController notificationTemplateController1
                            = new NotificationTemplateController(new NotificationTemplateService(new DBNotificationDataAccessLayer()));
                    notificationTemplateController1.deleteNotificationById(UUID.fromString(uId));
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
    }

}
