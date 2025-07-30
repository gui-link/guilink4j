package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.geometries.Rect;
import com.bitwormhole.guilink.geometries.RectUtils;
import com.bitwormhole.guilink.geometries.Size;

/*************************************************
 * BoxOutsideComputer 为 box 计算 BoxOutside 对象
 */
public final class BoxOutsideComputer {

    ////////////////////////////////////////////////////////////////////////////
    /// public

    public static void compute(Box box) {
        BoxOutside dst = new BoxOutside();
        dst = compute(box, dst);
        box.setOutside(dst);
    }

    public static BoxOutside compute(Box box, BoxOutside dst) {
        if (dst == null) {
            dst = new BoxOutside();
        }
        if (box == null) {
            return dst;
        }

        Style style1 = box.getStyle();
        BoxSizingEnum sizing = style1.getBoxSizing();

        if (BoxSizingEnum.BORDER_BOX.equals(sizing)) {
            dst = computeAsBorderBox(box, style1, dst);
        } else {
            dst = computeAsContentBox(box, style1, dst);
        }

        return dst;
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private static BoxOutside computeAsContentBox(Box box, Style style, BoxOutside outside) {

        if (outside == null) {
            outside = new BoxOutside();
        }

        if (box == null || style == null) {
            return outside;
        }

        final Size size = box.getSize(); // = content-size
        final float margin_top, margin_left, margin_right, margin_bottom;
        final float border_top, border_left, border_right, border_bottom;
        final float padding_top, padding_left, padding_right, padding_bottom;

        // get values from style

        margin_top = valueOf(style.getMarginTop());
        margin_left = valueOf(style.getMarginLeft());
        margin_right = valueOf(style.getMarginRight());
        margin_bottom = valueOf(style.getMarginBottom());

        border_top = valueOf(style.getBorderTopWidth());
        border_left = valueOf(style.getBorderLeftWidth());
        border_right = valueOf(style.getBorderRightWidth());
        border_bottom = valueOf(style.getBorderBottomWidth());

        padding_top = valueOf(style.getPaddingTop());
        padding_left = valueOf(style.getPaddingLeft());
        padding_right = valueOf(style.getPaddingRight());
        padding_bottom = valueOf(style.getPaddingBottom());

        // inflate

        Rect content_out = new Rect(0, 0, size.width, size.height);
        Rect padding_out = RectUtils.inflate(content_out, padding_top, padding_left, padding_right, padding_bottom);
        Rect border_out = RectUtils.inflate(padding_out, border_top, border_left, border_right, border_bottom);
        Rect margin_out = RectUtils.inflate(border_out, margin_top, margin_left, margin_right, margin_bottom);

        // save

        outside.setBorder(border_out);
        outside.setContent(content_out);
        outside.setMargin(margin_out);
        outside.setPadding(padding_out);
        outside.setSizing(BoxSizingEnum.CONTENT_BOX);

        return outside;
    }

    private static BoxOutside computeAsBorderBox(Box box, Style style, BoxOutside outside) {

        if (outside == null) {
            outside = new BoxOutside();
        }

        if (box == null || style == null) {
            return outside;
        }

        final Size size = box.getSize(); // = border-size
        final float margin_top, margin_left, margin_right, margin_bottom;
        final float border_top, border_left, border_right, border_bottom;
        final float padding_top, padding_left, padding_right, padding_bottom;

        // get values from style

        margin_top = valueOf(style.getMarginTop());
        margin_left = valueOf(style.getMarginLeft());
        margin_right = valueOf(style.getMarginRight());
        margin_bottom = valueOf(style.getMarginBottom());

        border_top = valueOf(style.getBorderTopWidth());
        border_left = valueOf(style.getBorderLeftWidth());
        border_right = valueOf(style.getBorderRightWidth());
        border_bottom = valueOf(style.getBorderBottomWidth());

        padding_top = valueOf(style.getPaddingTop());
        padding_left = valueOf(style.getPaddingLeft());
        padding_right = valueOf(style.getPaddingRight());
        padding_bottom = valueOf(style.getPaddingBottom());

        // inflate | deflate

        Rect border_out = new Rect(0, 0, size.width, size.height);
        Rect margin_out = RectUtils.inflate(border_out, margin_top, margin_left, margin_right, margin_bottom);
        Rect padding_out = RectUtils.deflate(border_out, border_top, border_left, border_right, border_bottom);
        Rect content_out = RectUtils.deflate(padding_out, padding_top, padding_left, padding_right, padding_bottom);

        // save
        outside.setBorder(border_out);
        outside.setContent(content_out);
        outside.setMargin(margin_out);
        outside.setPadding(padding_out);
        outside.setSizing(BoxSizingEnum.BORDER_BOX);

        return outside;
    }

    private static float valueOf(Float in) {
        if (in == null) {
            return 0;
        }
        return in;
    }

}
