package com.bitwormhole.guilink.guilink4awt;

import com.bitwormhole.starter4j.convertors.ConvertorHolderT;

public final class ColorConvertors {

    public static java.awt.Color convert(com.bitwormhole.guilink.graphics.Color src) {
        return theForwardRgbaConvertorHolder.convert(src);
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private static final MyForwardRgbaConvertorHolder theForwardRgbaConvertorHolder = new MyForwardRgbaConvertorHolder();

    private ColorConvertors() {
    }

    private static class MyForwardRgbaConvertorHolder
            extends ConvertorHolderT<com.bitwormhole.guilink.graphics.Color, java.awt.Color> {
        MyForwardRgbaConvertorHolder() {
            super(com.bitwormhole.guilink.graphics.Color.class, java.awt.Color.class);
            ColorConvertorsProvider.registerSelf();
        }
    }

}
