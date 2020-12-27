package com.example.NotificationManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueueTemplate {

    String notificationSubject,notificationContent,notificationType;

    public QueueTemplate(@JsonProperty("notificationSubject") String notificationSubject,
                         @JsonProperty("notificationContent") String notificationContent,
                         @JsonProperty("notificationType") String notificationType) {
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
