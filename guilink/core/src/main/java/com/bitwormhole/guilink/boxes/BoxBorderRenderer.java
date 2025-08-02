package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.geometries.Rect;
import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Graphics;
import com.bitwormhole.guilink.utils.GuilinkGetters;

final class BoxBorderRenderer {

    public static void paintBorder(PaintContext pc, Box box) {

        final BoxOutside outside = box.getOutside();
        final Graphics g = pc.graphics;
        final Style box_style = GuilinkGetters.notNull(box.getStyle());
        final Rect border_side_rect = new Rect();

        Rect side = null;
        Color color = null;
        LineStyleEnum style = null;

        // top
        color = box_style.getBorderTopColor();
        style = box_style.getBorderTopStyle();
        side = innerGetBorderTop(outside, border_side_rect);
        if (innerHasBorderSide(color, style, side)) {
            g.setColor(color);
            g.fillRect(side.x, side.y, side.width, side.height);
        }

        // left
        color = box_style.getBorderLeftColor();
        style = box_style.getBorderLeftStyle();
        side = innerGetBorderLeft(outside, border_side_rect);
        if (innerHasBorderSide(color, style, side)) {
            g.setColor(color);
            g.fillRect(side.x, side.y, side.width, side.height);
        }

        // right
        color = box_style.getBorderRightColor();
        style = box_style.getBorderRightStyle();
        side = innerGetBorderRight(outside, border_side_rect);
        if (innerHasBorderSide(color, style, side)) {
            g.setColor(color);
            g.fillRect(side.x, side.y, side.width, side.height);
        }

        // bottom
        color = box_style.getBorderBottomColor();
        style = box_style.getBorderBottomStyle();
        side = innerGetBorderBottom(outside, border_side_rect);
        if (innerHasBorderSide(color, style, side)) {
            g.setColor(color);
            g.fillRect(side.x, side.y, side.width, side.height);
        }
    }

    static Rect innerGetBorderTop(BoxOutside outside, Rect dst) {
        if (outside == null || dst == null) {
            return null;
        }
        Rect b = outside.getBorder();
        Rect p = outside.getPadding();
        if (b == null || p == null) {
            return null;
        }
        dst.x = b.x;
        dst.y = b.y;
        dst.width = b.width;
        dst.height = p.y - b.y;
        return dst;
    }

    static Rect innerGetBorderLeft(BoxOutside outside, Rect dst) {
        if (outside == null || dst == null) {
            return null;
        }
        Rect b = outside.getBorder();
        Rect p = outside.getPadding();
        if (b == null || p == null) {
            return null;
        }
        dst.x = b.x;
        dst.y = b.y;
        dst.width = p.x - b.x;
        dst.height = b.height;
        return dst;
    }

    static Rect innerGetBorderRight(BoxOutside outside, Rect dst) {
        if (outside == null || dst == null) {
            return null;
        }
        Rect b = outside.getBorder();
        Rect p = outside.getPadding();
        if (b == null || p == null) {
            return null;
        }
        dst.x = p.right();
        dst.y = b.y;
        dst.width = b.right() - p.right();
        dst.height = b.height;
        return dst;
    }

    static Rect innerGetBorderBottom(BoxOutside outside, Rect dst) {
        if (outside == null || dst == null) {
            return null;
        }
        Rect b = outside.getBorder();
        Rect p = outside.getPadding();
        if (b == null || p == null) {
            return null;
        }
        dst.x = b.x;
        dst.y = p.bottom();
        dst.width = b.width;
        dst.height = b.bottom() - p.bottom();
        return dst;
    }

    private static boolean innerHasBorderSide(Color c, LineStyleEnum s, Rect side) {

        if (side == null) {
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
