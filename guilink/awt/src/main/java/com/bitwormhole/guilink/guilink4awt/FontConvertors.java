package com.bitwormhole.guilink.guilink4awt;

import com.bitwormhole.starter4j.convertors.Convertor;
import com.bitwormhole.starter4j.convertors.ConvertorHolder;
import com.bitwormhole.starter4j.convertors.ConvertorManager;
import com.bitwormhole.starter4j.convertors.ConvertorRegistration;
import com.bitwormhole.starter4j.convertors.ConvertorRegistry;

public class FontConvertors implements ConvertorRegistry {

    public static java.awt.Font convert(com.bitwormhole.guilink.graphics.Font o1) {
        Object o2 = theDefaultFontConvertorHolder.getConvertor().convert(o1);
        return (java.awt.Font) o2;
    }

    @Override
    public ConvertorRegistration[] listConvertorRegistrations() {

        ConvertorRegistration cr1 = new ConvertorRegistration();
        cr1.setSourceType(SRC_TYPE);
        cr1.setConvertor(new MyDefaultFontConvertor());

        return new ConvertorRegistration[] { cr1 };
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private static final Class<?> SRC_TYPE = com.bitwormhole.guilink.graphics.Font.class;

    private static final MyDefaultFontConvertorHolder theDefaultFontConvertorHolder = new MyDefaultFontConvertorHolder();

    private static final class MyDefaultFontConvertorHolder extends ConvertorHolder {

        MyDefaultFontConvertorHolder() {
            super(com.bitwormhole.guilink.graphics.Font.class);

            ConvertorRegistry cr = new FontConvertors();
            ConvertorManager cm = ConvertorManager.getInstance();
            cm.register(cr);
        }

    }

    private static class MyDefaultFontConvertor implements Convertor {

        @Override
        public boolean acceptSourceObject(Object o1) {
            return (o1 instanceof com.bitwormhole.guilink.graphics.Font);
        }

        @Override
        public boolean acceptSourceType(Class<?> t1) {
            return SRC_TYPE.equals(t1);
        }

        @Override
        public Object convert(Object obj) {
            com.bitwormhole.guilink.graphics.Font o1 = (com.bitwormhole.guilink.graphics.Font) obj;
            String name = o1.getName();
            int size = (int) o1.getSize();
            int style = java.awt.Font.PLAIN;
            java.awt.Font o2 = new java.awt.Font(name, style, size);
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
