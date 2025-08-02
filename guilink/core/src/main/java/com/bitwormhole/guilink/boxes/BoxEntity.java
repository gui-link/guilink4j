package com.bitwormhole.guilink.boxes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.guilink.events.EventListenerChain;
import com.bitwormhole.guilink.events.KeyEvent;
import com.bitwormhole.guilink.events.KeyEventListener;
import com.bitwormhole.guilink.events.MouseEvent;
import com.bitwormhole.guilink.events.MouseEventEnum;
import com.bitwormhole.guilink.events.MouseEventListener;
import com.bitwormhole.guilink.events.TouchEvent;
import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.geometries.Rect;
import com.bitwormhole.guilink.geometries.RectUtils;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Graphics;
import com.bitwormhole.guilink.utils.GuilinkGetters;

public class BoxEntity extends Box {

    static final Logger logger = LoggerFactory.getLogger(BoxEntity.class);

    // events
    private EventListenerChain<KeyEvent, KeyEventListener> mKeyEventListenerChain;
    private EventListenerChain<MouseEvent, MouseEventListener> mMouseEventListenerChain;

    public BoxEntity(BoxContext bc) {
        super(bc);
    }

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
        EventListenerChain<KeyEvent, KeyEventListener> chain = this.mKeyEventListenerChain;
        EventListenerChain.dispatchEvent(chain, event, (event2, listener2) -> {
            if (!event2.isClosed()) {
                listener2.onKeyEvent(event2);
            }
        });
    }

    @Override
    protected void onMouseEvent(MouseEvent event) {

        EventListenerChain<MouseEvent, MouseEventListener> chain = this.mMouseEventListenerChain;
        EventListenerChain.dispatchEvent(chain, event, (event2, listener2) -> {
            if (!event2.isClosed()) {
                listener2.onMouseEvent(event2);
            }
        });

        if (event.isClosed()) {
            return;
        }

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

        Style bs = GuilinkGetters.notNull(this.getStyle());
        Color color = bs.getBackgroundColor();

        if (color == null) {
            return;
        }

        Graphics g = pc.graphics;
        Rect rect = this.getOutside().getBorder();
        rect = RectUtils.deflate(rect, 1, 1, 1, 1);

        g.setColor(color);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
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

            // pressed
            box = ctx.getCurrentPressed();
            if (this.equals(box)) {
                return BoxStateEnum.PRESSED;
            }

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

    @Override
    public Box findBoxById(int id) {
        if (id == this.getId()) {
            return this;
        }
        return null;
    }

    @Override
    public Box findBoxByName(String name) {
        if (name != null) {
            if (name.equals(this.getName())) {
                return this;
            }
        }
        return null;
    }

    @Override
    public void addMouseEventListener(MouseEventListener li) {
        EventListenerChain<MouseEvent, MouseEventListener> chain = this.mMouseEventListenerChain;
        this.mMouseEventListenerChain = EventListenerChain.addListener(chain, li);
    }

    @Override
    public void removeMouseEventListener(MouseEventListener li) {
        EventListenerChain<MouseEvent, MouseEventListener> chain = this.mMouseEventListenerChain;
        this.mMouseEventListenerChain = EventListenerChain.removeListener(chain, li);
    }

    @Override
    public void addKeyEventListener(KeyEventListener li) {
        EventListenerChain<KeyEvent, KeyEventListener> chain = this.mKeyEventListenerChain;
        this.mKeyEventListenerChain = EventListenerChain.addListener(chain, li);
    }

    @Override
    public void removeKeyEventListener(KeyEventListener li) {
        EventListenerChain<KeyEvent, KeyEventListener> chain = this.mKeyEventListenerChain;
        this.mKeyEventListenerChain = EventListenerChain.removeListener(chain, li);
    }

    @Override
    public Point convertFromCanvasToLocal(Point at_canvas, Point at_local) {

        Point lac = this.getLocationAtCanvas();

        at_canvas = GuilinkGetters.notNull(at_canvas);
        at_local = GuilinkGetters.notNull(at_local);
        lac = GuilinkGetters.notNull(lac);

        at_local.x = at_canvas.x - lac.x;
        at_local.y = at_canvas.y - lac.y;

        return at_local;
    }

    @Override
    public Point convertFromLocalToCanvas(Point at_local, Point at_canvas) {

        Point lac = this.getLocationAtCanvas();

        at_canvas = GuilinkGetters.notNull(at_canvas);
        at_local = GuilinkGetters.notNull(at_local);
        lac = GuilinkGetters.notNull(lac);

        at_canvas.x = at_local.x + lac.x;
        at_canvas.y = at_local.y + lac.y;

        return at_canvas;
    }

    @Override
    public boolean containsPointAtCanvas(Point pt_c) {
        Point pt_l = this.convertFromCanvasToLocal(pt_c, null);
        return this.containsPointAtLocal(pt_l);
    }

    @Override
    public boolean containsPointAtLocal(Point pt) {
        if (pt == null) {
            return false;
        }
        float x, y, w, h;
        x = pt.x;
        y = pt.y;
        final Size s = this.getSize();
        if (s == null) {
            return false;
        }
        w = s.width;
        h = s.height;
        return ((0 <= x) && (0 <= y) && (x < w) && (y < h));
    }

}
