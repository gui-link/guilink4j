package com.bitwormhole.guilink;

import com.bitwormhole.starter4j.Starter;
import com.bitwormhole.starter4j.application.Module;
import com.bitwormhole.starter4j.application.ModuleBuilder;

final class ThisModule {

    static final String theModuleName = GuilinkCore.class.getName();
    static final String theModuleVersion = "0.0.0";
    static final int theModuleRevision = 1;

    public static Module module() {

        ModuleBuilder mb = new ModuleBuilder();
        mb.setName(theModuleName + "#core");
        mb.setVersion(theModuleVersion);
        mb.setRevision(theModuleRevision);

        // mb.setResources(ExportTestingRes.res());
        // mb.setComponents(TestingConfig.components());

        mb.depend(Starter.module());

        return mb.create();
    }

    private ThisModule() {
    }
}
