package com.example.NotificationManagement.dao;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.NotificationTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("DB")
public class DBNotificationDataAccessLayer implements NotificationDataAccessLayer {


    @Override
    public int createNotification(UUID id, NotificationTemplate notificationTemplate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/notification_db?useSSL=false";
            String userDB = "root";
            String passwordDB = "troot";
            Connection connection = null;
            Statement statement = null;
            String query = "";
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            statement = connection.createStatement();
            query = "INSERT INTO notification(Notification_Id,Notification_Subject,Notification_Content," +
                    "Notification_Language,Notification_Type) VALUES ("
                    + "'" + id + "',"
                    + "'" + notificationTemplate.getTemplateSubject() + "',"
                    + "'" + notificationTemplate.getTemplateContent() + "',"
                    + "'" + notificationTemplate.getTemplateLanguage() + "',"
                    + "'" + notificationTemplate.getTemplateType() + "')";
            int queryResult = statement.executeUpdate(query);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<NotificationTemplate> selectAllNotifications() {
        ResultSet resultSet = null;
        List<NotificationTemplate> notificationTemplateList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/notification_db?useSSL=false";
            String userDB = "root";
            String passwordDB = "troot";
            Connection connection = null;
            Statement statement = null;
            String query = "";
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            statement = connection.createStatement();
            query = "SELECT * FROM notification;";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                notificationTemplateList.add(new NotificationTemplate(UUID.fromString(resultSet.getString("Notification_Id")),
                        resultSet.getString("Notification_Subject"), resultSet.getString("Notification_Content"),
                        resultSet.getString("Notification_Language"), resultSet.getString("Notification_Type")));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notificationTemplateList;
    }

    @Override
    public Optional<NotificationTemplate> selectNotificationById(UUID id) {
        return Optional.empty();
    }

    @Override
    public NotificationTemplate getNotificationById(UUID id) {
        NotificationTemplate notificationTemplate = new NotificationTemplate();
        try {
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
            query = "SELECT * FROM notification WHERE Notification_Id = '" + id + "';";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                notificationTemplate.setId(id);
                notificationTemplate.setTemplateSubject(resultSet.getString("Notification_Subject"));
                notificationTemplate.setTemplateContent(resultSet.getString("Notification_Content"));
                notificationTemplate.setTemplateLanguage(resultSet.getString("Notification_Language"));
                notificationTemplate.setTemplateType(resultSet.getString("Notification_Type"));

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notificationTemplate;
    }

    @Override
    public int deleteNotificationById(UUID id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/notification_db?useSSL=false";
            String userDB = "root";
            String passwordDB = "troot";
            Connection connection = null;
            Statement statement = null;
            String query = "";
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            statement = connection.createStatement();
            query = "DELETE FROM notification WHERE ( Notification_Id = '" + String.valueOf(id) + "');";
            int queryResult = statement.executeUpdate(query);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int updateNotificationById(UUID id, NotificationTemplate notificationTemplate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/notification_db?useSSL=false";
            String userDB = "root";
            String passwordDB = "troot";
            Connection connection = null;
            Statement statement = null;
            String query = "";
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            statement = connection.createStatement();
            query = "UPDATE notification SET Notification_Subject = '"
                    + notificationTemplate.getTemplateSubject() + "', Notification_Content = '"
                    + notificationTemplate.getTemplateContent() + "', Notification_Language = '"
                    + notificationTemplate.getTemplateLanguage() + "', Notification_Type = '"
                    + notificationTemplate.getTemplateType() +
                    "' WHERE ( Notification_Id = '" + String.valueOf(id) + "');";
            int queryResult = statement.executeUpdate(query);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
