package com.bitwormhole.guilink.events;

public class MouseEventContext extends CommonEvent {

    private int depthLimit;

    public int getDepthLimit() {
        return depthLimit;
    }

    public void setDepthLimit(int depthLimit) {
        this.depthLimit = depthLimit;
    }

}
