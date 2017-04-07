package com.xxp.jiyi.pro.entity;

/**
 * Created by 钟大爷 on 2017/3/24.
 */

public class NotesData {
    //天气
    private int weather;
    //日期
    private String date;
    //内容
    private String content;
    //时间
    private String time;

    public NotesData() {
    }

    public NotesData(int weather, String date, String content, String time) {
        this.weather = weather;
        this.date = date;
        this.content = content;
        this.time = time;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "NotesData{" +
                "weather=" + weather +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
