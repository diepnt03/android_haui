package com.example.myapplication.bai4.bai412;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class JobInWeek {
    private String title;
    private String desciption;
    private String dateFinish;
    private String hourFinish;

    public JobInWeek(String title, String desciption,
                     String dateFinish, String hourFinish) {
        this.title = title;
        this.desciption = desciption;
        this.dateFinish = dateFinish;
        this.hourFinish = hourFinish;
    }

    public JobInWeek() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getHourFinish() {
        return hourFinish;
    }

    public void setHourFinish(String hourFinish) {
        this.hourFinish = hourFinish;
    }

    public String getDateFormat(Date d) {
        SimpleDateFormat dft = new
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dft.format(d);
    }

    //lấy định dạng giờ phút
    //@param d
    //@return
    public String getHourFormat(Date d) {
        SimpleDateFormat dft = new SimpleDateFormat("hh:mma", Locale.getDefault());
        return dft.format(d);
    }

    @NonNull
    @Override
    public String toString() {
        return this.title + "-" + this.dateFinish + "-" + this.hourFinish;
    }
}