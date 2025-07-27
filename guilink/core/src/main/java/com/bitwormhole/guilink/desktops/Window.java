package com.bitwormhole.guilink.desktops;

import com.bitwormhole.guilink.boxes.ContainerEntity;

public class Window extends ContainerEntity {

    private String title;

    public Window() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
