package com.bitwormhole.guilink.boxes;

public class ThemeWrapper extends Theme {

    private final Theme inner;

    public ThemeWrapper(Theme in) {
        this.inner = in;
    }

    protected Style onLoadStyle(StyleSelector selector) {
        return this.inner.load(selector);
    }

    @Override
    public final Style load(StyleSelector selector) {
        return this.onLoadStyle(selector);
    }

    @Override
    public final Style select(StyleSelector sel) {
        return this.onLoadStyle(sel);
    }

}
