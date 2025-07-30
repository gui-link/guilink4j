package com.bitwormhole.guilink.events;

public class CommonEvent {

    private boolean cancelled;
    private boolean handled;
    private Object source;
    private long timestamp;

    public CommonEvent() {
    }

    public CommonEvent(CommonEvent src) {
        if (src != null) {
            this.cancelled = src.cancelled;
            this.handled = src.handled;
            this.source = src.source;
            this.timestamp = src.timestamp;
        }
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isHandled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }

    public boolean isClosed() {
        return (this.handled || this.cancelled);
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
