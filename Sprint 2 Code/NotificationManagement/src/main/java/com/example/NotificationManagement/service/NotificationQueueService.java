package com.example.NotificationManagement.service;

import com.example.NotificationManagement.dao.NotificationQueueDataAccessLayer;
import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.NotificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

public class NotificationQueueService {

    private final NotificationQueueDataAccessLayer notificationQueueDataAccessLayer;

    public NotificationQueueService( NotificationQueueDataAccessLayer notificationQueueDataAccessLayer) {
        this.notificationQueueDataAccessLayer = notificationQueueDataAccessLayer;
    }

    public int insertNotificationInQueue(String notificationSubject, String notificationContent, String notificationType){
        return notificationQueueDataAccessLayer.insertNotificationInQueue(notificationSubject, notificationContent, notificationType);
    }

    public Optional<NotificationQueue> getNotificationById(int id){
        return notificationQueueDataAccessLayer.getNotificationById(id);
    }

    public List<NotificationQueue> getAllNotifications(){
        return notificationQueueDataAccessLayer.getAllNotifications();
    }

}
