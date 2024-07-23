package com.example.myapplication.bai4.bai48;

public abstract class Employee {
    private String id;
    private String name;
    public abstract double tinhLuong();
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.id+" - "+this.name;
    }
}
