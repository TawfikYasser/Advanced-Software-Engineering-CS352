package com.example.NotificationManagement.api;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.NotificationTemplate;
import com.example.NotificationManagement.service.NotificationQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class NotificationQueueController {

    private final NotificationQueueService notificationQueueService;

    public NotificationQueueController( NotificationQueueService notificationQueueService) {
        this.notificationQueueService = notificationQueueService;
    }

    public void insertNotificationInQueue( String notificationSubject, String notificationContent,String notificationType) {
        notificationQueueService.insertNotificationInQueue(notificationSubject,notificationContent, notificationType);
    }


    public NotificationQueue getNotificationById( int id) {
        return notificationQueueService.getNotificationById(id).orElse(null);
    }


    public List<NotificationQueue> getAllNotifications() {
        return notificationQueueService.getAllNotifications();
    }


}
