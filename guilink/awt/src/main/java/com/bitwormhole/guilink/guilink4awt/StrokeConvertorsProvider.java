package com.bitwormhole.guilink.guilink4awt;

import com.bitwormhole.starter4j.convertors.Convertor;
import com.bitwormhole.starter4j.convertors.ConvertorManager;
import com.bitwormhole.starter4j.convertors.ConvertorRegistration;
import com.bitwormhole.starter4j.convertors.ConvertorRegistry;

final class StrokeConvertorsProvider implements ConvertorRegistry {

    public static void registerSelf() {
        ConvertorRegistry cr = new StrokeConvertorsProvider();
        ConvertorManager cm = ConvertorManager.getInstance();
        cm.register(cr);
    }

    @Override
    public ConvertorRegistration[] listConvertorRegistrations() {
        Convertor convertor = new MyForwardBasicStrokeConvertor();
        ConvertorRegistration cr1 = convertor.getRegistration();
        return new ConvertorRegistration[] { cr1 };
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private static class MyForwardBasicStrokeConvertor implements Convertor {

        private static final Class<?> INPUT_TYPE = com.bitwormhole.guilink.graphics.Stroke.class;
        private static final Class<?> OUTPUT_TYPE = java.awt.Stroke.class;

        @Override
        public Object convert(Object obj) {
            com.bitwormhole.guilink.graphics.Stroke o1 = (com.bitwormhole.guilink.graphics.Stroke) obj;
            java.awt.BasicStroke o2 = new java.awt.BasicStroke(o1.width);
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
            return (o1 instanceof com.bitwormhole.guilink.graphics.Stroke);
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
