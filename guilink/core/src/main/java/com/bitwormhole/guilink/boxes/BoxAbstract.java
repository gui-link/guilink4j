package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.events.IKeyEventHandler;
import com.bitwormhole.guilink.events.IMouseEventHandler;
import com.bitwormhole.guilink.events.ITouchEventHandler;
import com.bitwormhole.guilink.events.KeyEvent;
import com.bitwormhole.guilink.events.KeyEventListener;
import com.bitwormhole.guilink.events.MouseEvent;
import com.bitwormhole.guilink.events.MouseEventListener;
import com.bitwormhole.guilink.events.TouchEvent;
import com.bitwormhole.guilink.geometries.Point;

public abstract class BoxAbstract
        implements ILayoutable, IPaintable, IMouseEventHandler, IKeyEventHandler, ITouchEventHandler {

    ////////////////////////////////////////////////////////////////////////////
    // public

    public abstract Point convertFromCanvasToLocal(Point at_canvas, Point at_local);

    public abstract Point convertFromLocalToCanvas(Point at_local, Point at_canvas);

    public abstract boolean containsPointAtCanvas(Point pt);

    public abstract boolean containsPointAtLocal(Point pt);

    public abstract void move(float x, float y, float width, float height);

    public abstract Box findBoxById(int id);

    public abstract Box findBoxByName(String name);

    public abstract void addMouseEventListener(MouseEventListener li);

    public abstract void removeMouseEventListener(MouseEventListener li);

    public abstract void addKeyEventListener(KeyEventListener li);

    public abstract void removeKeyEventListener(KeyEventListener li);

    // action

    public abstract void repaint();

    ////////////////////////////////////////////////////////////////////////////
    // protected

    protected abstract void onPaint(PaintContext pc);

    protected abstract void onPaintBackground(PaintContext pc);

    protected abstract void onPaintForeground(PaintContext pc);

    protected abstract void onUpdateLayout(LayoutContext lc);

    // keyboard
    protected abstract void onKeyEvent(KeyEvent event);

    // mouse
    protected abstract void onMouseEvent(MouseEvent event);

    protected abstract void onMouseHovered(MouseEvent event);

    protected abstract void onMouseDragged(MouseEvent event);

    protected abstract void onMousePressed(MouseEvent event);

    protected abstract void onMouseReleased(MouseEvent event);

    protected abstract void onMouseClicked(MouseEvent event);

    // touch
    protected abstract void onTouchEvent(TouchEvent event);

    // compute

    protected abstract Point computeLocationAtCanvas();

    protected abstract BoxStateEnum computeCurrentState();

}
