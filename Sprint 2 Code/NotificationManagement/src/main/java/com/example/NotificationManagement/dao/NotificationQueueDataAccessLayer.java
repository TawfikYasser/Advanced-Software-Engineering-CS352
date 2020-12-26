package com.example.NotificationManagement.dao;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.NotificationTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface NotificationQueueDataAccessLayer {


    int insertNotificationInQueue(String notificationSubject, String notificationContent,String notificationType);

    Optional<NotificationQueue> getNotificationById(int id);

    List<NotificationQueue> getAllNotifications();

}
