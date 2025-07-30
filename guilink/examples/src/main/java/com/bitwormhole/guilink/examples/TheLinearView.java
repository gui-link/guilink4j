package com.bitwormhole.guilink.examples;

import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.layouts.LinearLayout;
import com.bitwormhole.guilink.widgets.Button;
import com.bitwormhole.guilink.widgets.View;

public class TheLinearView extends View {

    private LinearLayout.Direction mDirection;

    public TheLinearView(BoxContext bc, LinearLayout.Direction dir) {
        super(bc);
        this.mDirection = dir;
        this.onCreate();
    }

    private void onCreate() {

        this.setLayout(new LinearLayout(this.mDirection));

        this.addExampleChildrenToView(this);
    }

    private void addExampleChildrenToView(View view) {

        BoxContext bc = this.getContext();
        Button btn = new Button(bc);

        this.add(btn);

    }

}
