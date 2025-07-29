package com.bitwormhole.guilink.examples;

import com.bitwormhole.guilink.boxes.BoxStateEnum;
import com.bitwormhole.guilink.boxes.PaintContext;
import com.bitwormhole.guilink.layouts.LinearLayout;
import com.bitwormhole.guilink.widgets.Button;
import com.bitwormhole.guilink.widgets.Label;
import com.bitwormhole.guilink.widgets.View;

public class TheHomeView extends View {

    public TheHomeView() {
        this.onCreate();
    }

    private void onCreate() {

        this.setLayout(new LinearLayout(LinearLayout.Direction.VERTICAL));

        Label label = new Label("hello: " + this);
        label.setWeight(1);
        this.add(label);

        for (int i = 0; i < 5; i++) {
            Button btn = new MyButton("btn-" + i);
            btn.setWeight(1);
            this.add(btn);
        }

    }

    class MyButton extends Button {

        MyButton(String txt) {
            super(txt);
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
}
