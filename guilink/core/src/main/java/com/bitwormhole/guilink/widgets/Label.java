package com.bitwormhole.guilink.widgets;

import com.bitwormhole.guilink.boxes.AlignEnum;
import com.bitwormhole.guilink.boxes.Box;
import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.boxes.BoxEntity;
import com.bitwormhole.guilink.boxes.PaintContext;
import com.bitwormhole.guilink.boxes.Style;
import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Font;
import com.bitwormhole.guilink.graphics.Graphics;
import com.bitwormhole.guilink.utils.GuilinkGetters;

public class Label extends BoxEntity {

    private String text;

    public Label(BoxContext bc) {
        super(bc);
    }

    public Label(BoxContext bc, String label) {
        super(bc);
        this.text = label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected void onPaintForeground(PaintContext pc) {
        this.paintLabelText(pc);
        super.onPaintForeground(pc);
    }

    private void paintLabelText(PaintContext pc) {

        Style style1 = this.getStyle();
        prepareStyle(style1);

        Graphics g = pc.graphics;
        String str = this.text;
        Color fgColor = style1.getForegroundColor();
        Font font = style1.getFont();

        final TextLocationComputer tlc = new TextLocationComputer();
        tlc.init(g, this, str, style1);
        Point pt = tlc.location();

        g.setFont(font);
        g.setColor(fgColor);
        g.drawText(str, pt.x, pt.y);
    }

    private static void prepareStyle(Style st) {

        // font
        Font font = st.getFont();
        if (font == null) {
            font = GuilinkGetters.notNull(font);
            st.setFont(font);
        }

        // fg-color
        Color fg = st.getForegroundColor();
        if (fg == null) {
            fg = GuilinkGetters.notNull(fg);
            st.setForegroundColor(fg);
        }

        // align
        AlignEnum align = st.getTextAlign();
        if (align == null) {
            align = GuilinkGetters.notNull(align);
            st.setTextAlign(align);
        }
    }

    private static class TextLocationComputer {

        // String text;
        // Graphics graphics;

        float text_w, text_h, box_w, box_h;
        AlignEnum align;
        Style style;

        void init(Graphics g, Box box, String txt, Style _style) {

            Size box_size = box.getSize();
            Font font = GuilinkGetters.notNull(_style.getFont());

            // AffineTransform at = new AffineTransform();
            // FontRenderContext frc = new FontRenderContext(at, true, true);
            // Rectangle2D txt_rect = font.getStringBounds(txt, frc);

            Size txt_size = g.computeTextSize(txt, font);

            this.box_h = box_size.height;
            this.box_w = box_size.width;
            this.text_h = txt_size.height;
            this.text_w = txt_size.width;
            this.align = _style.getTextAlign();
            this.style = _style;

            // this.graphics = g;
        }

        Point location() {
            switch (align) {
                case LEFT:
                    return this.computeLocationLeft();
                case RIGHT:
                    return this.computeLocationRight();
                case TOP:
                    return this.computeLocationTop();
                case BOTTOM:
                    return this.computeLocationBottom();
                case TOP_LEFT:
                    return this.computeLocationTopLeft();
                case TOP_RIGHT:
                    return this.computeLocationTopRight();
                case BOTTOM_LEFT:
                    return this.computeLocationBottomLeft();
                case BOTTOM_RIGHT:
                    return this.computeLocationBottomRight();
                default: // CENTER
                    break;
            }
            return this.computeLocationCenter();
        }

        Point computeLocationTopLeft() {

            Float p_top = this.style.getPaddingTop();
            Float p_left = this.style.getPaddingLeft();

            p_top = GuilinkGetters.notNull(p_top);
            p_left = GuilinkGetters.notNull(p_left);

            float x = 0 + p_left;
            float y = text_h + p_top;
            return new Point(x, y);
        }

        Point computeLocationTopRight() {

            Float p_top = this.style.getPaddingTop();
            Float p_right = this.style.getPaddingRight();

            p_top = GuilinkGetters.notNull(p_top);
            p_right = GuilinkGetters.notNull(p_right);

            float x = (box_w - text_w) - p_right;
            float y = text_h + p_top;
            return new Point(x, y);
        }

        Point computeLocationBottomLeft() {

            Float p_bottom = this.style.getPaddingBottom();
            Float p_left = this.style.getPaddingLeft();

            p_bottom = GuilinkGetters.notNull(p_bottom);
            p_left = GuilinkGetters.notNull(p_left);

            float x = 0 + p_left;
            float y = box_h - p_bottom;
            return new Point(x, y);
        }

        Point computeLocationBottomRight() {

            Float p_bottom = this.style.getPaddingBottom();
            Float p_right = this.style.getPaddingRight();

            p_bottom = GuilinkGetters.notNull(p_bottom);
            p_right = GuilinkGetters.notNull(p_right);

            float x = (box_w - text_w) - p_right;
            float y = box_h - p_bottom;
            return new Point(x, y);
        }

        Point computeLocationLeft() {

            Float p_left = this.style.getPaddingLeft();

            p_left = GuilinkGetters.notNull(p_left);

            float x = 0 + p_left;
            float y = (box_h / 2) + (text_h / 4);
            return new Point(x, y);
        }

        Point computeLocationRight() {

            Float p_right = this.style.getPaddingRight();

            p_right = GuilinkGetters.notNull(p_right);

            float x = (box_w - text_w) - p_right;
            float y = (box_h / 2) + (text_h / 4);
            return new Point(x, y);
        }

        Point computeLocationBottom() {

            Float p_bottom = this.style.getPaddingBottom();

            p_bottom = GuilinkGetters.notNull(p_bottom);

            float x = (box_w - text_w) / 2;
            float y = box_h - p_bottom;
            return new Point(x, y);
        }

        Point computeLocationTop() {

            Float p_top = this.style.getPaddingTop();

            p_top = GuilinkGetters.notNull(p_top);

            float x = (box_w - text_w) / 2;
            float y = text_h + p_top;
            return new Point(x, y);
        }

        Point computeLocationCenter() {
            float x = (box_w - text_w) / 2;
            float y = (box_h / 2) + (text_h / 4);
            return new Point(x, y);
        }
    }

}
