package com.bitwormhole.guilink.boxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ThemeImpl extends Theme {

    private final Map<MyTableKey, MyTableValue> table;

    public ThemeImpl(List<StylePipelineRegistration> src) {
        this.table = this.makeTable(src);
    }

    private Map<MyTableKey, MyTableValue> makeTable(List<StylePipelineRegistration> src) {
        final Map<MyTableKey, MyTableValue> t = new HashMap<>();
        for (StylePipelineRegistration reg : src) {
            MyTableKey k = new MyTableKey(reg);
            MyTableValue v = new MyTableValue(reg);
            t.put(k, v);
        }
        return t;
    }

    @Override
    public Style load(StyleSelector selector) {

        Style style = selector.getOlder();
        List<Class<?>> stack = selector.getTypeStack();
        BoxStateEnum state = selector.getState();

        if (stack == null) {
            selector = this.prepareTypeStack(selector);
            stack = selector.getTypeStack();
        }

        if (style == null) {
            style = new Style();
        }

        if (state == null) {
            state = BoxStateEnum.NORMAL;
        }

        for (Class<?> tt : stack) {
            StylePipeline pipeline = this.findPipeline(tt, state);
            if (pipeline == null) {
                continue;
            }
            style = pipeline.configure(style);
        }

        return style;
    }

    private static class MyTableKey {

        private final String mStr;

        // private final Class<?> mTT; // target-type
        // private final BoxStateEnum mState;

        MyTableKey(StylePipelineRegistration spr) {
            Class<?> tt = spr.getTargetType();
            BoxStateEnum state = spr.getState();

            state = normalize(state);

            // this.mTT = tt;
            // this.mState = state;
            this.mStr = makeKeyString(tt, state);
        }

        MyTableKey(Class<?> tt, BoxStateEnum state) {

            state = normalize(state);

            // this.mTT = tt;
            // this.mState = state;
            this.mStr = makeKeyString(tt, state);
        }

        static String makeKeyString(Class<?> tt, BoxStateEnum state) {
            return tt.getName() + '#' + state;
        }

        @Override
        public String toString() {
            return this.mStr;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }

            MyTableKey o1 = this;
            MyTableKey o2 = null;
            if (obj instanceof MyTableKey) {
                o2 = (MyTableKey) obj;
            } else {
                return false;
            }

            final String s1 = o1.mStr;
            final String s2 = o2.mStr;
            return s1.equals(s2);
        }

        @Override
        public int hashCode() {
            return this.mStr.hashCode();
        }
    }

    private static class MyTableValue {

        StylePipeline pipeline;

        MyTableValue(StylePipelineRegistration spr) {
            this.pipeline = spr.getPipeline();
        }
    }

    static BoxStateEnum normalize(BoxStateEnum state) {
        if (state == null) {
            state = BoxStateEnum.NORMAL;
        }
        return state;
    }

    private StylePipeline findPipeline(Class<?> target_type, BoxStateEnum state) {
        MyTableKey key = new MyTableKey(target_type, state);
        MyTableValue item = this.table.get(key);
        if (item == null) {
            return null;
        }
        return item.pipeline;
    }

    private StyleSelector prepareTypeStack(StyleSelector selector) {

        List<Class<?>> stack = selector.getTypeStack();
        if (stack != null) {
            return selector;
        }

        stack = new ArrayList<>();
        Class<?> t1 = selector.getType();
        Class<?> pc = t1;

        for (; pc != null;) {
            stack.add(pc);
            pc = pc.getSuperclass();
        }

        Collections.reverse(stack);
        selector.setTypeStack(stack);
        return selector;
    }

}
