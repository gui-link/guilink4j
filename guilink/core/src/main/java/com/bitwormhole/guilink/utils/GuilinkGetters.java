package com.bitwormhole.guilink.utils;

import com.bitwormhole.guilink.boxes.AlignEnum;
import com.bitwormhole.guilink.boxes.LineStyleEnum;
import com.bitwormhole.guilink.boxes.Style;
import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.geometries.Rect;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Font;

public final class GuilinkGetters {

    private GuilinkGetters() {
    }

    public static Float notNull(Float o) {
        if (o == null) {
            return 0f;
        }
        return o;
    }

    public static Point notNull(Point o) {
        if (o == null) {
            return GuilinkDefaultValues.getPoint();
        }
        return o;
    }

    public static Rect notNull(Rect o) {
        if (o == null) {
            return GuilinkDefaultValues.getRect();
        }
        return o;
    }

    public static Size notNull(Size o) {
        if (o == null) {
            return GuilinkDefaultValues.getSize();
        }
        return o;
    }

    public static Style notNull(Style o) {
        if (o == null) {
            return GuilinkDefaultValues.getStyle();
        }
        return o;
    }

    public static Font notNull(Font o) {
        if (o == null) {
            return GuilinkDefaultValues.getFont();
        }
        return o;
    }

    public static Color notNull(Color o) {
        if (o == null) {
            return GuilinkDefaultValues.getColor();
        }
        return o;
    }

    public static AlignEnum notNull(AlignEnum o) {
        if (o == null) {
            return GuilinkDefaultValues.getAlignEnum();
        }
        return o;
    }

    public static Color getFirstValue(Color v1, Color v2) {
        return getFirstValueT(v1, v2);
    }

    public static LineStyleEnum getFirstValue(LineStyleEnum v1, LineStyleEnum v2) {
        return getFirstValueT(v1, v2);
    }

    public static Float getFirstValue(Float v1, Float v2) {
        return getFirstValueT(v1, v2);
    }

    private static <T extends Object> T getFirstValueT(T v1, T v2) {
        if (v1 != null) {
            return v1;
        }
        if (v2 != null) {
            return v2;
        }
        return null;
    }

}
