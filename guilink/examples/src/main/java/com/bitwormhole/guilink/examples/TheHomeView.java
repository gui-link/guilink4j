package com.bitwormhole.guilink.examples;

import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.boxes.BoxStateEnum;
import com.bitwormhole.guilink.boxes.PaintContext;
import com.bitwormhole.guilink.events.MouseEvent;
import com.bitwormhole.guilink.layouts.LinearLayout;
import com.bitwormhole.guilink.widgets.Button;
import com.bitwormhole.guilink.widgets.Label;
import com.bitwormhole.guilink.widgets.View;

public class TheHomeView extends View {

    public TheHomeView(BoxContext bc) {
        super(bc);
        this.onCreate();
    }

    private void onCreate() {

        this.setLayout(new LinearLayout(LinearLayout.Direction.VERTICAL));

        BoxContext bc = this.getContext();
        Label label = new Label(bc, "hello: " + this);
        label.setWeight(1);
        this.add(label);

        for (int i = 0; i < 5; i++) {
            Button btn = new MyButton(bc, "btn-" + i);
            btn.setWeight(1);
            this.add(btn);
        }

    }

    class MyButton extends Button {

        MyButton(BoxContext bc, String txt) {
            super(bc, txt);
        }

        @Override
        protected void onMouseHovered(MouseEvent event) {
            super.onMouseHovered(event);
        }

        @Override
        protected void onMousePressed(MouseEvent event) {
            super.onMousePressed(event);
        }

        @Override
        protected void onPaintForeground(PaintContext pc) {

            BoxStateEnum sta = this.getState();
            if (BoxStateEnum.HOVERED.equals(sta)) {
                pc.hashCode();
            }

            super.onPaintForeground(pc);
        }

    }

    public void addButton(Button btn) {
        this.add(btn);
    }
}
