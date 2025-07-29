package com.bitwormhole.guilink.boxes;

public class PaintSession {

    public final int depthLimit;
    private BoxContext boxContext;

    public PaintSession() {
        final int limit = BoxingConst.MAX_DEPTH;
        this.depthLimit = limit;
        this.mStack = new MyStack(limit);
    }

    public PaintContext getPaintContextAt(int index) {
        PaintContext pc = this.mStack.getItemAt(index, true);
        if (pc == null) {
            throw new RuntimeException("out of stack range");
        }
        return pc;
    }

    public BoxContext getBoxContext() {
        return boxContext;
    }

    public void setBoxContext(BoxContext boxContext) {
        this.boxContext = boxContext;
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private final MyStack mStack;

    private class MyStack extends BoxingStackT<PaintContext> {

        MyStack(int _size) {
            super(_size);
        }

        @Override
        protected PaintContext createNewItem(int index, PaintContext parent) {
            PaintContext pc;
            if (parent == null) {
                PaintSession ses = PaintSession.this;
                pc = new PaintContext(ses);
            } else {
                pc = new PaintContext(index, parent);
            }
            return pc;
        }

        @Override
        protected PaintContext[] createNewArray(int size) {
            return new PaintContext[size];
        }
    }

}
