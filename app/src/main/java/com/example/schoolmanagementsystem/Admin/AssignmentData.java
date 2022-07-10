package com.example.schoolmanagementsystem.Admin;

public class AssignmentData {
    String assignment;
    String subject;



    public String getAssignment() {
        return assignment;
    }

    public String getSubject() {
        return subject;
    }

    public AssignmentData(String assignment, String subject) {
        this.assignment = assignment;
        this.subject = subject;

    }
}
