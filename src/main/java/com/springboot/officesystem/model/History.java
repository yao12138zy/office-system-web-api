package com.springboot.officesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;



@Entity
@Table(name="histories")

public class History {

    @EmbeddedId
    private HistoryPK historyPK;

    @ManyToOne
    @JsonIgnore
    @MapsId("historyUserId")
    @JoinColumn(name = "history_user_id")
    private User user;

    @Temporal(TemporalType.TIME)
    @Column(name="login_time")
    private Date loginTime;

    @Temporal(TemporalType.TIME)
    @Column(name="logout_time")
    private Date logoutTime;

    public History() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HistoryPK getHistoryPK() {
        return historyPK;
    }

    public void setHistoryPK(HistoryPK historyPK) {
        this.historyPK = historyPK;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }
}

