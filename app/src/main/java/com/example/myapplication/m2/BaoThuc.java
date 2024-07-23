package com.example.myapplication.m2;

public class BaoThuc {
    private String tenBaoThuc;
    private boolean thoiGian;
    private String ngayTrongTuan;

    public BaoThuc() {
    }

    public BaoThuc(String tenBaoThuc, boolean thoiGian, String ngayTrongTuan) {
        this.tenBaoThuc = tenBaoThuc;
        this.thoiGian = thoiGian;
        this.ngayTrongTuan = ngayTrongTuan;
    }

    public String getTenBaoThuc() {
        return tenBaoThuc;
    }

    public void setTenBaoThuc(String tenBaoThuc) {
        this.tenBaoThuc = tenBaoThuc;
    }

    public boolean isThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(boolean thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNgayTrongTuan() {
        return ngayTrongTuan;
    }

    public void setNgayTrongTuan(String ngayTrongTuan) {
        this.ngayTrongTuan = ngayTrongTuan;
    }
}
