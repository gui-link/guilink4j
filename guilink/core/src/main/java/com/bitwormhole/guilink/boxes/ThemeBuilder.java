package com.bitwormhole.guilink.boxes;

import java.util.ArrayList;
import java.util.List;
import com.bitwormhole.guilink.themes.DefaultValueThemeWrapper;
import com.bitwormhole.guilink.themes.NormalBasedThemeWrapper;
import com.bitwormhole.guilink.themes.ThemeImpl;

public class ThemeBuilder {

    private final List<StylePipelineRegistration> registrations;

    public ThemeBuilder() {
        this.registrations = new ArrayList<>();
    }

    public ThemeBuilder add(StylePipelineRegistration reg) {
        if (reg == null) {
            return this;
        }
        reg = new StylePipelineRegistration(reg);
        if (reg.getTargetType() == null) {
            return this;
        }
        if (reg.getPipeline() == null) {
            return this;
        }
        this.registrations.add(reg);
        return this;
    }

    public ThemeBuilder add(StylePipelineRegistry reg) {
        if (reg == null) {
            return this;
        }
        StylePipelineRegistration[] src = reg.listStylePipelineRegistrations();
        if (src == null) {
            return this;
        }
        for (StylePipelineRegistration r2 : src) {
            this.add(r2);
        }
        return this;
    }

    public Theme create() {
        List<StylePipelineRegistration> src = this.registrations;
        Theme th = new ThemeImpl(src);

        // do wrap
        th = new NormalBasedThemeWrapper(th);
        th = new DefaultValueThemeWrapper(th);

        return th;
    }

}
