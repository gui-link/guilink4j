package com.bitwormhole.guilink.boxes;

import java.util.ArrayList;
import java.util.List;

import com.bitwormhole.guilink.events.MouseEvent;
import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.graphics.Graphics;
import com.bitwormhole.guilink.layouts.SimpleLayout;

public class ContainerEntity extends Container {

    @Override
    public void updateLayoutForChildren(LayoutContext lc) {
        this.onUpdateLayoutForChildren(lc);
    }

    @Override
    protected void onUpdateLayoutForChildren(LayoutContext lc1) {
        final Container self = this;
        List<Box> list = this.getChildrenForLayout();
        LayoutSession session = lc1.session;
        LayoutContext lc2 = session.getLayoutContextAt(lc1.depth + 1);
        BoxContext bc = session.getBoxContext();

        for (Box child : list) {
            child.setContext(bc);
            child.setParent(self);
            child.updateLayout(lc2);
        }
    }

    @Override
    protected void onUpdateLayout(LayoutContext lc) {
        super.onUpdateLayout(lc);
        Layout l = this.getLayout();
        if (l == null) {
            l = new SimpleLayout();
            this.setLayout(l);
        }
        l.applyLayout(lc, this);
    }

    @Override
    public List<Box> getChildrenForLayout() {
        return super.getChildrenForLayout();
    }

    @Override
    public void add(Box child) {
        this.add(child, 0);
    }

    @Override
    public void add(Box child, int layout_pos) {
        if (child == null) {
            return;
        }
        child.setLayoutPosition(layout_pos);
        this.getChildren().add(child);
        this.setChildrenForLayout(null);
    }

    @Override
    protected List<Box> createChildrenListForLayout() {
        List<Box> src = this.getChildren();
        List<Box> list = new ArrayList<>();
        int count = 0;
        for (Box child : src) {
            int i = count++;
            if (isChildReady(child)) {
                child.setIndex(i);
                list.add(child);
            }
        }
        list.sort((a, b) -> this.compareChildren(a, b));
        return list;
    }

    private final int compareChildren(Box c1, Box c2) {

        final int z1 = c1.getZ();
        final int z2 = c2.getZ();
        final int zz = z2 - z1;
        if (zz != 0) {
            return (zz < 0) ? -1 : 1;
        }

        final int i1 = c1.getIndex();
        final int i2 = c2.getIndex();
        final int ii = i2 - i1;
        if (ii != 0) {
            return (ii < 0) ? -1 : 1;
        }

        return 0;
    }

    private final boolean isChildReady(Box child) {
        if (child == null) {
            return false;
        }
        return true;
    }

    @Override
    protected void onPaint(PaintContext pc) {
        // super.onPaint(pc);
        this.onPaintBackground(pc);
        this.onPaintChildren(pc);
        this.onPaintForeground(pc);
    }

    @Override
    protected void onPaintChildren(PaintContext pc1) {

        List<Box> clist = this.getChildrenForLayout();
        PaintSession session = pc1.session;
        PaintContext pc2 = session.getPaintContextAt(pc1.depth + 1);
        final Graphics g1 = pc1.graphics;
        final BoxContext bc = session.getBoxContext();

        for (Box child : clist) {
            if (child == null) {
                continue;
            }
            if (!child.isPresent()) {
                continue;
            }
            Graphics g2 = prepareGraphicsForChild(g1, this, child);
            pc2.graphics = g2;
            child.setContext(bc);
            child.paint(pc2);
        }
    }

    private static Graphics prepareGraphicsForChild(Graphics g1, Container parent, Box child) {
        Size size = child.getSize();
        Point at = child.getLocation();
        Graphics g2;
        if (child.isClip()) {
            // do clip
            g2 = g1.create(at.x, at.y, size.width, size.height);
        } else {
            // with out clip
            g2 = g1.create();
            g2.translate(at.x, at.y);
        }
        return g2;
    }

    @Override
    protected void onMouseEvent(MouseEvent event) {
        this.dispatchMouseEventToChildren(event);
        if (innerIsEventClosed(event)) {
            return;
        }
        super.onMouseEvent(event);
    }

    @Override
    protected void dispatchMouseEventToChildren(MouseEvent me) {
        List<Box> list = this.getChildrenForLayout();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (innerIsEventClosed(me)) {
                break;
            }
            Box child = list.get(i);
            if (innerIsHitChild(me, child)) {
                child.handleMouseEvent(me);
            }
        }
    }

    private static boolean innerIsEventClosed(MouseEvent me) {
        if (me == null) {
            return true;
        }
        return (me.isCancelled() || me.isHandled());
    }

    private static boolean innerIsHitChild(MouseEvent me, Box child) {
        if (me == null || child == null) {
            return false;
        }

        Point pt1 = me.getLocationAtCanvas();
        Point pt2 = child.getLocationAtCanvas();
        Size sz = child.getSize();

        final float left, top, right, bottom, x, y;
        x = pt1.x;
        y = pt1.y;
        top = pt2.y;
        left = pt2.x;
        right = pt2.x + sz.width;
        bottom = pt2.y + sz.height;

        return ((left < x) && (top < y) && (y < bottom) && (x < right));
    }

}
