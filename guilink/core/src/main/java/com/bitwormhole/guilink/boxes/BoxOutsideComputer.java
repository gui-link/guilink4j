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

    /***********
     * 为 box 计算各个方框的外围大小, 并把结果直接存入这个 box
     */

    public static void computeBoxOutside(Box box) {
        if (box == null) {
            return;
        }
        BoxOutside dst = null;
        dst = computeBoxOutside(box, dst);
        box.setOutside(dst);
    }

    /***********
     * 为 box 计算各个方框的外围大小
     * 
     * @param box 是计算针对的 box 对象
     * @param dst 是用于存储计算结果的 BoxOutside 对象
     * 
     * @return 返回保存了计算结果的 BoxOutside 对象
     * 
     */

    public static BoxOutside computeBoxOutside(Box box, BoxOutside dst) {

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

    /***
     * 根据给出的 margin_outside_rect , 为 box 计算其 size & location;
     * 
     * @param box                 是参与计算的 box 对象
     * @param margin_outside_rect 是框模型的最外层方框
     * 
     * @return 包含了计算结果 (location+size) 的 Rect 对象
     */
    public static Rect computeBoxRectByMarginOutside(Box box, Rect margin_outside_rect) {

        if (box == null || margin_outside_rect == null) {
            return new Rect();
        }

        final Style style = box.getStyle();
        final BoxSizingEnum box_sizing = style.getBoxSizing();

        final float margin_top, margin_left, margin_right, margin_bottom;
        final float border_top, border_left, border_right, border_bottom;
        final float padding_top, padding_left, padding_right, padding_bottom;

        Rect rect = margin_outside_rect;

        // compute with margin
        margin_top = valueOf(style.getMarginTop());
        margin_left = valueOf(style.getMarginLeft());
        margin_right = valueOf(style.getMarginRight());
        margin_bottom = valueOf(style.getMarginBottom());
        rect = RectUtils.deflate(rect, margin_top, margin_left, margin_right, margin_bottom);

        if (BoxSizingEnum.BORDER_BOX.equals(box_sizing)) {
            return rect;
        }

        // compute with border
        border_top = valueOf(style.getBorderTopWidth());
        border_left = valueOf(style.getBorderLeftWidth());
        border_right = valueOf(style.getBorderRightWidth());
        border_bottom = valueOf(style.getBorderBottomWidth());
        rect = RectUtils.deflate(rect, border_top, border_left, border_right, border_bottom);

        // compute with padding
        padding_top = valueOf(style.getPaddingTop());
        padding_left = valueOf(style.getPaddingLeft());
        padding_right = valueOf(style.getPaddingRight());
        padding_bottom = valueOf(style.getPaddingBottom());
        rect = RectUtils.deflate(rect, padding_top, padding_left, padding_right, padding_bottom);

        return rect;
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
