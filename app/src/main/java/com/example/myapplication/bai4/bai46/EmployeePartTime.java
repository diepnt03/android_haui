package com.example.myapplication.bai4.bai46;

public class EmployeePartTime extends Employee {
    @Override
    public double tinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return "PartTime:" + super.toString() + "-luong" + tinhLuong();
    }
}