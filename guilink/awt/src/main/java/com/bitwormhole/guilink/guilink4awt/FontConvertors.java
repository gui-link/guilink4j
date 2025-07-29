package com.bitwormhole.guilink.guilink4awt;

import com.bitwormhole.starter4j.convertors.ConvertorHolderT;

public final class FontConvertors {

    public static java.awt.Font convert(com.bitwormhole.guilink.graphics.Font o1) {
        return theDefaultFontConvertorHolder.convert(o1);
    }

    private static final MyDefaultFontConvertorHolder theDefaultFontConvertorHolder = new MyDefaultFontConvertorHolder();

    private static final class MyDefaultFontConvertorHolder
            extends ConvertorHolderT<com.bitwormhole.guilink.graphics.Font, java.awt.Font> {

        MyDefaultFontConvertorHolder() {
            super(com.bitwormhole.guilink.graphics.Font.class, java.awt.Font.class);
            FontConvertorsProvider.registerSelf();
        }
    }
}
