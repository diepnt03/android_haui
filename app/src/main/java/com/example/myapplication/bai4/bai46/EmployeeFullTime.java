package com.example.myapplication.bai4.bai46;

public class EmployeeFullTime extends Employee {
    @Override
    public String toString() {
        return "FullTime:" + super.toString() + "-" + tinhLuong();
    }

    @Override
    public double tinhLuong() {
        return 500;
    }
}