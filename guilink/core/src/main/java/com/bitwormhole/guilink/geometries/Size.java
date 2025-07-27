package com.bitwormhole.guilink.geometries;

public class Size {

    public float width;
    public float height;

    public Size() {
    }

    public Size(float w, float h) {
        this.width = w;
        this.height = h;
    }

    public Size(Size src) {
        if (src == null) {
            return;
        }
        this.width = src.width;
        this.height = src.height;
    }

    @Override
    public String toString() {
        return "[Size w:" + this.width + " h:" + this.height + "]";
    }
}
