package com.bitwormhole.guilink.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import com.bitwormhole.guilink.boxes.AlignEnum;
import com.bitwormhole.guilink.boxes.Box;
import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.boxes.DefaultValueStyle;
import com.bitwormhole.guilink.boxes.LayoutContext;
import com.bitwormhole.guilink.boxes.LineStyleEnum;
import com.bitwormhole.guilink.boxes.PaintContext;
import com.bitwormhole.guilink.boxes.Style;
import com.bitwormhole.guilink.boxes.StyleWrapper;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.strokes.BasicStroke;
import com.bitwormhole.guilink.layouts.GridLayout;
import com.bitwormhole.guilink.widgets.View;
import com.bitwormhole.guilink.widgets.Button;

public class The9GridsView extends View {

    private final Map<Integer, MyAlignTemplate> mAlignTemplateTable;

    public The9GridsView(BoxContext bc) {
        super(bc);
        this.mAlignTemplateTable = this.makeAlignTemplateTable();
        this.onCreate();
    }

    private final void onCreate() {

        final int rows, cols, count;
        rows = 3;
        cols = 3;
        count = rows * cols;

        BoxContext bc = this.getContext();

        for (int i = 0; i < count; i++) {
            Button btn = new MyButton(bc, "btn-" + i);
            this.applyButtonStyle(btn, i);
            this.add(btn);
        }

        this.setLayout(new GridLayout(rows, cols));
        // this.setLayout(new SimpleLayout());
    }

    private void applyButtonStyle(Button btn, int index) {

        Style st = btn.getStyle();
        if (st instanceof StyleWrapper) {
            // nop
        } else {
            st = new DefaultValueStyle(st);
        }

        st.setBorderColor(Color.RED);
        st.setBorderStyle(LineStyleEnum.SOLID);
        st.setBorderWidth(3.0f);

        st.setBorderLeftStyle(LineStyleEnum.NONE);
        st.setBorderTopStyle(LineStyleEnum.NONE);

        st.setBackgroundColor(Color.WHITE);

        st.setPaddingLeft(30f);
        st.setPaddingTop(30f);
        st.setPadding(10f);

        this.applyAlignToStyle(st, index, btn);

        btn.setStyle(st);
    }

    private void applyAlignToStyle(Style st, int index, Button btn) {
        MyAlignTemplate at = this.getAlignTemplate(index);
        String txt = at.align.toString();
        st.setTextAlign(at.align);
        st.setForegroundColor(Color.GREEN);
        btn.setText(txt);
    }

    private MyAlignTemplate getAlignTemplate(int index) {
        MyAlignTemplate at = this.mAlignTemplateTable.get(index);
        if (at == null) {
            at = this.mAlignTemplateTable.get(1);
        }
        return at;
    }

    private Map<Integer, MyAlignTemplate> makeAlignTemplateTable() {

        List<MyAlignTemplate> list = new ArrayList<>();
        Map<Integer, MyAlignTemplate> table = new HashMap<>();
        int i = 0;

        list.add(new MyAlignTemplate(i++, AlignEnum.TOP_LEFT));
        list.add(new MyAlignTemplate(i++, AlignEnum.TOP));
        list.add(new MyAlignTemplate(i++, AlignEnum.TOP_RIGHT));
        list.add(new MyAlignTemplate(i++, AlignEnum.LEFT));
        list.add(new MyAlignTemplate(i++, AlignEnum.CENTER));
        list.add(new MyAlignTemplate(i++, AlignEnum.RIGHT));
        list.add(new MyAlignTemplate(i++, AlignEnum.BOTTOM_LEFT));
        list.add(new MyAlignTemplate(i++, AlignEnum.BOTTOM));
        list.add(new MyAlignTemplate(i++, AlignEnum.BOTTOM_RIGHT));

        for (MyAlignTemplate templ : list) {
            table.put(templ.index, templ);
        }

        return table;
    }

    private static class MyAlignTemplate {

        final int index;
        final AlignEnum align;

        MyAlignTemplate(int idx, AlignEnum ali) {
            this.index = idx;
            this.align = ali;
        }
    }

    private static class MyButton extends Button {

        public MyButton(BoxContext bc, String txt) {
            super(bc, txt);

            this.setClip(false);
        }

        @Override
        protected void onPaintForeground(PaintContext pc) {

            super.onPaintForeground(pc);

            pc.graphics.setColor(Color.BLUE);
            Size size1 = this.getSize();
            float w = size1.width;
            float h = size1.height;

            pc.graphics.setStroke(new BasicStroke(10f));

            pc.graphics.drawLine(0, 0, w, h);
            pc.graphics.drawLine(0, h, w, 0);
        }

        @Override
        protected void onUpdateLayout(LayoutContext lc) {
            super.onUpdateLayout(lc);
        }

    }

}
