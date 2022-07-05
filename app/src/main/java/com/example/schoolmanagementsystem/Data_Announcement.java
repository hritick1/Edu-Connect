package com.example.schoolmanagementsystem;

public class Data_Announcement {
    public Data_Announcement(String topic, String subject, String date) {
        this.topic = topic;
        this.subject = subject;
        this.date = date;
    }

    String topic;

    public String getTopic() {
        return topic;
    }

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    String subject;
    String date;
}
