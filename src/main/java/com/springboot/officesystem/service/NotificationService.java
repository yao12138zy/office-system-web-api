package com.springboot.officesystem.service;

import com.springboot.officesystem.model.Notification;
import org.aspectj.weaver.ast.Not;

import java.util.Date;
import java.util.List;

public interface NotificationService {

    public List<Notification> getNotificationByReceiver(Long id);

    public List<Notification> getNotificationBySender(Long id);

    public List<Notification> sendNotificationsToAllUsers(Long senderId, Date sendTime, String contents);

    public Notification sendNotification(Long senderId, Long receiverId, Date sendTime, String contents);

    public Notification readNotification(Long notificationId);



}
