package com.example.schoolmanagementsystem.Attendance;

public class Data_Attendance {


    public Data_Attendance(String topic, String subject, String attendance, String date) {
        this.topic = topic;
        this.subject = subject;
        this.attendance = attendance;
        this.date = date;
    }
    String topic;

    public String getTopic() {
        return topic;
    }

    public String getSubject() {
        return subject;
    }

    public String getAttendance() {
        return attendance;
    }

    public String getDate() {
        return date;
    }

    String subject;
    String attendance;
    String date;
}
