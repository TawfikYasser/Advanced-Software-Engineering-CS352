package com.example.NotificationManagement.dao;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.NotificationTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SMSNotificationQueueDataAccessLayer implements NotificationQueueDataAccessLayer{


    @Override
    public int insertNotificationInQueue(String notificationSubject, String notificationContent,String notificationType) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/notification_db?useSSL=false";
            String userDB = "root";
            String passwordDB = "troot";
            Connection connection = null;
            Statement statement = null;
            String query = "";
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            statement = connection.createStatement();
            if(notificationType.equalsIgnoreCase("Email")){
                query = "INSERT INTO email_queue(n_subject,n_content) VALUES ("
                        +"'"+notificationSubject+"',"
                        +"'"+notificationContent+"')";
            }else{
                query = "INSERT INTO sms_queue(n_subject,n_content) VALUES ("
                        +"'"+notificationSubject+"',"
                        +"'"+notificationContent+"')";
            }

            int queryResult = statement.executeUpdate(query);
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public Optional<NotificationQueue> getNotificationById(int id) {
        return Optional.empty();
    }

    @Override
    public List<NotificationQueue> getAllNotifications() {
        List<NotificationQueue> notificationQueueList = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/notification_db?useSSL=false";
            String userDB = "root";
            String passwordDB = "troot";
            Connection connection = null;
            Statement statement = null;
            String query = "";
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            statement = connection.createStatement();
            query = "SELECT * FROM email_queue;";
            ResultSet resultSet1 = null;
            resultSet1 = statement.executeQuery(query);
            while (resultSet1.next()){
                notificationQueueList.add(new NotificationQueue(resultSet1.getInt("idemail_queue"),
                        resultSet1.getString("n_subject"),resultSet1.getString("n_content")));
            }
            query = "SELECT * FROM sms_queue;";
            ResultSet resultSet2 = null;
            resultSet2 = statement.executeQuery(query);
            while (resultSet2.next()){
                notificationQueueList.add(new NotificationQueue(resultSet2.getInt("idemail_queue"),
                        resultSet2.getString("n_subject"),resultSet2.getString("n_content")));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return notificationQueueList;
    }
}
