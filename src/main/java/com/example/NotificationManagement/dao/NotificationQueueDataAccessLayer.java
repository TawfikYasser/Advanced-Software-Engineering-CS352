package com.example.NotificationManagement.dao;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.NotificationTemplate;
import com.example.NotificationManagement.model.QueueTemplate;

import java.util.List;


public interface NotificationQueueDataAccessLayer {


    int insertNotificationInQueue(QueueTemplate queueTemplate);

    NotificationQueue getNotificationById(int id);

    List<NotificationQueue> getAllNotifications();

}
