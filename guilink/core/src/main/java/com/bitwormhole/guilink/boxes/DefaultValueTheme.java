package com.bitwormhole.guilink.boxes;

public class DefaultValueTheme extends ThemeWrapper {

    public DefaultValueTheme(Theme in) {
        super(in);
    }

    @Override
    public Style load(StyleSelector selector) {
        Style sty = super.load(selector);
        return innerWrapStyle(sty);
    }

    @Override
    public Style select(StyleSelector sel) {
        Style sty = super.select(sel);
        return innerWrapStyle(sty);
    }

    private static Style innerWrapStyle(Style s1) {
        if (s1 instanceof DefaultValueStyle) {
            return s1;
        }
        return new DefaultValueStyle(s1);
    }

}
