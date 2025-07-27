package com.bitwormhole.guilink.widgets;

import com.bitwormhole.guilink.boxes.BoxEntity;

public class Label extends BoxEntity {

    private String text;

    public Label() {
    }

    public Label(String label) {
        this.text = label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
