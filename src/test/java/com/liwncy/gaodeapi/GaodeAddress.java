package com.liwncy.gaodeapi;

import java.util.Objects;

public class GaodeAddress {
    /**
     * status : 1
     * info : OK
     * infocode : 10000
     * province : 山东省
     * city : 济南市
     * adcode : 370100
     * rectangle : 116.7172801,36.45453907;117.3654199,36.8701026
     */

    private String province;
    private String city;
    private String adcode;
    private String rectangle;

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

    public String getRectangle() {
        return rectangle;
    }

    public void setRectangle(String rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GaodeAddress that = (GaodeAddress) o;
        return Objects.equals(province, that.province) &&
                Objects.equals(city, that.city) &&
                Objects.equals(adcode, that.adcode) &&
                Objects.equals(rectangle, that.rectangle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(province, city, adcode, rectangle);
    }

    @Override
    public String toString() {
        return "GaodeAddress{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", adcode='" + adcode + '\'' +
                ", rectangle='" + rectangle + '\'' +
                '}';
    }
}
