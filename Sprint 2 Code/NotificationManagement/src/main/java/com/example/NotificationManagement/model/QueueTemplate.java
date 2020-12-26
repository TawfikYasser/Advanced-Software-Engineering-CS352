package com.example.NotificationManagement.model;

public class QueueTemplate {

    String notificationSubject,notificationContent,notificationType;

    public QueueTemplate(String notificationSubject, String notificationContent, String notificationType) {
        this.notificationSubject = notificationSubject;
        this.notificationContent = notificationContent;
        this.notificationType = notificationType;
    }

    public QueueTemplate() {
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

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
