package com.springboot.officesystem.model;

import net.minidev.json.annotate.JsonIgnore;
import org.aspectj.weaver.ast.Not;
import org.hibernate.annotations.Immutable;

import javax.management.ConstructorParameters;
import javax.management.NotificationFilter;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "user_id",updatable = false)
    private Long userId;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(updatable = false,nullable = false)
    private Boolean accountType;  // 1 for manager, 0 for worker
    private String lastname;
    private String firstname;
    private String position;

    private String phoneNum;
    private boolean status;

    @OneToMany(mappedBy = "requestSender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Request> sentRequests = new HashSet<>();

    @OneToMany(mappedBy = "requestReceiver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Request> receivedRequests = new HashSet<>();

    @OneToMany(mappedBy = "notificationSender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Notification> sentNotifications = new HashSet<>();

    @OneToMany(mappedBy = "notificationReceiver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Notification> receivedNotifications = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<History> loginHistories = new HashSet<>();

    public User() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAccountType() {
        return accountType;
    }

    public void setAccountType(Boolean accountType) {
        this.accountType = accountType;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Request> getSentRequests() {
        return sentRequests;
    }

    public void setSentRequests(Set<Request> sentRequests) {
        this.sentRequests = sentRequests;
    }

    public Set<Request> getReceivedRequests() {
        return receivedRequests;
    }

    public void setReceivedRequests(Set<Request> receivedRequests) {
        this.receivedRequests = receivedRequests;
    }

    public Set<Notification> getSentNotifications() {
        return sentNotifications;
    }

    public void setSentNotifications(Set<Notification> sentNotifications) {
        this.sentNotifications = sentNotifications;
    }

    public Set<Notification> getReceivedNotifications() {
        return receivedNotifications;
    }

    public void setReceivedNotifications(Set<Notification> receivedNotifications) {
        this.receivedNotifications = receivedNotifications;
    }

    public Set<History> getLoginHistories() {
        return loginHistories;
    }

    public void setLoginHistories(Set<History> loginHistories) {
        this.loginHistories = loginHistories;
    }

}
