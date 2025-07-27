package com.bitwormhole.guilink.guilink4awt;

import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.starter4j.convertors.Convertor;
import com.bitwormhole.starter4j.convertors.ConvertorHolder;
import com.bitwormhole.starter4j.convertors.ConvertorManager;
import com.bitwormhole.starter4j.convertors.ConvertorRegistration;
import com.bitwormhole.starter4j.convertors.ConvertorRegistry;

public final class ColorConvertors implements ConvertorRegistry {

    ////////////////////////////////////////////////////////////////////////////
    /// public

    public static ConvertorRegistry getRegistry() {
        return new ColorConvertors();
    }

    public static java.awt.Color convert(com.bitwormhole.guilink.graphics.Color src) {
        java.awt.Color dst = theRGBAConvertorHolder.getConvertor().convert(src, java.awt.Color.class);
        return dst;
    }

    @Override
    public ConvertorRegistration[] listConvertorRegistrations() {

        MyRGBAConvertor cc = new MyRGBAConvertor();

        ConvertorRegistration cr1 = new ConvertorRegistration();
        cr1.setConvertor(cc);
        cr1.setSourceType(cc.getSourceType());

        return new ConvertorRegistration[] { cr1 };
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private ColorConvertors() {
    }

    private static final MyRGBAConvertorHolder theRGBAConvertorHolder = new MyRGBAConvertorHolder();

    private static class MyRGBAConvertorHolder extends ConvertorHolder {

        MyRGBAConvertorHolder() {
            super(Color.class);

            ConvertorRegistry cr = getRegistry();
            ConvertorManager cm = ConvertorManager.getInstance();
            cm.register(cr);
        }

    }

    private static class MyRGBAConvertor implements Convertor {

        @Override
        public boolean acceptSourceObject(Object o1) {
            return (o1 instanceof com.bitwormhole.guilink.graphics.Color);
        }

        @Override
        public boolean acceptSourceType(Class<?> t1) {
            return this.getSourceType().equals(t1);
        }

        @Override
        public Object convert(Object o1) {
            com.bitwormhole.guilink.graphics.Color o11 = (com.bitwormhole.guilink.graphics.Color) o1;
            int n = o11.toInt32();
            java.awt.Color o2 = new java.awt.Color(n, true);
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
            return com.bitwormhole.guilink.graphics.Color.class;
        }

    }

}
