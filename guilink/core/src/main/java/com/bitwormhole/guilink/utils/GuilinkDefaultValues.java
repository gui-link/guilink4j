package com.bitwormhole.guilink.utils;

import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Font;
import com.bitwormhole.guilink.graphics.Stroke;
import com.bitwormhole.guilink.boxes.AlignEnum;
import com.bitwormhole.guilink.boxes.Style;
import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.geometries.Rect;
import com.bitwormhole.guilink.geometries.Size;

public final class GuilinkDefaultValues {

    private GuilinkDefaultValues() {
    }

    public static Font getFont() {
        return new Font();
    }

    public static Stroke getStroke() {
        return new Stroke();
    }

    public static Color getColor() {
        return Color.BLACK;
    }

    public static Style getStyle() {
        return new Style();
    }

    public static Size getSize() {
        return new Size();
    }

    public static Point getPoint() {
        return new Point();
    }

    public static Rect getRect() {
        return new Rect();
    }

    public static AlignEnum getAlignEnum() {
        return AlignEnum.CENTER;
    }
}
