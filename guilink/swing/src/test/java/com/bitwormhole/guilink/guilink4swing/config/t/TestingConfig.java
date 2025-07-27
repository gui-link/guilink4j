package com.bitwormhole.guilink.guilink4swing.config.t;

import com.bitwormhole.starter4j.application.ComponentRegistryFunc;
import com.bitwormhole.starter4j.application.ComponentRegistryMultiplexer;

public class TestingConfig {

    public static ComponentRegistryFunc components() {

        ComponentRegistryMultiplexer multi = new ComponentRegistryMultiplexer();
        multi.add(TestingFramesConfig.registerSelf());
        return multi.multiplex();

    }

}
