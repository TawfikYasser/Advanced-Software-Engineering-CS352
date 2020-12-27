package com.example.NotificationManagement.dao;

import com.example.NotificationManagement.model.NotificationTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationDataAccessLayer {

    int createNotification(UUID id, NotificationTemplate notificationTemplate);

    default int createNotification(NotificationTemplate notificationTemplate){
        UUID id = UUID.randomUUID();
        return createNotification(id,notificationTemplate);
    }

    List<NotificationTemplate> selectAllNotifications();

    Optional<NotificationTemplate> selectNotificationById(UUID id);

    int deleteNotificationById(UUID id);

    int updateNotificationById(UUID id, NotificationTemplate notificationTemplate);

    NotificationTemplate getNotificationById(UUID id);
}
