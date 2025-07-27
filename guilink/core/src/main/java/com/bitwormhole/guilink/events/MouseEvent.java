package com.bitwormhole.guilink.events;

import com.bitwormhole.guilink.geometries.Point;

public class MouseEvent {

    private Point location;
    private Point locationAtCanvas;
    private MouseEventEnum event;
    private boolean cancelled;
    private boolean handled;

    public MouseEvent() {
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

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isHandled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }

}
