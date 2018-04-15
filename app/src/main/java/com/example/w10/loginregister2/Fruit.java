package com.example.w10.loginregister2;

/**
 * Created by W10 on 13-Mar-17.
 */


public class Fruit {
    private String exam_name;
    private String date;
    private String info;
    private int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Fruit(int no,String exam_name, String date, String info)
    {
        this.setExam_name(exam_name);
        this.setDate(date);
        this.setInfo(info);
        this.setNo(no);


    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

