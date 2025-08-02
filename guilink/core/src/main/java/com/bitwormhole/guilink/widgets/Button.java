package com.bitwormhole.guilink.widgets;

import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.events.MouseEvent;

public class Button extends Label {

    public Button(BoxContext bc) {
        super(bc);
        this.innerInitThisButton();
    }

    public Button(BoxContext bc, String text) {
        super(bc, text);
        this.innerInitThisButton();
    }

    private void innerInitThisButton() {
        this.setAcceptHovering(true);
    }

    @Override
    protected void onMouseHovered(MouseEvent event) {
        super.onMouseHovered(event);
        this.getContext().setCurrentHovering(this);
        this.getContext().requestUpdateLayout();
        this.getContext().requestRepaint();
    }

    @Override
    protected void onMousePressed(MouseEvent event) {
        super.onMousePressed(event);
        this.getContext().setCurrentPressed(this);
        this.getContext().requestUpdateLayout();
        this.getContext().requestRepaint();
    }

    @Override
    protected void onMouseReleased(MouseEvent event) {
        super.onMouseReleased(event);
        this.getContext().setCurrentPressed(null);
        this.getContext().requestUpdateLayout();
        this.getContext().requestRepaint();
    }

}
