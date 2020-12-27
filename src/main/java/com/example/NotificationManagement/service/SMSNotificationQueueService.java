package com.example.NotificationManagement.service;

import com.example.NotificationManagement.dao.NotificationQueueDataAccessLayer;
import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.QueueTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SMSNotificationQueueService {

    private final NotificationQueueDataAccessLayer notificationQueueDataAccessLayer;

    @Autowired
    public SMSNotificationQueueService(@Qualifier("QSMS") NotificationQueueDataAccessLayer notificationQueueDataAccessLayer) {
        this.notificationQueueDataAccessLayer = notificationQueueDataAccessLayer;
    }

    public int insertNotificationInQueue(QueueTemplate queueTemplate){
        return notificationQueueDataAccessLayer.insertNotificationInQueue(queueTemplate);
    }

    public NotificationQueue getNotificationById(int id){
        return notificationQueueDataAccessLayer.getNotificationById(id);
    }

    public List<NotificationQueue> getAllNotifications(){
        return notificationQueueDataAccessLayer.getAllNotifications();
    }
}
