package com.bitwormhole.guilink.themes;

import com.bitwormhole.guilink.boxes.BoxStateEnum;
import com.bitwormhole.guilink.boxes.Style;
import com.bitwormhole.guilink.boxes.StyleSelector;
import com.bitwormhole.guilink.boxes.Theme;
import com.bitwormhole.guilink.boxes.ThemeWrapper;

public class NormalBasedThemeWrapper extends ThemeWrapper {

    public NormalBasedThemeWrapper(Theme in) {
        super(in);
    }

    @Override
    protected Style onLoadStyle(StyleSelector selector) {

        if (selector == null) {
            return new Style();
        }

        Style style = selector.getOlder();
        BoxStateEnum state, state1, state2;
        state = selector.getState();
        state1 = BoxStateEnum.NORMAL;

        if (style == null) {
            style = new Style();
        }

        if (state == null) {
            state2 = null;
        } else if (state == BoxStateEnum.NORMAL) {
            state2 = null;
        } else if (state == BoxStateEnum.AUTO) {
            state2 = null;
        } else {
            state2 = state;
        }

        // load with state1
        selector.setOlder(style);
        selector.setState(state1);
        style = super.onLoadStyle(selector);

        // load with state2
        if (state2 != null) {
            selector.setOlder(style);
            selector.setState(state2);
            style = super.onLoadStyle(selector);
        }

        return style;
    }
}
