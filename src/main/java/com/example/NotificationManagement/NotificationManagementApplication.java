package com.example.NotificationManagement;

import com.example.NotificationManagement.api.NotificationTemplateController;
import com.example.NotificationManagement.dao.DBNotificationDataAccessLayer;
import com.example.NotificationManagement.model.NotificationTemplate;
import com.example.NotificationManagement.service.NotificationTemplateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class NotificationManagementApplication {

    public static void main(String[] args){


        NotificationTemplateController notificationTemplateController=
                new NotificationTemplateController(new NotificationTemplateService(new DBNotificationDataAccessLayer()));
        notificationTemplateController.getNotificationById(UUID.randomUUID());
        SpringApplication.run(NotificationManagementApplication.class, args);
    }

}
