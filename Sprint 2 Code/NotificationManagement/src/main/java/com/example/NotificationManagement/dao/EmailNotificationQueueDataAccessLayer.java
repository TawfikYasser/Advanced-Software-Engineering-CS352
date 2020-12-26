package com.example.NotificationManagement.dao;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.NotificationTemplate;
import com.example.NotificationManagement.model.QueueTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("QEmail")
public class EmailNotificationQueueDataAccessLayer implements NotificationQueueDataAccessLayer{

    @Override
    public int insertNotificationInQueue(QueueTemplate queueTemplate) {
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
            query = "INSERT INTO email_queue(n_subject,n_content) VALUES ("
                    +"'"+queueTemplate.getNotificationSubject()+"',"
                    +"'"+queueTemplate.getNotificationContent()+"')";

            int queryResult = statement.executeUpdate(query);
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public NotificationQueue getNotificationById(int id) {
        NotificationQueue notificationQueue = new NotificationQueue();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/notification_db?useSSL=false";
            String userDB = "root";
            String passwordDB = "troot";
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            String query = "";
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            statement = connection.createStatement();
            query = "SELECT * FROM email_queue WHERE idemail_queue = '"+id+"';";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                notificationQueue.setNotificationId(resultSet.getInt("idemail_queue"));
                notificationQueue.setNotificationSubject(resultSet.getString("n_subject"));
                notificationQueue.setNotificationContent(resultSet.getString("n_content"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return notificationQueue;
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
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return notificationQueueList;
    }
}
