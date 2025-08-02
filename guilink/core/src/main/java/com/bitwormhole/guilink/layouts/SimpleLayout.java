package com.bitwormhole.guilink.layouts;

import java.util.List;

import com.bitwormhole.guilink.boxes.Box;
import com.bitwormhole.guilink.boxes.BoxOutside;
import com.bitwormhole.guilink.boxes.BoxOutsideComputer;
import com.bitwormhole.guilink.boxes.Container;
import com.bitwormhole.guilink.boxes.Layout;
import com.bitwormhole.guilink.boxes.LayoutContext;
import com.bitwormhole.guilink.geometries.Rect;

public class SimpleLayout implements Layout {

    @Override
    public void applyLayout(LayoutContext lc, Container container) {

        List<Box> clist = container.getChildren();
        BoxOutside p_outside = container.getOutside();
        Rect p_content_rect = p_outside.getContent();

        clist.forEach((child) -> {
            if (isChildReady(child)) {
                Rect rect2 = BoxOutsideComputer.computeBoxRectByMarginOutside(child, p_content_rect);
                child.move(rect2.x, rect2.y, rect2.width, rect2.height);
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
