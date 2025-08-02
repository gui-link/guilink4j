package com.bitwormhole.guilink.layouts;

import java.util.List;

import com.bitwormhole.guilink.boxes.Box;
import com.bitwormhole.guilink.boxes.BoxOutsideComputer;
import com.bitwormhole.guilink.boxes.Container;
import com.bitwormhole.guilink.boxes.Layout;
import com.bitwormhole.guilink.boxes.LayoutContext;
import com.bitwormhole.guilink.geometries.Rect;
import com.bitwormhole.guilink.geometries.Size;

/***************************************************
 * GridLayout 这个布局提供一个类似表格的 "行-列" 式布局
 */

public class GridLayout implements Layout {

    private int rows;
    private int columns;
    private float gapH;
    private float gapV;

    public GridLayout() {
        this.rows = 1;
        this.columns = 1;
    }

    public GridLayout(int _rows, int _cols) {
        this.rows = _rows;
        this.columns = _cols;
    }

    public GridLayout(int _rows, int _cols, float gap_v, float gap_h) {
        this.rows = _rows;
        this.columns = _cols;
        this.gapH = gap_h;
        this.gapV = gap_v;
    }

    private void doMakeLayout(LayoutContext lc, Container container) {

        final int row_count = this.rows;
        final int col_count = this.columns;
        List<Box> all = container.getChildren();
        Rect client = container.getOutside().getContent();

        if (row_count < 1 || col_count < 1) {
            return;
        }

        final float gap_h = this.gapH;
        final float gap_v = this.gapV;
        final float x0, y0, x_step, y_step, w, h;
        float x, y;

        x0 = client.x;
        y0 = client.y;
        x_step = (client.width + gap_h) / col_count;
        y_step = (client.height + gap_v) / row_count;
        w = x_step - gap_h;
        h = y_step - gap_v;

        x = x0;
        y = y0;

        for (int row = 0; row < row_count; row++) {
            x = x0; // reset:x
            for (int col = 0; col < col_count; col++) {
                final int index = (row * col_count) + (col);
                final Box child = this.getChildAt(index, all);
                if (col == col_count - 1) {
                    // 如果是最后一列
                    // w2 = size.width - x;
                }
                if (row == row_count - 1) {
                    // 如果是最后一行
                    // h2 = size.height - y;
                }
                this.makeChildLayout(child, x, y, w, h);
                x += x_step;
            }
            y += y_step;
        }
    }

    private void makeChildLayout(Box child, float x, float y, float w, float h) {
        if (child == null) {
            return;
        }
        Rect mo_rect = new Rect(x, y, w, h);
        Rect rect2 = BoxOutsideComputer.computeBoxRectByMarginOutside(child, mo_rect);
        child.move(rect2.x, rect2.y, rect2.width, rect2.height);
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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public float getGapH() {
        return gapH;
    }

    public void setGapH(float gapH) {
        this.gapH = gapH;
    }

    public float getGapV() {
        return gapV;
    }

    public void setGapV(float gapV) {
        this.gapV = gapV;
    }

}
