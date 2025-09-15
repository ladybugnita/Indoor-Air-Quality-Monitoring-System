package com.IAQMS.IAQMS.Model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "UserFeedback")
public class FeedbackData {

    //primary key annotation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;
    private String phone;
    private String email;
    private String Message;

    private LocalDateTime feedbackTime;

    @PrePersist
    protected void onCreate() {
        this.feedbackTime = LocalDateTime.now(); // automatically set when saving
    }

    public LocalDateTime getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(LocalDateTime feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }
}
