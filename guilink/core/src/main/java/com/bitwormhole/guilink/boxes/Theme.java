package com.bitwormhole.guilink.boxes;

public abstract class Theme implements IStyleProvider, StyleLoader {

    @Override
    public Style select(StyleSelector sel) {
        return this.load(sel);
    }

}
