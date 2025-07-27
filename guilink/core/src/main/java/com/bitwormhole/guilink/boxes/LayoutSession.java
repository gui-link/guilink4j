package com.bitwormhole.guilink.boxes;

public class LayoutSession {

    public final int depthLimit;
    private BoxContext boxContext;

    public LayoutSession() {
        final int limit = BoxingConst.MAX_DEPTH;
        this.depthLimit = limit;
        this.mStack = new MyStack(limit);
    }

    public LayoutContext getLayoutContextAt(int index) {
        LayoutContext lc = this.mStack.getItemAt(index, true);
        if (lc == null) {
            throw new RuntimeException("out of stack range");
        }
        return lc;
    }

    public int getDepthLimit() {
        return depthLimit;
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

    private class MyStack extends BoxingStackT<LayoutContext> {

        MyStack(int _size) {
            super(_size);
        }

        @Override
        protected LayoutContext createNewItem(int index, LayoutContext parent) {
            LayoutContext lc;
            if (parent == null) {
                LayoutSession ses = LayoutSession.this;
                lc = new LayoutContext(ses);
            } else {
                lc = new LayoutContext(index, parent);
            }
            return lc;
        }

        @Override
        protected LayoutContext[] createNewArray(int size) {
            return new LayoutContext[size];
        }
    }

}
