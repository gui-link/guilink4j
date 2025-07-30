package com.bitwormhole.guilink.widgets;

import com.bitwormhole.guilink.boxes.BoxContext;

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

}
