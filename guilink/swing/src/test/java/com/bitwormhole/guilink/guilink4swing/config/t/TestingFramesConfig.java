package com.bitwormhole.guilink.guilink4swing.config.t;

import java.util.ArrayList;
import java.util.List;

import com.bitwormhole.guilink.guilink4swing.frames.ExampleFrame;
import com.bitwormhole.guilink.guilink4swing.frames.HomeFrame;
import com.bitwormhole.guilink.guilink4swing.frames.The10kGridsFrame;
import com.bitwormhole.starter4j.application.ComponentRegistryFunc;
import com.bitwormhole.starter4j.application.ComponentTemplate;
import com.bitwormhole.starter4j.application.ComponentTemplate.RegistrationT;
import com.bitwormhole.starter4j.swing.FrameRegistration;
import com.bitwormhole.starter4j.swing.FrameRegistry;

final class TestingFramesConfig implements FrameRegistry {

    private TestingFramesConfig() {
    }

    static ComponentRegistryFunc registerSelf() {
        return (cr) -> {
            ComponentTemplate template = new ComponentTemplate(cr);
            RegistrationT<TestingFramesConfig> rt = template.component(TestingFramesConfig.class);
            rt.setId(TestingFramesConfig.class);
            rt.addClass("jframe");
            rt.addClass(TestingFramesConfig.class);
            rt.addClass(FrameRegistry.class);
            rt.onNew(() -> {
                return new TestingFramesConfig();
            });
            rt.register();
        };
    }

    @Override
    public List<FrameRegistration> listRegistrations(List<FrameRegistration> arg0) {
        List<FrameRegistration> list = new ArrayList<>();

        list.add(ExampleFrame.registration());
        list.add(HomeFrame.registration());
        list.add(The10kGridsFrame.registration());

        return list;
    }

}
