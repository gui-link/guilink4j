package com.bitwormhole.guilink.graphics;

public class Image {

    private ImageInstance instance;
    private ImageMeta meta;

    public Image() {
    }

    public ImageInstance getInstance() {
        return instance;
    }

    public void setInstance(ImageInstance instance) {
        this.instance = instance;
    }

    public ImageMeta getMeta() {
        return meta;
    }

    public void setMeta(ImageMeta meta) {
        this.meta = meta;
    }

}
