package com.bitwormhole.guilink.guilink4swing.config;

import com.bitwormhole.starter4j.application.ComponentRegistryFunc;
import com.bitwormhole.starter4j.application.ComponentRegistryMultiplexer;

public final class GUILinkSwingConfig {

    public static ComponentRegistryFunc components() {
        ComponentRegistryMultiplexer multi = new ComponentRegistryMultiplexer();
        // multi.add(GUILinkSwingConfig.components());
        return multi.multiplex();
    }

}
