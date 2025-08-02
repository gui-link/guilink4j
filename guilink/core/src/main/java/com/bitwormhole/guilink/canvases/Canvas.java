package com.bitwormhole.guilink.canvases;

import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.boxes.ContainerEntity;
import com.bitwormhole.guilink.events.MouseEvent;
import com.bitwormhole.guilink.events.MouseEventEnum;

public class Canvas extends ContainerEntity {

    public Canvas(BoxContext bc) {
        super(bc);
    }

    @Override
    protected void onMouseEvent(MouseEvent event) {
        super.onMouseEvent(event);

        MouseEventEnum mee = event.getEvent();
        if (MouseEventEnum.EXITED.equals(mee)) {
            this.handleOnMouseExit(event);
        }

    }

    private void handleOnMouseExit(MouseEvent event) {
        BoxContext ctx = this.getContext();
        ctx.setCurrentDragging(null);
        ctx.setCurrentHovering(null);
        ctx.setCurrentPressed(null);
        ctx.requestUpdateLayout();
        ctx.requestRepaint();
    }

}
