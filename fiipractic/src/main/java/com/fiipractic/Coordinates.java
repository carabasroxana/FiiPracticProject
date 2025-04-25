package com.fiipractic;

public class Coordinates {
    private int lat, lon;

    public Coordinates(double v, double v1) {
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return lat+","+ lon;
    }
}
