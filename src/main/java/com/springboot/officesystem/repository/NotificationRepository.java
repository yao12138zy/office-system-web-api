package com.springboot.officesystem.repository;

import com.springboot.officesystem.model.Notification;
import com.springboot.officesystem.model.Request;
import org.aspectj.weaver.ast.Not;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE n.notificationReceiver.userId = :rid")
    public List<Notification> getNotificationByReceiver(@Param("rid") Long rid);

    @Query("SELECT n FROM Notification n WHERE n.notificationSender.userId = :sid")
    public List<Notification> getNotificationBySender(@Param("sid") Long sid);


}
