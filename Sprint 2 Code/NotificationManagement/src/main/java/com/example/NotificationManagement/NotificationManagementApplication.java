package com.example.NotificationManagement;

import com.example.NotificationManagement.api.NotificationTemplateController;
import com.example.NotificationManagement.dao.MemoryNotificationDataAccessLayer;
import com.example.NotificationManagement.model.NotificationTemplate;
import com.example.NotificationManagement.service.NotificationTemplateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class NotificationManagementApplication {

	public static void main(String[] args) {
		System.out.println("Hello");
		NotificationTemplateController notificationTemplateController = new NotificationTemplateController(new NotificationTemplateService(new MemoryNotificationDataAccessLayer()));
		notificationTemplateController.createNotification(new NotificationTemplate(UUID.randomUUID(),
				"Feedback","Feedback 121 Content","English","SMS"));
		SpringApplication.run(NotificationManagementApplication.class, args);
	}

}
