package com.bitwormhole.guilink.examples;

import com.bitwormhole.guilink.layouts.LinearLayout;
import com.bitwormhole.guilink.widgets.Button;
import com.bitwormhole.guilink.widgets.View;

public class TheLinearView extends View {

    private LinearLayout.Direction mDirection;

    public TheLinearView(LinearLayout.Direction dir) {
        this.mDirection = dir;
        this.onCreate();
    }

    private void onCreate() {

        this.setLayout(new LinearLayout(this.mDirection));

        this.addExampleChildrenToView(this);
    }

    private void addExampleChildrenToView(View view) {

        Button btn = new Button();

        this.add(btn);

    }

}
