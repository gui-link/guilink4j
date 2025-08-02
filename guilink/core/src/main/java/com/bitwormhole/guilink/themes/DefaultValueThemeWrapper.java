package com.bitwormhole.guilink.themes;

import com.bitwormhole.guilink.boxes.DefaultValueStyle;
import com.bitwormhole.guilink.boxes.Style;
import com.bitwormhole.guilink.boxes.StyleSelector;
import com.bitwormhole.guilink.boxes.Theme;
import com.bitwormhole.guilink.boxes.ThemeWrapper;

public class DefaultValueThemeWrapper extends ThemeWrapper {

    public DefaultValueThemeWrapper(Theme in) {
        super(in);
    }

    @Override
    public Style onLoadStyle(StyleSelector selector) {
        Style sty = super.onLoadStyle(selector);
        return innerWrapStyle(sty);
    }

    private static Style innerWrapStyle(Style s1) {
        if (s1 instanceof DefaultValueStyle) {
            return s1;
        }
        return new DefaultValueStyle(s1);
    }

}
