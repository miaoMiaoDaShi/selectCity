package com.xxp.jiyi.pro.entity;

/**
 * Created by 钟大爷 on 2017/4/4.
 * 城市的实体类
 */

public class CityData {
    private String name;
    private String pinyin;

    public CityData() {
    }

    public CityData(String name, String pinyin) {
        this.name = name;
        this.pinyin = pinyin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
