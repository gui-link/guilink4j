package com.bitwormhole.guilink.guilink4awt;

import com.bitwormhole.starter4j.convertors.ConvertorHolderT;

public final class StrokeConvertors {

    public static java.awt.Stroke convert(com.bitwormhole.guilink.graphics.Stroke o1) {
        return theForwardBasicStrokeConvertorHolder.convert(o1);
    }

    private static final MyForwardBasicStrokeConvertorHolder theForwardBasicStrokeConvertorHolder = new MyForwardBasicStrokeConvertorHolder();

    private static final class MyForwardBasicStrokeConvertorHolder
            extends ConvertorHolderT<com.bitwormhole.guilink.graphics.Stroke, java.awt.Stroke> {

        MyForwardBasicStrokeConvertorHolder() {
            super(com.bitwormhole.guilink.graphics.Stroke.class, java.awt.Stroke.class);
            StrokeConvertorsProvider.registerSelf();
        }

    }

}
