package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Graphics;
import com.bitwormhole.guilink.graphics.strokes.BasicStroke;
import com.bitwormhole.guilink.utils.GuilinkGetters;

final class BoxBorderRenderer {

    public static void paintBorder(PaintContext pc, Box box) {

        Size size = box.getSize();
        Graphics g = pc.graphics;
        Style bs = GuilinkGetters.notNull(box.getStyle());

        if (size == null) {
            return;
        }

        Color color = bs.getBorderTopColor();
        Float width = bs.getBorderTopWidth();
        LineStyleEnum style = bs.getBorderTopStyle();
        float x1;
        float x2;
        float y1;
        float y2;
        if (innerHasBorder(color, style, width)) {
            x1 = 0;
            y1 = 0;
            x2 = size.width;
            y2 = 0;
            g.setStroke(new BasicStroke((float) width));
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);
        }

        color = bs.getBorderLeftColor();
        width = bs.getBorderLeftWidth();
        style = bs.getBorderLeftStyle();
        if (innerHasBorder(color, style, width)) {
            x1 = 0;
            y1 = 0;
            x2 = 0;
            y2 = size.height;
            g.setStroke(new BasicStroke((float) width));
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);
        }

        color = bs.getBorderRightColor();
        width = bs.getBorderRightWidth();
        style = bs.getBorderRightStyle();
        if (innerHasBorder(color, style, width)) {
            x1 = size.width;
            y1 = 0;
            x2 = size.width;
            y2 = size.height;
            g.setStroke(new BasicStroke((float) width));
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);
        }

        color = bs.getBorderBottomColor();
        width = bs.getBorderBottomWidth();
        style = bs.getBorderBottomStyle();
        if (innerHasBorder(color, style, width)) {
            x1 = 0;
            y1 = size.height;
            x2 = size.width;
            y2 = size.height;
            g.setStroke(new BasicStroke((float) width));
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);
        }

    }

    private static boolean innerHasBorder(Color c, LineStyleEnum s, Float w) {

        if (w == null) {
            return false;
        }

        if (c == null) {
            return false;
        }

        if (s == null) {
            return false;
        }

        if (LineStyleEnum.NONE.equals(s)) {
            return false;
        }

        return true;
    }

}
