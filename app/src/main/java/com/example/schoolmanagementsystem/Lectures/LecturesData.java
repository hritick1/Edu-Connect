package com.example.schoolmanagementsystem.Lectures;

public class LecturesData {
    String time;
    String sub;
    String room;
    public String getTime() {return time;}

    public String getSubject() {
        return sub;
    }

    public String getRoom() {
        return room;
    }



    public LecturesData(String time, String sub, String room) {
        this.time = time;
        this.sub = sub;
        this.room = room;
    }


}
