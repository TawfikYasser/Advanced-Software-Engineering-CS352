package com.example.NotificationManagement.dao;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.NotificationTemplate;
<<<<<<< HEAD
import com.example.NotificationManagement.model.QueueTemplate;
=======
<<<<<<< HEAD
import com.example.NotificationManagement.model.QueueTemplate;
=======
>>>>>>> 67e7f4bb4ec30a5f697f7cecc73c7f79e28481c1
>>>>>>> 42dbb849c686c77b0a57ee513ea16ce4e8c5e19d
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
@Repository("QSMS")
=======
<<<<<<< HEAD
@Repository("QSMS")
=======
>>>>>>> 67e7f4bb4ec30a5f697f7cecc73c7f79e28481c1
>>>>>>> 42dbb849c686c77b0a57ee513ea16ce4e8c5e19d
public class SMSNotificationQueueDataAccessLayer implements NotificationQueueDataAccessLayer{


    @Override
<<<<<<< HEAD
    public int insertNotificationInQueue(QueueTemplate queueTemplate) {
=======
<<<<<<< HEAD
    public int insertNotificationInQueue(QueueTemplate queueTemplate) {
=======
    public int insertNotificationInQueue(String notificationSubject, String notificationContent,String notificationType) {
>>>>>>> 67e7f4bb4ec30a5f697f7cecc73c7f79e28481c1
>>>>>>> 42dbb849c686c77b0a57ee513ea16ce4e8c5e19d
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
<<<<<<< HEAD
            query = "INSERT INTO sms_queue(n_subject,n_content) VALUES ("
                    +"'"+queueTemplate.getNotificationSubject()+"',"
                    +"'"+queueTemplate.getNotificationContent()+"')";
=======
<<<<<<< HEAD
            query = "INSERT INTO sms_queue(n_subject,n_content) VALUES ("
                    +"'"+queueTemplate.getNotificationSubject()+"',"
                    +"'"+queueTemplate.getNotificationContent()+"')";
=======
            if(notificationType.equalsIgnoreCase("Email")){
                query = "INSERT INTO email_queue(n_subject,n_content) VALUES ("
                        +"'"+notificationSubject+"',"
                        +"'"+notificationContent+"')";
            }else{
                query = "INSERT INTO sms_queue(n_subject,n_content) VALUES ("
                        +"'"+notificationSubject+"',"
                        +"'"+notificationContent+"')";
            }

>>>>>>> 67e7f4bb4ec30a5f697f7cecc73c7f79e28481c1
>>>>>>> 42dbb849c686c77b0a57ee513ea16ce4e8c5e19d
            int queryResult = statement.executeUpdate(query);
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 42dbb849c686c77b0a57ee513ea16ce4e8c5e19d
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
            query = "SELECT * FROM sms_queue WHERE idsms_queue = '"+id+"';";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                notificationQueue.setNotificationId(resultSet.getInt("idsms_queue"));
                notificationQueue.setNotificationSubject(resultSet.getString("n_subject"));
                notificationQueue.setNotificationContent(resultSet.getString("n_content"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return notificationQueue;
<<<<<<< HEAD
=======
=======
    public Optional<NotificationQueue> getNotificationById(int id) {
        return Optional.empty();
>>>>>>> 67e7f4bb4ec30a5f697f7cecc73c7f79e28481c1
>>>>>>> 42dbb849c686c77b0a57ee513ea16ce4e8c5e19d
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
            query = "SELECT * FROM email_queue;";
            ResultSet resultSet1 = null;
            resultSet1 = statement.executeQuery(query);
            while (resultSet1.next()){
                notificationQueueList.add(new NotificationQueue(resultSet1.getInt("idemail_queue"),
                        resultSet1.getString("n_subject"),resultSet1.getString("n_content")));
            }
>>>>>>> 67e7f4bb4ec30a5f697f7cecc73c7f79e28481c1
>>>>>>> 42dbb849c686c77b0a57ee513ea16ce4e8c5e19d
            query = "SELECT * FROM sms_queue;";
            ResultSet resultSet2 = null;
            resultSet2 = statement.executeQuery(query);
            while (resultSet2.next()){
<<<<<<< HEAD
                notificationQueueList.add(new NotificationQueue(resultSet2.getInt("idsms_queue"),
=======
<<<<<<< HEAD
                notificationQueueList.add(new NotificationQueue(resultSet2.getInt("idsms_queue"),
=======
                notificationQueueList.add(new NotificationQueue(resultSet2.getInt("idemail_queue"),
>>>>>>> 67e7f4bb4ec30a5f697f7cecc73c7f79e28481c1
>>>>>>> 42dbb849c686c77b0a57ee513ea16ce4e8c5e19d
                        resultSet2.getString("n_subject"),resultSet2.getString("n_content")));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return notificationQueueList;
    }
}
