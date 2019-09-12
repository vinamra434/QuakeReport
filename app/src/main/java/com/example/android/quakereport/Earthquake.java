package com.example.android.quakereport;

class Earthquake {

    private double magnitude;
    private long date;
    private String place;
    private String url;

    Earthquake(double magnitude, String place, long date, String url){
        this.date = date;
        this.magnitude = magnitude;
        this.place = place;
        this.url = url;
    }

    long getDate(){
        return date;
    }

    double getMagnitude(){
        return magnitude;
    }

    String getPlace(){
        return place;
    }

    String getUrl(){ return url;}

}
