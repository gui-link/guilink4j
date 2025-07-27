package com.bitwormhole.guilink.layouts;

import java.util.List;

import com.bitwormhole.guilink.boxes.Box;
import com.bitwormhole.guilink.boxes.Container;
import com.bitwormhole.guilink.boxes.Layout;
import com.bitwormhole.guilink.boxes.LayoutContext;
import com.bitwormhole.guilink.geometries.Size;

/***************************************************
 * GridLayout 这个布局提供一个类似表格的 "行-列" 式布局
 */

public class GridLayout implements Layout {

    private int rows;
    private int columns;

    public GridLayout() {
        this.rows = 1;
        this.columns = 1;
    }

    public GridLayout(int _rows, int _cols) {
        this.rows = _rows;
        this.columns = _cols;
    }

    private void doMakeLayout(LayoutContext lc, Container container) {

        final int row_count = this.rows;
        final int col_count = this.columns;
        List<Box> all = container.getChildren();
        Size size = container.getSize();

        if (row_count < 1 || col_count < 1) {
            return;
        }

        float x, y, w, h;
        float w2, h2;

        x = 0;
        y = 0;
        w = size.width / col_count;
        h = size.height / row_count;

        for (int row = 0; row < row_count; row++) {
            for (int col = 0; col < col_count; col++) {
                final int index = (row * col_count) + (col);
                final Box child = this.getChildAt(index, all);
                x = w * col;
                y = h * row;
                w2 = w;
                h2 = h;

                if (col == col_count - 1) {
                    // 如果是最后一列
                    w2 = size.width - x;
                }
                if (row == row_count - 1) {
                    // 如果是最后一行
                    h2 = size.height - y;
                }

                this.makeChildLayout(child, x, y, w2, h2);
            }
        }
    }

    private void makeChildLayout(Box child, float x, float y, float w, float h) {
        if (child == null) {
            return;
        }
        child.move(x, y, w, h);
    }

    private Box getChildAt(int index, List<Box> all) {
        if (all == null || index < 0) {
            return null;
        }
        if (index < all.size()) {
            return all.get(index);
        }
        return null;
    }

    @Override
    public void applyLayout(LayoutContext lc, Container container) {
        this.doMakeLayout(lc, container);
        container.updateLayoutForChildren(lc);
    }
}
