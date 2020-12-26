package com.example.NotificationManagement.model;

public class NotificationQueue {

    int notificationId;
    String notificationSubject, notificationContent;

    public NotificationQueue(int notificationId, String notificationSubject, String notificationContent) {
        this.notificationId = notificationId;
        this.notificationSubject = notificationSubject;
        this.notificationContent = notificationContent;
    }


    public NotificationQueue() {
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationSubject() {
        return notificationSubject;
    }

    public void setNotificationSubject(String notificationSubject) {
        this.notificationSubject = notificationSubject;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }
}
