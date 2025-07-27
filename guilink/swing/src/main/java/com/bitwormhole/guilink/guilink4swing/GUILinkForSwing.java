package com.bitwormhole.guilink.guilink4swing;

import com.bitwormhole.starter4j.application.Module;

public final class GUILinkForSwing {

    private GUILinkForSwing() {
    }

    public static Module module() {
        return ThisModule.moduleLib();
    }

}
