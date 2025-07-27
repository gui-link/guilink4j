package com.bitwormhole.guilink.boxes;

public class LayoutContext {

    public final LayoutSession session;
    public final LayoutContext parent;
    public final int depth;

    public LayoutContext(LayoutSession s) {
        this.session = s;
        this.parent = null;
        this.depth = 0;
    }

    public LayoutContext(int _depth, LayoutContext _parent) {
        this.parent = _parent;
        this.session = _parent.session;
        this.depth = _depth;
    }

}
