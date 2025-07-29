package com.bitwormhole.guilink.guilink4awt;

import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import com.bitwormhole.starter4j.convertors.Convertor;
import com.bitwormhole.starter4j.convertors.ConvertorManager;
import com.bitwormhole.starter4j.convertors.ConvertorRegistration;
import com.bitwormhole.starter4j.convertors.ConvertorRegistry;

final class FontConvertorsProvider implements ConvertorRegistry {

    public static void registerSelf() {
        ConvertorRegistry cr = new FontConvertorsProvider();
        ConvertorManager cm = ConvertorManager.getInstance();
        cm.register(cr);
    }

    @Override
    public ConvertorRegistration[] listConvertorRegistrations() {
        Convertor convertor = new MyDefaultFontConvertor();
        ConvertorRegistration cr = convertor.getRegistration();
        return new ConvertorRegistration[] { cr };
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private static class MyDefaultFontConvertor implements Convertor {

        private static final Class<?> INPUT_TYPE = com.bitwormhole.guilink.graphics.Font.class;
        private static final Class<?> OUTPUT_TYPE = java.awt.Font.class;

        @Override
        public Object convert(Object obj) {
            com.bitwormhole.guilink.graphics.Font o1 = (com.bitwormhole.guilink.graphics.Font) obj;

            Map<TextAttribute, Object> attrs = new HashMap<>();
            attrs.put(TextAttribute.WEIGHT, o1.getWeight());
            attrs.put(TextAttribute.SIZE, o1.getSize());
            attrs.put(TextAttribute.FAMILY, o1.getFamily());
            if (o1.isItalic()) {
                attrs.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
            }

            java.awt.Font o2 = new java.awt.Font(attrs);
            return o2;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> T convert(Object o1, Class<T> t2) {
            Object o2 = this.convert(o1);
            return (T) o2;
        }

        @Override
        public boolean acceptInputObject(Object o1) {
            return (o1 instanceof com.bitwormhole.guilink.graphics.Font);
        }

        @Override
        public boolean acceptInputType(Class<?> t1) {
            return INPUT_TYPE.equals(t1);
        }

        @Override
        public ConvertorRegistration getRegistration() {
            ConvertorRegistration cr = new ConvertorRegistration();
            cr.setConvertor(this);
            cr.setInputType(INPUT_TYPE);
            cr.setOutputType(OUTPUT_TYPE);
            return cr;
        }
    }

}
