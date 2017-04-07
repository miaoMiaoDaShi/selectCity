package com.xxp.jiyi.pro.entity;

import java.util.List;

/**
 * Created by 钟大爷 on 2017/3/27.
 */

public class WeatherData {
    /**
     * showapi_res_code : 0
     * showapi_res_body : {"ret_code":0,"area":"郫县","areaid":"101270107","dayList":[{"day_weather":"多云","night_weather":"晴","night_weather_code":"00","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"01","daytime":"20170327","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","night_air_temperature":"20","day_air_temperature":"4","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/00.png","night_wind_direction":"\n无持续风向"},{"day_weather":"多云","night_weather":"阴","night_weather_code":"02","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"01","daytime":"20170328","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","night_air_temperature":"22","day_air_temperature":"9","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","night_wind_direction":"\n无持续风向"},{"day_weather":"阴","night_weather":"小雨","night_weather_code":"07","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"02","daytime":"20170329","day_weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","night_air_temperature":"19","day_air_temperature":"11","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"\n无持续风向"},{"day_weather":"小雨","night_weather":"小雨","night_weather_code":"07","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"07","daytime":"20170330","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","night_air_temperature":"19","day_air_temperature":"11","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"\n无持续风向"},{"day_weather":"晴","night_weather":"多云","night_weather_code":"01","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"00","daytime":"20170331","day_weather_pic":"http://app1.showapi.com/weather/icon/day/00.png","night_air_temperature":"21","day_air_temperature":"11","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"\n无持续风向"},{"day_weather":"小雨","night_weather":"阴","night_weather_code":"02","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"07","daytime":"20170401","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","night_air_temperature":"23","day_air_temperature":"11","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","night_wind_direction":"\n无持续风向"},{"day_weather":"小雨","night_weather":"小雨","night_weather_code":"07","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"07","daytime":"20170402","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","night_air_temperature":"23","day_air_temperature":"12","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"\n无持续风向"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170403","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"22","day_air_temperature":"14","day_wind_direction":"\n东风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n北风"},{"day_weather":"阴","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"02","daytime":"20170404","day_weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","night_air_temperature":"23","day_air_temperature":"14","day_wind_direction":"\n东风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n东南风"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170405","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"24","day_air_temperature":"14","day_wind_direction":"\n南风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n东风"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170406","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"24","day_air_temperature":"16","day_wind_direction":"\n东南风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n东南风"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170407","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"24","day_air_temperature":"16","day_wind_direction":"\n东北风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n东北风"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170408","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"24","day_air_temperature":"16","day_wind_direction":"\n北风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n北风"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170409","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"24","day_air_temperature":"15","day_wind_direction":"\n东风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n北风"},{"night_weather_code":"301","day_weather":"雨","night_weather":"雨","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170410","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"23","day_air_temperature":"14","day_wind_direction":"\n西南风","night_wind_direction":"\n北风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png"}]}
     */

    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * area : 郫县
         * areaid : 101270107
         * dayList : [{"day_weather":"多云","night_weather":"晴","night_weather_code":"00","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"01","daytime":"20170327","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","night_air_temperature":"20","day_air_temperature":"4","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/00.png","night_wind_direction":"\n无持续风向"},{"day_weather":"多云","night_weather":"阴","night_weather_code":"02","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"01","daytime":"20170328","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","night_air_temperature":"22","day_air_temperature":"9","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","night_wind_direction":"\n无持续风向"},{"day_weather":"阴","night_weather":"小雨","night_weather_code":"07","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"02","daytime":"20170329","day_weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","night_air_temperature":"19","day_air_temperature":"11","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"\n无持续风向"},{"day_weather":"小雨","night_weather":"小雨","night_weather_code":"07","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"07","daytime":"20170330","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","night_air_temperature":"19","day_air_temperature":"11","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"\n无持续风向"},{"day_weather":"晴","night_weather":"多云","night_weather_code":"01","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"00","daytime":"20170331","day_weather_pic":"http://app1.showapi.com/weather/icon/day/00.png","night_air_temperature":"21","day_air_temperature":"11","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"\n无持续风向"},{"day_weather":"小雨","night_weather":"阴","night_weather_code":"02","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"07","daytime":"20170401","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","night_air_temperature":"23","day_air_temperature":"11","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","night_wind_direction":"\n无持续风向"},{"day_weather":"小雨","night_weather":"小雨","night_weather_code":"07","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"07","daytime":"20170402","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","night_air_temperature":"23","day_air_temperature":"12","day_wind_direction":"\n无持续风向","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"\n无持续风向"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170403","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"22","day_air_temperature":"14","day_wind_direction":"\n东风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n北风"},{"day_weather":"阴","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"02","daytime":"20170404","day_weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","night_air_temperature":"23","day_air_temperature":"14","day_wind_direction":"\n东风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n东南风"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170405","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"24","day_air_temperature":"14","day_wind_direction":"\n南风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n东风"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170406","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"24","day_air_temperature":"16","day_wind_direction":"\n东南风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n东南风"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170407","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"24","day_air_temperature":"16","day_wind_direction":"\n东北风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n东北风"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170408","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"24","day_air_temperature":"16","day_wind_direction":"\n北风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n北风"},{"day_weather":"雨","night_weather":"雨","night_weather_code":"301","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170409","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"24","day_air_temperature":"15","day_wind_direction":"\n东风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png","night_wind_direction":"\n北风"},{"night_weather_code":"301","day_weather":"雨","night_weather":"雨","night_wind_power":"微风","day_wind_power":"微风","day_weather_code":"301","daytime":"20170410","day_weather_pic":"http://app1.showapi.com/weather/icon/day/301.png","night_air_temperature":"23","day_air_temperature":"14","day_wind_direction":"\n西南风","night_wind_direction":"\n北风","night_weather_pic":"http://app1.showapi.com/weather/icon/night/301.png"}]
         */

        private int ret_code;
        private String area;
        private String areaid;
        private List<DayListBean> dayList;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAreaid() {
            return areaid;
        }

        public void setAreaid(String areaid) {
            this.areaid = areaid;
        }

        public List<DayListBean> getDayList() {
            return dayList;
        }

        public void setDayList(List<DayListBean> dayList) {
            this.dayList = dayList;
        }

        public static class DayListBean {
            /**
             * day_weather : 多云
             * night_weather : 晴
             * night_weather_code : 00
             * night_wind_power : 微风
             * day_wind_power : 微风
             * day_weather_code : 01
             * daytime : 20170327
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/01.png
             * night_air_temperature : 20
             * day_air_temperature : 4
             * day_wind_direction :
             无持续风向
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/00.png
             * night_wind_direction :
             无持续风向
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String daytime;
            private String day_weather_pic;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String night_weather_pic;
            private String night_wind_direction;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getDaytime() {
                return daytime;
            }

            public void setDaytime(String daytime) {
                this.daytime = daytime;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }
        }
    }
}
