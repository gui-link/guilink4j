package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.graphics.Graphics;

public class PaintContext {

    public final PaintSession session;
    public final PaintContext parent;
    public final int depth;

    public Graphics graphics;

    public PaintContext(int _depth, PaintContext _parent) {
        this.depth = _depth;
        this.parent = _parent;
        this.session = _parent.session;
    }

    public PaintContext(PaintSession _session) {
        this.session = _session;
        this.parent = null;
        this.depth = 0;
    }

}
