package com.example.schoolmanagementsystem.Admin;

public class admin_data {
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getMob() {
        return mob;
    }

    public String getId() {
        return id;
    }

    String name;
    String age;

    public admin_data(String name, String age, String mob, String id) {
        this.name = name;
        this.age = age;
        this.mob = mob;
        this.id = id;
    }

    String mob;
    String id;
}
