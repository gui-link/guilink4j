package com.bitwormhole.guilink.events;

import com.bitwormhole.guilink.geometries.Point;

public class MouseEvent extends CommonEvent {

    private final MouseEventContext context;
    private Point location;
    private Point locationAtCanvas;
    private MouseEventEnum event;
    private int depth;

    public MouseEvent() {
        this.context = new MouseEventContext();
    }

    public MouseEvent(MouseEvent src) {
        super(src);
        MouseEventContext ctx = null;
        if (src != null) {
            this.location = src.location;
            this.locationAtCanvas = src.locationAtCanvas;
            this.event = src.event;
            ctx = src.context;
        }
        if (ctx == null) {
            ctx = new MouseEventContext();
        }
        this.context = ctx;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Point getLocationAtCanvas() {
        return locationAtCanvas;
    }

    public void setLocationAtCanvas(Point locationAtCanvas) {
        this.locationAtCanvas = locationAtCanvas;
    }

    public MouseEventEnum getEvent() {
        return event;
    }

    public void setEvent(MouseEventEnum event) {
        this.event = event;
    }

    public MouseEvent copyThis() {
        return new MouseEvent(this);
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.context.setCancelled(cancelled);
    }

    @Override
    public void setHandled(boolean handled) {
        this.context.setHandled(handled);
    }

    @Override
    public boolean isCancelled() {
        return this.context.isCancelled();
    }

    @Override
    public boolean isHandled() {
        return this.context.isHandled();
    }

    @Override
    public boolean isClosed() {
        return this.context.isClosed();
    }

    public MouseEventContext getContext() {
        return context;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

}
