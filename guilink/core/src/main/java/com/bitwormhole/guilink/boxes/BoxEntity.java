package com.bitwormhole.guilink.boxes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.guilink.events.KeyEvent;
import com.bitwormhole.guilink.events.MouseEvent;
import com.bitwormhole.guilink.events.MouseEventEnum;
import com.bitwormhole.guilink.events.TouchEvent;
import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Graphics;
import com.bitwormhole.guilink.utils.GuilinkGetters;

public class BoxEntity extends Box {

    static final Logger logger = LoggerFactory.getLogger(BoxEntity.class);

    @Override
    public final void updateLayout(LayoutContext lc) {

        // 清除缓存的绝对位置
        this.setLocationAtCanvas(null);

        this.onUpdateLayout(lc);
    }

    @Override
    public final void paint(PaintContext pc) {
        this.onPaint(pc);
    }

    @Override
    public final void handleMouseEvent(MouseEvent event) {
        this.onMouseEvent(event);
    }

    @Override
    public final void handleKeyEvent(KeyEvent event) {
        this.onKeyEvent(event);
    }

    @Override
    public void move(float x, float y, float width, float height) {
        this.setLocation(new Point(x, y));
        this.setSize(new Size(width, height));
    }

    @Override
    public void handleTouchEvent(TouchEvent event) {
        this.onTouchEvent(event);
    }

    @Override
    protected void onTouchEvent(TouchEvent event) {
    }

    @Override
    protected void onPaint(PaintContext pc) {
        this.onPaintBackground(pc);
        this.onPaintForeground(pc);
    }

    @Override
    protected void onUpdateLayout(LayoutContext lc) {
    }

    @Override
    protected void onKeyEvent(KeyEvent event) {
    }

    @Override
    protected void onMouseEvent(MouseEvent event) {
        MouseEventEnum event_type = event.getEvent();
        if (event_type == null) {
            return;
        }
        switch (event_type) {
            case DRAGGED:
                this.onMouseDragged(event);
                break;
            case HOVERED:
                this.onMouseHovered(event);
                break;
            case PRESSED:
                this.onMousePressed(event);
                break;
            case RELEASED:
                this.onMouseReleased(event);
                break;
            case CLICKED:
                this.onMouseClicked(event);
                break;
            default:
                break;
        }
    }

    @Override
    protected Point computeLocationAtCanvas() {

        final int limit = BoxingConst.MAX_DEPTH;
        Box p = this;
        Point res, lo;
        res = new Point();

        for (int depth = 0; p != null; depth++) {
            if (depth > limit) {
                throw new RuntimeException("the box-stack is too deep");
            }
            lo = p.getLocation();
            res.x += lo.x;
            res.y += lo.y;
            p = p.getParent();
        }

        return res;
    }

    @Override
    protected void onPaintBackground(PaintContext pc) {

        // logger.info(this + ".onPaintBackground()");

        this.innerPaintBackground(pc);
    }

    @Override
    protected void onPaintForeground(PaintContext pc) {

        // logger.info(this + ".onPaintForeground()");

        BoxBorderRenderer.paintBorder(pc, this);
    }

    private void innerPaintBackground(PaintContext pc) {
        Size size = this.getSize();
        Style bs = GuilinkGetters.notNull(this.getStyle());
        Graphics g = pc.graphics;
        Color color = bs.getBackgroundColor();
        float x, y, w, h;
        if (size != null && color != null) {
            x = 0;
            y = 0;
            w = size.width;
            h = size.height;
            g.setColor(color);
            g.fillRect(x, y, w, h);
        }
    }

    @Override
    protected void onMouseHovered(MouseEvent event) {
        if (this.isAcceptHovering()) {
            final BoxContext ctx = this.getContext();
            if (ctx != null) {
                ctx.setCurrentHovering(this);
                this.repaint();
            }
        }
    }

    @Override
    protected void onMouseDragged(MouseEvent event) {
    }

    @Override
    protected void onMousePressed(MouseEvent event) {
    }

    @Override
    protected void onMouseReleased(MouseEvent event) {
    }

    @Override
    protected void onMouseClicked(MouseEvent event) {
    }

    @Override
    protected BoxStateEnum computeCurrentState() {

        // enabled
        boolean en = this.isEnabled();
        if (!en) {
            return BoxStateEnum.DISABLED;
        }

        final BoxContext ctx = this.getContext();
        Box box = null;
        if (ctx != null) {

            // hover
            box = ctx.getCurrentHovering();
            if (this.equals(box)) {
                return BoxStateEnum.HOVERED;
            }

            // drag
            box = ctx.getCurrentDragging();
            if (this.equals(box)) {
                return BoxStateEnum.PRESSED;
            }

        }

        // selected
        boolean sel = this.isSelected();
        if (sel) {
            return BoxStateEnum.SELECTED;
        }

        // normal
        return BoxStateEnum.NORMAL;
    }

    @Override
    public void repaint() {
        final BoxContext ctx = this.getContext();
        if (ctx == null) {
            return;
        }
        ctx.requestRepaint();
        ctx.getAdapter().repaint(false);
    }

}
