package com.bitwormhole.guilink.widgets;

public class Button extends Label {

    public Button() {
        this.innerInitThisButton();
    }

    public Button(String text) {
        super(text);
        this.innerInitThisButton();
    }

    private void innerInitThisButton() {
        this.setAcceptHovering(true);
    }

}
