package com.bitwormhole.guilink.graphics;

public class Context {

    private Implementation implementation;

    private ImageLoader imageLoader;

    public Context() {
    }

    public Implementation getImplementation() {
        return implementation;
    }

    public void setImplementation(Implementation implementation) {
        this.implementation = implementation;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

}
