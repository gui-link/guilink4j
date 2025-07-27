package com.bitwormhole.guilink.geometries;

public class Rect {

    public float x;
    public float y;
    public float width;
    public float height;

    public Rect() {
    }

    public Rect(float _x, float _y, float _w, float _h) {
        this.x = _x;
        this.y = _y;
        this.width = _w;
        this.height = _h;
    }

    public Rect(Rect src) {
        if (src == null) {
            return;
        }
        this.x = src.x;
        this.y = src.y;
        this.width = src.width;
        this.height = src.height;
    }

    @Override
    public String toString() {
        return "[Rect x:" + this.x + " y:" + this.y + " w:" + this.width + " h:" + this.height + "]";
    }

}
