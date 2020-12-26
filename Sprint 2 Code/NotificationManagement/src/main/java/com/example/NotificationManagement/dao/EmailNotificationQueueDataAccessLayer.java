package com.example.NotificationManagement.dao;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.NotificationTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class EmailNotificationQueueDataAccessLayer implements NotificationQueueDataAccessLayer{

    @Override
    public int insertNotificationInQueue(String notificationSubject, String notificationContent, String notificationType) {
        return 0;
    }

    @Override
    public Optional<NotificationQueue> getNotificationById(int id) {
        return Optional.empty();
    }

    @Override
    public List<NotificationQueue> getAllNotifications() {
        return null;
    }
}
