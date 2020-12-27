package com.example.NotificationManagement.api;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.QueueTemplate;
import com.example.NotificationManagement.service.EmailNotificationQueueService;
import com.example.NotificationManagement.service.SMSNotificationQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/nq/sms")
@RestController
public class SMSNotificationQueueController {
    private final SMSNotificationQueueService smsNotificationQueueService;

    @Autowired
    public SMSNotificationQueueController(@RequestBody SMSNotificationQueueService smsNotificationQueueService) {
        this.smsNotificationQueueService = smsNotificationQueueService;
    }

    @PostMapping
    public void insertNotificationInQueue(@RequestBody QueueTemplate queueTemplate) {
        smsNotificationQueueService.insertNotificationInQueue(queueTemplate);
    }

    @GetMapping(path = "{id}")
    public NotificationQueue getNotificationById(@PathVariable("id")  int id) {
        return smsNotificationQueueService.getNotificationById(id);
    }

    @GetMapping
    public List<NotificationQueue> getAllNotifications() {
        return smsNotificationQueueService.getAllNotifications();
    }


}
