package com.example.schoolmanagementsystem.Results;

public class Data_Results {


    public Data_Results(String subject, String grade, String date, String marks) {
        this.subject = subject;
        this.grade = grade;
        this.date = date;
        this.marks = marks;
    }
    String subject;

    public String getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }

    public String getDate() {
        return date;
    }

    public String getMarks() {
        return marks;
    }

    String grade;
    String date;
    String marks;
}
