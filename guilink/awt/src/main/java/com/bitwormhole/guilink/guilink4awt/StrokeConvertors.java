package com.bitwormhole.guilink.guilink4awt;

import com.bitwormhole.starter4j.convertors.Convertor;
import com.bitwormhole.starter4j.convertors.ConvertorHolder;
import com.bitwormhole.starter4j.convertors.ConvertorManager;
import com.bitwormhole.starter4j.convertors.ConvertorRegistration;
import com.bitwormhole.starter4j.convertors.ConvertorRegistry;

public class StrokeConvertors implements ConvertorRegistry {

    public static java.awt.Stroke convert(com.bitwormhole.guilink.graphics.Stroke o1) {
        Object o2 = theBasicStrokeConvertorHolder.getConvertor().convert(o1);
        return (java.awt.Stroke) o2;
    }

    @Override
    public ConvertorRegistration[] listConvertorRegistrations() {

        ConvertorRegistration cr1 = new ConvertorRegistration();
        cr1.setSourceType(SRC_TYPE);
        cr1.setConvertor(new MyBasicStrokeConvertor());

        return new ConvertorRegistration[] { cr1 };
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private static final Class<?> SRC_TYPE = com.bitwormhole.guilink.graphics.Stroke.class;

    private static final MyBasicStrokeConvertorHolder theBasicStrokeConvertorHolder = new MyBasicStrokeConvertorHolder();

    private static final class MyBasicStrokeConvertorHolder extends ConvertorHolder {

        MyBasicStrokeConvertorHolder() {
            super(SRC_TYPE);

            ConvertorRegistry cr = new StrokeConvertors();
            ConvertorManager cm = ConvertorManager.getInstance();
            cm.register(cr);
        }

    }

    private static class MyBasicStrokeConvertor implements Convertor {

        @Override
        public boolean acceptSourceObject(Object o1) {
            return (o1 instanceof com.bitwormhole.guilink.graphics.Stroke);
        }

        @Override
        public boolean acceptSourceType(Class<?> t1) {
            return SRC_TYPE.equals(t1);
        }

        @Override
        public Object convert(Object obj) {
            com.bitwormhole.guilink.graphics.Stroke o1 = (com.bitwormhole.guilink.graphics.Stroke) obj;
            int width = o1.width;
            java.awt.BasicStroke o2 = new java.awt.BasicStroke(width);
            return o2;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> T convert(Object o1, Class<T> t2) {
            Object o2 = this.convert(o1);
            return (T) o2;
        }

        @Override
        public Class<?> getSourceType() {
            return SRC_TYPE;
        }
    }

}
