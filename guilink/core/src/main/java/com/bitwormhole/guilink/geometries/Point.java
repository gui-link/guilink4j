package com.bitwormhole.guilink.geometries;

public class Point {

    public float x;
    public float y;

    public Point() {
    }

    public Point(float _x, float _y) {
        this.x = _x;
        this.y = _y;
    }

    public Point(Point src) {
        if (src == null) {
            return;
        }
        this.x = src.x;
        this.y = src.y;
    }

    @Override
    public String toString() {
        return "[Size x:" + this.x + " y:" + this.y + "]";
    }

}
