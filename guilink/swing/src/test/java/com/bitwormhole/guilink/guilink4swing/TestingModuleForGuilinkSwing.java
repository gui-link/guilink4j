package com.bitwormhole.guilink.guilink4swing;

import com.bitwormhole.guilink.guilink4swing.config.t.TestingConfig;
import com.bitwormhole.guilink.guilink4swing.res.t.ExportTestingRes;
import com.bitwormhole.starter4j.Starter;
import com.bitwormhole.starter4j.application.Module;
import com.bitwormhole.starter4j.application.ModuleBuilder;

final class TestingModuleForGuilinkSwing {

    static final String theModuleName = TestingModuleForGuilinkSwing.class.getName();
    static final String theModuleVersion = "0.0.0";
    static final int theModuleRevision = 1;

    public static Module module() {

        ModuleBuilder mb = new ModuleBuilder();
        mb.setName(theModuleName + "#test");
        mb.setVersion(theModuleVersion);
        mb.setRevision(theModuleRevision);

        mb.setResources(ExportTestingRes.res());
        mb.setComponents(TestingConfig.components());

        mb.depend(Starter.module());
        mb.depend(GUILinkForSwing.module());

        return mb.create();
    }

}
