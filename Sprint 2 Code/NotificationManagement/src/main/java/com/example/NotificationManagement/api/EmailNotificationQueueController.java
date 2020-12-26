package com.example.NotificationManagement.api;

import com.example.NotificationManagement.model.NotificationQueue;
import com.example.NotificationManagement.model.QueueTemplate;
import com.example.NotificationManagement.service.EmailNotificationQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/nq/email")
@RestController
public class EmailNotificationQueueController {

    private final EmailNotificationQueueService emailNotificationQueueService;

    @Autowired
    public EmailNotificationQueueController(@RequestBody EmailNotificationQueueService emailNotificationQueueService) {
        this.emailNotificationQueueService = emailNotificationQueueService;
    }

    @PostMapping
    public void insertNotificationInQueue(@RequestBody QueueTemplate queueTemplate) {
        emailNotificationQueueService.insertNotificationInQueue(queueTemplate);
    }

    @GetMapping(path = "{id}")
    public NotificationQueue getNotificationById(@PathVariable("id")  int id) {
        return emailNotificationQueueService.getNotificationById(id);
    }

    @GetMapping
    public List<NotificationQueue> getAllNotifications() {
        return emailNotificationQueueService.getAllNotifications();
    }


}
