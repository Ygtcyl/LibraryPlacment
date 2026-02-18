package com.sau.librraryplacment.dto;

public class Student {
    int Id;
    String name;
    String dprtmn;

    public Student() {
    }

    public Student(int id, String name, String dprtmn) {
        Id = id;
        this.name = name;
        this.dprtmn = dprtmn;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDprtmn() {
        return dprtmn;
    }

    public void setDprtmn(String dprtmn) {
        this.dprtmn = dprtmn;
    }

}
