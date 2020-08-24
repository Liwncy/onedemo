package com.liwncy.onedemo.gaodeapi;

public class GaodeWeather {


    /**
     * province : 北京
     * city : 东城区
     * adcode : 110101
     * windpower : ≤3
     * weather : 晴
     * temperature : 32
     * humidity : 30
     * reporttime : 2020-06-12 14:56:24
     * winddirection : 西南
     */

    private String province;
    private String city;
    private String adcode;
    private String windpower;
    private String weather;
    private String temperature;
    private String humidity;
    private String reporttime;
    private String winddirection;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getWindpower() {
        return windpower;
    }

    public void setWindpower(String windpower) {
        this.windpower = windpower;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getReporttime() {
        return reporttime;
    }

    public void setReporttime(String reporttime) {
        this.reporttime = reporttime;
    }

    public String getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(String winddirection) {
        this.winddirection = winddirection;
    }
}
