package com.bitwormhole.guilink.guilink4swing;

import java.awt.Dimension;
import java.awt.Graphics2D;
import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.geometries.Rect;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.guilink4awt.ColorConvertors;
import com.bitwormhole.guilink.guilink4awt.FontConvertors;

public final class SwingGraphicsConvertor {

    public static java.awt.Font convert(com.bitwormhole.guilink.graphics.Font src) {

        // int style = java.awt.Font.PLAIN;
        // java.awt.Font dst;
        // dst = new java.awt.Font(src.getName(), style, (int) src.getSize());
        // return dst;

        return FontConvertors.convert(src);
    }

    public static java.awt.Color convert(com.bitwormhole.guilink.graphics.Color src) {
        return ColorConvertors.convert(src);
    }

    public static java.awt.Dimension convert(com.bitwormhole.guilink.geometries.Size src) {
        java.awt.Dimension dst;
        dst = new Dimension((int) src.width, (int) src.height);
        return dst;
    }

    public static com.bitwormhole.guilink.geometries.Size convert(java.awt.Dimension src) {
        com.bitwormhole.guilink.geometries.Size dst;
        dst = new Size(src.width, src.height);
        return dst;
    }

    public static com.bitwormhole.guilink.geometries.Rect convert(java.awt.Rectangle src) {
        com.bitwormhole.guilink.geometries.Rect dst;
        dst = new Rect(src.x, src.y, src.width, src.height);
        return dst;
    }

    public static com.bitwormhole.guilink.geometries.Point convert(java.awt.Point src) {
        com.bitwormhole.guilink.geometries.Point dst;
        dst = new Point(src.x, src.y);
        return dst;
    }

    public static com.bitwormhole.guilink.graphics.Graphics convert(Graphics2D src) {
        return new SwingGraphicsInstance(src);
    }

    public static java.awt.Stroke convert(com.bitwormhole.guilink.graphics.Stroke src) {

        // TODO ...

        return new java.awt.BasicStroke(src.width);

    }

    private SwingGraphicsConvertor() {
        // nop
    }
}
