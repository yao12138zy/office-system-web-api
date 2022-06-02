package com.springboot.officesystem.model;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notification_id")
    private Long notificationId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "notification_sender_user")
    private User notificationSender;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "notification_receiver_user")
    private User notificationReceiver;

    private Boolean readed;

    @Temporal(TemporalType.TIMESTAMP)
    private Date notificationTime;

    private String contents;

    public Notification() {
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public User getNotificationSender() {
        return notificationSender;
    }

    public void setNotificationSender(User notificationSender) {
        this.notificationSender = notificationSender;
    }

    public User getNotificationReceiver() {
        return notificationReceiver;
    }

    public void setNotificationReceiver(User notificationReceiver) {
        this.notificationReceiver = notificationReceiver;
    }

    public Boolean getRead() {
        return readed;
    }


    public void setRead(Boolean read) {
        this.readed = read;
    }

    public Date getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(Date notificationTime) {
        this.notificationTime = notificationTime;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

}
