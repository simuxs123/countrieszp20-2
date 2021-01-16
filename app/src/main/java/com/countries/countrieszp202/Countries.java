package com.countries.countrieszp202;

import java.io.Serializable;

public class Countries implements Serializable {
    private String country;
    private String code;
    private int people;
    private int area;
    //sitas konstruktorius naudojamas konstruojant objekta is Json
    public Countries(String country, String code, int people, int area) {
        this.country = country;
        this.code = code;
        this.people = people;
        this.area = area;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "country='" + country + '\'' +
                ", code='" + code + '\'' +
                ", people=" + people +
                ", area=" + area +
                '}';
    }
}
