package com.example.NotificationManagement.api;

import com.example.NotificationManagement.model.NotificationTemplate;
import com.example.NotificationManagement.service.NotificationTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/nt")
@RestController
public class NotificationTemplateController {
    private final NotificationTemplateService notificationTemplateService;

    @Autowired
    public NotificationTemplateController(@RequestBody NotificationTemplateService notificationTemplateService) {
        this.notificationTemplateService = notificationTemplateService;
    }

    @PostMapping
    public void createNotification(@RequestBody NotificationTemplate notificationTemplate) {
        notificationTemplateService.createNotification(notificationTemplate);
    }

    @GetMapping
    public List<NotificationTemplate> getAllNotifications() {
        return notificationTemplateService.getAllNotifications();
    }

    public NotificationTemplate selectNotificationById(UUID id) {
        return notificationTemplateService.selectNotificationById(id).orElse(null);
    }

    @GetMapping(path = "{id}")
    public NotificationTemplate getNotificationById(@PathVariable("id") UUID id) {
        return notificationTemplateService.getNotificationById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteNotificationById(@PathVariable("id") UUID id) {
        notificationTemplateService.deleteNotification(id);
    }


    @PutMapping(path = "{id}")
    public void updateNotification(@PathVariable("id") UUID id, @RequestBody NotificationTemplate notificationTemplateToUpdate) {
        notificationTemplateService.updateNotification(id, notificationTemplateToUpdate);
    }


}
