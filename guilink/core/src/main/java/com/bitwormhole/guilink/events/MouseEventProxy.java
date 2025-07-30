package com.bitwormhole.guilink.events;

public class MouseEventProxy implements MouseEventListener {

    private MouseEventListener onMouseClicked;
    private MouseEventListener onMouseHovered;
    private MouseEventListener onMouseDragged;
    private MouseEventListener onMousePressed;
    private MouseEventListener onMouseReleased;
    private MouseEventListener onMouseWheeled;
    private MouseEventListener onMouseEntered;
    private MouseEventListener onMouseExited;

    public MouseEventProxy() {
    }

    public static MouseEventProxy proxy() {
        return new MouseEventProxy();
    }

    public MouseEventListener getOnMouseClicked() {
        return onMouseClicked;
    }

    public MouseEventProxy setOnMouseClicked(MouseEventListener onMouseClicked) {
        this.onMouseClicked = onMouseClicked;
        return this;
    }

    public MouseEventListener getOnMouseHovered() {
        return onMouseHovered;
    }

    public MouseEventProxy setOnMouseHovered(MouseEventListener onMouseHovered) {
        this.onMouseHovered = onMouseHovered;
        return this;
    }

    public MouseEventListener getOnMouseDragged() {
        return onMouseDragged;
    }

    public MouseEventProxy setOnMouseDragged(MouseEventListener onMouseDragged) {
        this.onMouseDragged = onMouseDragged;
        return this;
    }

    public MouseEventListener getOnMousePressed() {
        return onMousePressed;
    }

    public MouseEventProxy setOnMousePressed(MouseEventListener onMousePressed) {
        this.onMousePressed = onMousePressed;
        return this;
    }

    public MouseEventListener getOnMouseReleased() {
        return onMouseReleased;
    }

    public MouseEventProxy setOnMouseReleased(MouseEventListener onMouseReleased) {
        this.onMouseReleased = onMouseReleased;
        return this;
    }

    public MouseEventListener getOnMouseWheeled() {
        return onMouseWheeled;
    }

    public MouseEventProxy setOnMouseWheeled(MouseEventListener onMouseWheeled) {
        this.onMouseWheeled = onMouseWheeled;
        return this;
    }

    public MouseEventListener getOnMouseEntered() {
        return onMouseEntered;
    }

    public MouseEventProxy setOnMouseEntered(MouseEventListener onMouseEntered) {
        this.onMouseEntered = onMouseEntered;
        return this;
    }

    public MouseEventListener getOnMouseExited() {
        return onMouseExited;
    }

    public MouseEventProxy setOnMouseExited(MouseEventListener onMouseExited) {
        this.onMouseExited = onMouseExited;
        return this;
    }

    @Override
    public void onMouseEvent(MouseEvent event) {
        if (event == null) {
            return;
        }
        MouseEventEnum mee = event.getEvent();
        if (mee == null) {
            return;
        }
        switch (mee) {
            case HOVERED:
                this.invoke(event, this.onMouseHovered);
                break;
            case DRAGGED:
                this.invoke(event, this.onMouseDragged);
                break;
            case CLICKED:
                this.invoke(event, this.onMouseClicked);
                break;
            case PRESSED:
                this.invoke(event, this.onMousePressed);
                break;
            case RELEASED:
                this.invoke(event, this.onMouseReleased);
                break;
            case WHEELED:
                this.invoke(event, this.onMouseWheeled);
                break;
            case ENTERED:
                this.invoke(event, this.onMouseEntered);
                break;
            case EXITED:
                this.invoke(event, this.onMouseExited);
                break;
            default:
                break;
        }
    }

    private void invoke(MouseEvent event, MouseEventListener to) {
        if (event == null || to == null) {
            return;
        }
        to.onMouseEvent(event);
    }

}
