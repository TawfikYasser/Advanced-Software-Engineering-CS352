package com.example.NotificationManagement.dao;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.NotificationTemplate;
<<<<<<< HEAD
import com.example.NotificationManagement.model.QueueTemplate;
=======
>>>>>>> 67e7f4bb4ec30a5f697f7cecc73c7f79e28481c1

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface NotificationQueueDataAccessLayer {


<<<<<<< HEAD
    int insertNotificationInQueue(QueueTemplate queueTemplate);

    NotificationQueue getNotificationById(int id);
=======
    int insertNotificationInQueue(String notificationSubject, String notificationContent,String notificationType);

    Optional<NotificationQueue> getNotificationById(int id);
>>>>>>> 67e7f4bb4ec30a5f697f7cecc73c7f79e28481c1

    List<NotificationQueue> getAllNotifications();

}
