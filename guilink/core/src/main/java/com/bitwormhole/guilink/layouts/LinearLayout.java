package com.bitwormhole.guilink.layouts;

import java.util.ArrayList;
import java.util.List;

import com.bitwormhole.guilink.boxes.Box;
import com.bitwormhole.guilink.boxes.Container;
import com.bitwormhole.guilink.boxes.Layout;
import com.bitwormhole.guilink.boxes.LayoutContext;
import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.utils.GuilinkGetters;

public class LinearLayout implements Layout {

    ////////////////////////////////////////////////////////////////////////////
    /// public

    public enum Direction {
        HORIZONTAL, VERTICAL,
    }

    public static final Direction HORIZONTAL = Direction.HORIZONTAL;
    public static final Direction VERTICAL = Direction.VERTICAL;

    public LinearLayout(Direction direction) {
        this.mDirection = direction;
    }

    @Override
    public void applyLayout(LayoutContext lc, Container container) {

        if (this.isHorizontal()) {
            this.doBuildLayoutH(lc, container);
        } else {
            this.doBuildLayoutV(lc, container);
        }

        container.updateLayoutForChildren(lc);

    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private final Direction mDirection;

    private boolean isHorizontal() {
        return (this.mDirection == HORIZONTAL);
    }

    private static class ChildHolder {
        Box child;
        float weight; // 当 weight==0, 使用 length 作为尺寸
        float lengthRaw;
        float lengthFinal;

        // 判断这个 box 是否是固定大小的
        boolean isFixed() {
            final float precision = 0.0001f;
            return ((Math.abs(weight - 0) < precision) && (lengthRaw > precision));
        }
    }

    private List<ChildHolder> makeHolderList(List<Box> src) {
        List<ChildHolder> dst = new ArrayList<>();
        if (src == null) {
            return dst;
        }
        final boolean is_horz = this.isHorizontal();
        for (Box item : src) {
            if (item == null) {
                continue;
            }
            Size want_size = GuilinkGetters.notNull(item.getWantSize());
            ChildHolder holder = new ChildHolder();
            holder.child = item;
            holder.weight = item.getWeight();
            holder.lengthRaw = is_horz ? want_size.width : want_size.height;
            dst.add(holder);
        }
        return dst;
    }

    private static void computeLengths(List<ChildHolder> list, final float total_length) {

        float fixed_length = 0;
        float total_weight = 0;

        for (ChildHolder ch : list) {
            if (ch.isFixed()) {
                fixed_length += ch.lengthRaw;
                ch.lengthFinal = ch.lengthRaw;
            } else {
                total_weight += ch.weight;
            }
        }

        float pos1, pos2;
        pos1 = pos2 = 0;
        float sum_weight = 0;
        final float full_lenght = total_length - fixed_length; // @weight 部分的长度

        for (ChildHolder ch : list) {
            if (!ch.isFixed()) {
                sum_weight += ch.weight;
                pos2 = computePosWithWeight(sum_weight, total_weight, full_lenght);
                ch.lengthFinal = pos2 - pos1;
                pos1 = pos2;
            }
        }
    }

    private static float computePosWithWeight(float at, float full_weight, float full_lenght) {
        final float min = 0.01f;
        if (full_weight < min) {
            full_weight = min;
        }
        float x = at / full_weight; // @division
        return (int) (x * full_lenght);
    }

    private void doBuildLayoutV(LayoutContext lc, final Container parent) {

        // layout like:
        // 口
        // 口
        // 口

        Size p_size = getParentSize(parent);
        List<Box> children = parent.getChildren();
        List<ChildHolder> holders = this.makeHolderList(children);

        float x, y, w, h;
        x = y = 0;
        w = p_size.width;

        computeLengths(holders, p_size.height);

        for (ChildHolder holder : holders) {
            final Box child = holder.child;
            h = holder.lengthFinal;
            child.setLocation(new Point(x, y));
            child.setSize(new Size(w, h));
            y += h;
        }
    }

    private void doBuildLayoutH(LayoutContext lc, final Container parent) {

        // layout like: 口口口口口

        Size p_size = getParentSize(parent);
        List<Box> children = parent.getChildren();
        List<ChildHolder> holders = this.makeHolderList(children);

        float x, y, w, h;
        x = y = 0;
        h = p_size.height;

        computeLengths(holders, p_size.width);

        for (ChildHolder holder : holders) {
            final Box child = holder.child;
            w = holder.lengthFinal;
            child.setLocation(new Point(x, y));
            child.setSize(new Size(w, h));
            x += w;
        }
    }

    private static Size getParentSize(Container parent) {

        Size size;

        size = parent.getSize();
        if (size != null) {
            return size;
        }

        // size = parent.getWantSize();
        // if (size != null) {
        // return size;
        // }

        return new Size();
    }

}
