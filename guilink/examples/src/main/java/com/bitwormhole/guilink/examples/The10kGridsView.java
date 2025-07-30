package com.bitwormhole.guilink.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.boxes.BoxOutside;
import com.bitwormhole.guilink.boxes.LayoutContext;
import com.bitwormhole.guilink.boxes.PaintContext;
import com.bitwormhole.guilink.boxes.Style;
import com.bitwormhole.guilink.layouts.GridLayout;
import com.bitwormhole.guilink.widgets.View;
import com.bitwormhole.guilink.widgets.Button;

public class The10kGridsView extends View {

    static final Logger logger = LoggerFactory.getLogger(The10kGridsView.class);

    public The10kGridsView(BoxContext bc) {
        super(bc);
        this.onCreate();
    }

    private final void onCreate() {

        final int rows, cols, count;
        rows = 30;
        cols = 100;
        count = rows * cols;

        BoxContext bc = this.getContext();

        for (int i = 0; i < count; i++) {
            Button btn = new Button(bc, "" + i);
            this.applyButtonStyle(btn);
            this.add(btn);
        }

        this.setLayout(new GridLayout(rows, cols));
    }

    private void applyButtonStyle(Button btn) {
        Style sty = btn.getStyle();

        sty.setBorderWidth(1f);
        // btn.setStyle(sty);
    }

    @Override
    protected void onPaint(PaintContext pc) {
        super.onPaint(pc);

        BoxOutside out = this.getOutside();
        logger.info(out + "");

    }

    @Override
    protected void onUpdateLayout(LayoutContext lc) {
        super.onUpdateLayout(lc);
        this.setOutside(null);
    }
}
