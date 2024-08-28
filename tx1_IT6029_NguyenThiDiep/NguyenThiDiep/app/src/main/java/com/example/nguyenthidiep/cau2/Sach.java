package com.example.nguyenthidiep.cau2;

public class Sach {
    String tenSach;
    String soLuong;

    public Sach(String tenSach, String soLuong) {
        this.tenSach = tenSach;
        this.soLuong = soLuong;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "tenSach: " + tenSach + '-' + " soLuong: " + soLuong;
    }
}
