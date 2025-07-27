package com.bitwormhole.guilink.examples;

import com.bitwormhole.guilink.boxes.Box;
import com.bitwormhole.guilink.boxes.LayoutContext;
import com.bitwormhole.guilink.boxes.LineStyleEnum;
import com.bitwormhole.guilink.boxes.PaintContext;
import com.bitwormhole.guilink.boxes.Style;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.strokes.BasicStroke;
import com.bitwormhole.guilink.layouts.GridLayout;
import com.bitwormhole.guilink.widgets.View;
import com.bitwormhole.guilink.widgets.Button;

public class The9GridsView extends View {

    public The9GridsView() {
        this.onCreate();
    }

    private final void onCreate() {

        final int rows, cols, count;
        rows = 3;
        cols = 3;
        count = rows * cols;

        for (int i = 0; i < count; i++) {
            Button btn = new MyButton("btn-" + i);
            this.applyButtonStyle(btn);
            this.add(btn);
        }

        this.setLayout(new GridLayout(rows, cols));
        // this.setLayout(new SimpleLayout());
    }

    private void applyButtonStyle(Box box) {

        Style st = box.getStyle();

        st.setBorderColor(Color.RED);
        st.setBorderStyle(LineStyleEnum.SOLID);
        st.setBorderWidth(3.0f);

        st.setBorderLeftStyle(LineStyleEnum.NONE);
        st.setBorderTopStyle(LineStyleEnum.NONE);

        st.setBackgroundColor(Color.WHITE);

        box.setStyle(st);
    }

    private static class MyButton extends Button {

        public MyButton(String txt) {
            super(txt);

            this.setClip(false);
        }

        @Override
        protected void onPaintForeground(PaintContext pc) {

            super.onPaintForeground(pc);

            pc.graphics.setColor(Color.BLUE);
            Size size1 = this.getSize();
            float w = size1.width;
            float h = size1.height;

            pc.graphics.setStroke(new BasicStroke(1f));

            pc.graphics.drawLine(0, 0, w, h);
            pc.graphics.drawLine(0, h, w, 0);
        }

        @Override
        protected void onUpdateLayout(LayoutContext lc) {
            super.onUpdateLayout(lc);
        }

    }

}
