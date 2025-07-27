package com.bitwormhole.guilink.guilink4swing;

import com.bitwormhole.guilink.desktops.WindowContext;
import com.bitwormhole.guilink.desktops.WindowSystem;
import com.bitwormhole.guilink.desktops.WindowSystemImplementation;

public class SwingWindowSystem implements WindowSystem {

    private final WindowContext wc;

    public SwingWindowSystem(WindowSystemImplementation impl) {

        WindowContext ctx = new WindowContext();

        ctx.setWindowManager(new SwingWindowManager(ctx));
        ctx.setWindowSystem(this);
        ctx.setWindowSystemImplementation(impl);

        this.wc = ctx;
    }

    @Override
    public WindowSystemImplementation implementation() {
        return this.wc.getWindowSystemImplementation();
    }

}
