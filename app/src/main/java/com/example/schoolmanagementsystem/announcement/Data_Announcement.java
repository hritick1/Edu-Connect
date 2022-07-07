package com.example.schoolmanagementsystem.announcement;

public class Data_Announcement {
    public Data_Announcement(String topic, String subject, String date,String full) {
        this.topic = topic;
        this.subject = subject;
        this.date = date;
        this.full=full;
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

    public String getFull() {
        return full;
    }
    String subject;
    String date;
    String full;
}
