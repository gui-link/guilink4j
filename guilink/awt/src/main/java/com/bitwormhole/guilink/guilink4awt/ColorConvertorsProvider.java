package com.bitwormhole.guilink.guilink4awt;

import com.bitwormhole.starter4j.convertors.Convertor;
import com.bitwormhole.starter4j.convertors.ConvertorManager;
import com.bitwormhole.starter4j.convertors.ConvertorRegistration;
import com.bitwormhole.starter4j.convertors.ConvertorRegistry;

final class ColorConvertorsProvider implements ConvertorRegistry {

    ////////////////////////////////////////////////////////////////////////////
    /// public

    public static void registerSelf() {
        ConvertorRegistry cr = new ColorConvertorsProvider();
        ConvertorManager cm = ConvertorManager.getInstance();
        cm.register(cr);
    }

    @Override
    public ConvertorRegistration[] listConvertorRegistrations() {
        MyForwardRGBAConvertor c1 = new MyForwardRGBAConvertor();
        ConvertorRegistration cr1 = c1.getRegistration();
        return new ConvertorRegistration[] { cr1 };
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private ColorConvertorsProvider() {
    }

    private static class MyForwardRGBAConvertor implements Convertor {

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
        public boolean acceptInputObject(Object o1) {
            return (o1 instanceof com.bitwormhole.guilink.graphics.Color);
        }

        @Override
        public boolean acceptInputType(Class<?> t1) {
            return com.bitwormhole.guilink.graphics.Color.class.equals(t1);
        }

        @Override
        public ConvertorRegistration getRegistration() {
            ConvertorRegistration cr1 = new ConvertorRegistration();
            cr1.setConvertor(this);
            cr1.setInputType(com.bitwormhole.guilink.graphics.Color.class);
            cr1.setOutputType(java.awt.Color.class);
            return cr1;
        }

    }

}
