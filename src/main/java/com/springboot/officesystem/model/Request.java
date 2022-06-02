package com.springboot.officesystem.model;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "request_sender_user")
    private User requestSender;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "request_receiver_user")
    private User requestReceiver;

    private String requestType;

    private String decision;

    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionTime;

    public Request() {
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }


    public User getRequestSender() {
        return requestSender;
    }

    public void setRequestSender(User requestSender) {
        this.requestSender = requestSender;
    }

    public User getRequestReceiver() {
        return requestReceiver;
    }

    public void setRequestReceiver(User requestReceiver) {
        this.requestReceiver = requestReceiver;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }
}
