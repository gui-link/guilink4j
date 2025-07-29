package com.bitwormhole.guilink.themes;

import com.bitwormhole.guilink.boxes.Style;
import com.bitwormhole.guilink.boxes.StyleSelector;
import com.bitwormhole.guilink.boxes.Theme;
import com.bitwormhole.guilink.boxes.ThemeBuilder;

public class BaseTheme extends Theme {

    private final Theme inner;

    public BaseTheme() {
        ThemeBuilder tb = new ThemeBuilder();
        this.onInit(tb);
        this.inner = tb.create();
    }

    protected void onInit(ThemeBuilder tb) {
    }

    @Override
    public Style load(StyleSelector selector) {
        return this.inner.load(selector);
    }

}
