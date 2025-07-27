package com.bitwormhole.guilink.boxes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.guilink.events.KeyEvent;
import com.bitwormhole.guilink.events.MouseEvent;
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

}
