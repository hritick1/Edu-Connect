package com.example.schoolmanagementsystem.admin;

public class ExamData {
    String ExamName;
    String platform;
    String date_time;
    String type;


    public String getExamName() {
        return ExamName;
    }

    public String getPlatform() {
        return platform;
    }

    public String getDate_time() {
        return date_time;
    }

    public String getType() {return type;}

    public ExamData(String examName, String platform, String type, String date_time) {
        ExamName = examName;
        this.platform = platform;
        this.date_time = date_time;
        this.type = type;
    }

}
