package com.bitwormhole.guilink.desktops;

import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.boxes.ContainerEntity;

public class Window extends ContainerEntity {

    private String title;

    public Window(BoxContext bc) {
        super(bc);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
