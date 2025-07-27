package com.bitwormhole.guilink.examples.testing;

import com.bitwormhole.guilink.GuilinkCore;
import com.bitwormhole.starter4j.Starter;
import com.bitwormhole.starter4j.application.Module;
import com.bitwormhole.starter4j.application.ModuleBuilder;

final class ThisModule {

    static final String theModuleName = ThisModule.class.getName();
    static final String theModuleVersion = "0.0.0";
    static final int theModuleRevision = 1;

    public static Module module() {

        ModuleBuilder mb = new ModuleBuilder();
        mb.setName(theModuleName + "#test");
        mb.setVersion(theModuleVersion);
        mb.setRevision(theModuleRevision);

        // mb.setResources(ExportTestingRes.res());
        // mb.setComponents(TestingConfig.components());

        mb.depend(Starter.module());
        mb.depend(GuilinkCore.module());

        return mb.create();
    }

    private ThisModule() {
    }
}
