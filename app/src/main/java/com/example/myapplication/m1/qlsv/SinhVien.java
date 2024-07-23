package com.example.myapplication.m1.qlsv;

public class SinhVien {
    String hoTen;
    String queQuan;
    String bangCap;
    String soThich;

    public SinhVien(String hoTen, String queQuan, String bangCap, String soThich) {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.bangCap = bangCap;
        this.soThich = soThich;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getBangCap() {
        return bangCap;
    }

    public void setBangCap(String bangCap) {
        this.bangCap = bangCap;
    }

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "hoTen='" + hoTen + '\'' +
                ", queQuan='" + queQuan + '\'' +
                ", bangCap='" + bangCap + '\'' +
                ", soThich='" + soThich + '\'' +
                '}';
    }
}
