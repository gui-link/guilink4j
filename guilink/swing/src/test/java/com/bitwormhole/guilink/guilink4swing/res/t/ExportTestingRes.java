package com.bitwormhole.guilink.guilink4swing.res.t;

import java.util.List;

import com.bitwormhole.starter4j.application.resources.EmbeddedRes;
import com.bitwormhole.starter4j.application.resources.EmbeddedResources;
import com.bitwormhole.starter4j.application.resources.Resources;

public class ExportTestingRes {

    public static Resources res() {
        List<EmbeddedRes> list = EmbeddedResMain.all();
        return EmbeddedResources.create(list);
    }

}
