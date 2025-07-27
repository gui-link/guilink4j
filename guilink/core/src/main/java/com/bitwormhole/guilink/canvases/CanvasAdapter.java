package com.bitwormhole.guilink.canvases;

public interface CanvasAdapter {

    Canvas canvas();

    void updateLayout(boolean force);

    void repaint(boolean force);

}
