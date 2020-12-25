package com.example.NotificationManagement.dao;

import com.example.NotificationManagement.model.NotificationTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MemoryDB")
public class MemoryNotificationDataAccessLayer implements NotificationDataAccessLayer{


    private static List<NotificationTemplate> notificationTemplates = new ArrayList<>();

    @Override
    public int createNotification(UUID id, NotificationTemplate notificationTemplate) {
        notificationTemplates.add(new NotificationTemplate(id,notificationTemplate.getTemplateSubject(),
                notificationTemplate.getTemplateContent(),notificationTemplate.getTemplateLanguage()
                ,notificationTemplate.getTemplateType()));
        return 1;
    }

    @Override
    public List<NotificationTemplate> selectAllNotifications() {
        return notificationTemplates;
    }

    @Override
    public Optional<NotificationTemplate> selectNotificationById(UUID id) {
        return notificationTemplates.stream()
                .filter(notificationTemplate -> notificationTemplate.getId().equals(id))
                .findFirst();
    }


    @Override
    public int deleteNotificationById(UUID id) {
        Optional<NotificationTemplate> notificationTemplateMaybe = selectNotificationById(id);
        if(notificationTemplateMaybe.isEmpty()){
            return 0;
        }
        notificationTemplates.remove(notificationTemplateMaybe.get());
        return 1;
    }

    @Override
    public int updateNotificationById(UUID id, NotificationTemplate notificationTemplateUpdate) {

        return selectNotificationById(id)
                .map(notificationTemplate -> {
                    int indexOfNotificationToUpdate = notificationTemplates.indexOf(notificationTemplate);
                    if(indexOfNotificationToUpdate >= 0){
                        notificationTemplates.set(indexOfNotificationToUpdate,new NotificationTemplate(id,
                        notificationTemplateUpdate.getTemplateSubject(),notificationTemplateUpdate.getTemplateContent(),
                        notificationTemplateUpdate.getTemplateLanguage(),notificationTemplateUpdate.getTemplateType()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
