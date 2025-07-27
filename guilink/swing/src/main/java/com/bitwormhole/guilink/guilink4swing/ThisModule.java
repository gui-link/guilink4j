package com.bitwormhole.guilink.guilink4swing;

import com.bitwormhole.guilink.guilink4swing.config.GUILinkSwingConfig;
import com.bitwormhole.guilink.guilink4swing.res.m.ExportMainRes;
import com.bitwormhole.starter4j.Starter;
import com.bitwormhole.starter4j.application.ComponentRegistryFunc;
import com.bitwormhole.starter4j.application.ComponentRegistryMultiplexer;
import com.bitwormhole.starter4j.application.Module;
import com.bitwormhole.starter4j.application.ModuleBuilder;
import com.bitwormhole.starter4j.application.resources.Resources;
import com.bitwormhole.starter4j.swing.SwingFrameManager;

final class ThisModule {

    private static final String theModuleName = GUILinkForSwing.class.getName();
    private static final String theModuleVersion = "0.0.0";
    private static final int theModuleRevision = 1;

    public static Module moduleLib() {

        ModuleBuilder mb = new ModuleBuilder();
        mb.setName(theModuleName + "#lib");
        mb.setVersion(theModuleVersion);
        mb.setRevision(theModuleRevision);

        mb.setResources(myResources());
        mb.setComponents(myComponents());

        mb.depend(Starter.module());

        return mb.create();
    }

    private static Resources myResources() {
        return ExportMainRes.res();
    }

    private static ComponentRegistryFunc myComponents() {
        ComponentRegistryMultiplexer multi = new ComponentRegistryMultiplexer();
        multi.add(GUILinkSwingConfig.components());
        return multi.multiplex();
    }

}
