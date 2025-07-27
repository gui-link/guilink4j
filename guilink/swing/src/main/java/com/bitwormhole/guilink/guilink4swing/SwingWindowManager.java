package com.bitwormhole.guilink.guilink4swing;

import com.bitwormhole.guilink.desktops.Desktop;
import com.bitwormhole.guilink.desktops.Window;
import com.bitwormhole.guilink.desktops.WindowContext;
import com.bitwormhole.guilink.desktops.WindowManager;
import com.bitwormhole.guilink.geometries.Rect;

public class SwingWindowManager implements WindowManager {

    private final WindowContext context;

    public SwingWindowManager(WindowContext ctx) {
        this.context = ctx;
    }

    @Override
    public Window[] windows() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'windows'");
    }

    @Override
    public Desktop[] desktops() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desktops'");
    }

    @Override
    public Window createNewWindow(Rect rect) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createNewWindow'");
    }

}
