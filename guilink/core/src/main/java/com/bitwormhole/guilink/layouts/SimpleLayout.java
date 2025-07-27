package com.bitwormhole.guilink.layouts;

import java.util.List;

import com.bitwormhole.guilink.boxes.Box;
import com.bitwormhole.guilink.boxes.Container;
import com.bitwormhole.guilink.boxes.Layout;
import com.bitwormhole.guilink.boxes.LayoutContext;
import com.bitwormhole.guilink.geometries.Size;

public class SimpleLayout implements Layout {

    @Override
    public void applyLayout(LayoutContext lc, Container container) {

        List<Box> clist = container.getChildren();
        Size p_size = container.getSize();
        final float w = p_size.width;
        final float h = p_size.height;

        clist.forEach((child) -> {
            if (isChildReady(child)) {
                child.move(0, 0, w, h);
            }
        });

        container.updateLayoutForChildren(lc);
    }

    private static boolean isChildReady(Box child) {

        if (child == null) {
            return false;
        }

        return true;
    }

}
