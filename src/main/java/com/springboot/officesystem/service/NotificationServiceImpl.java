package com.springboot.officesystem.service;

import com.springboot.officesystem.model.Notification;
import com.springboot.officesystem.model.User;
import com.springboot.officesystem.repository.NotificationRepository;
import com.springboot.officesystem.repository.UserRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Notification> getNotificationByReceiver(Long id) {
        return notificationRepository.getNotificationByReceiver(id);
    }

    @Override
    public List<Notification> getNotificationBySender(Long id) {
        return notificationRepository.getNotificationBySender(id);
    }

    @Override
    public List<Notification> sendNotificationsToAllUsers(Long senderId, Date sendTime, String contents) {
        List<User> users = userRepository.getUserAccounts();
        List<Notification> notifications = new ArrayList<Notification>();
        User sender = userRepository.findById(senderId).orElse(null);
        if (sender == null) { return new ArrayList<Notification>();}
        for (User user : users) {
            Notification newNoti = new Notification();
            newNoti.setNotificationSender(sender);
            newNoti.setContents(contents);
            newNoti.setRead(false);
            newNoti.setNotificationTime(sendTime);
            newNoti.setNotificationReceiver(user);
            notificationRepository.save(newNoti);
            notifications.add(newNoti);
        }
        return notifications;
    }

    @Override
    public Notification sendNotification(Long senderId, Long receiverId, Date sendTime, String contents) {
        User sender = userRepository.findById(senderId).orElse(null);
        User receiver = userRepository.findById(receiverId).orElse(null);
        if (sender == null || receiver == null) { return null; }
        Notification noti = new Notification();
        noti.setNotificationReceiver(receiver);
        noti.setNotificationSender(sender);
        noti.setRead(false);
        noti.setContents(contents);
        noti.setNotificationTime(sendTime);
        notificationRepository.save(noti);
        return noti;
    }

    @Override
    public Notification readNotification(Long notificationId) {
        Notification noti = notificationRepository.findById(notificationId).orElse(null);
        if (noti == null) { return null; }
        noti.setRead(true);
        notificationRepository.save(noti);
        return noti;
    }



}
