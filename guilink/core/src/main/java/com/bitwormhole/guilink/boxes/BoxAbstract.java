package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.events.IKeyEventHandler;
import com.bitwormhole.guilink.events.IMouseEventHandler;
import com.bitwormhole.guilink.events.ITouchEventHandler;
import com.bitwormhole.guilink.events.KeyEvent;
import com.bitwormhole.guilink.events.MouseEvent;
import com.bitwormhole.guilink.events.TouchEvent;
import com.bitwormhole.guilink.geometries.Point;

public abstract class BoxAbstract
        implements ILayoutable, IPaintable, IMouseEventHandler, IKeyEventHandler, ITouchEventHandler {

    ////////////////////////////////////////////////////////////////////////////
    // public

    public abstract void move(float x, float y, float width, float height);

    ////////////////////////////////////////////////////////////////////////////
    // protected

    protected abstract void onPaint(PaintContext pc);

    protected abstract void onPaintBackground(PaintContext pc);

    protected abstract void onPaintForeground(PaintContext pc);

    protected abstract void onUpdateLayout(LayoutContext lc);

    protected abstract void onKeyEvent(KeyEvent event);

    protected abstract void onMouseEvent(MouseEvent event);

    protected abstract void onTouchEvent(TouchEvent event);

    protected abstract Point computeLocationAtCanvas();

}
