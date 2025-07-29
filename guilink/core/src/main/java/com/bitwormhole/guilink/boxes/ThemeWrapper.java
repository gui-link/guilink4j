package com.bitwormhole.guilink.boxes;

public class ThemeWrapper extends Theme {

    private final Theme inner;

    public ThemeWrapper(Theme in) {
        this.inner = in;
    }

    @Override
    public Style load(StyleSelector selector) {
        return this.inner.load(selector);
    }

}
