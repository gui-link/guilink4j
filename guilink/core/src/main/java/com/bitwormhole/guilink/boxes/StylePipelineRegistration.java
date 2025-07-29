package com.bitwormhole.guilink.boxes;

public class StylePipelineRegistration {

    private Class<?> targetType;
    private String name;
    private StylePipeline pipeline;
    private BoxStateEnum state;

    public StylePipelineRegistration() {
    }

    public StylePipelineRegistration(StylePipelineRegistration src) {
        if (src == null) {
            return;
        }

        this.name = src.name;
        this.pipeline = src.pipeline;
        this.state = src.state;
        this.targetType = src.targetType;
    }

    public Class<?> getTargetType() {
        return targetType;
    }

    public void setTargetType(Class<?> targetType) {
        this.targetType = targetType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StylePipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(StylePipeline pipeline) {
        this.pipeline = pipeline;
    }

    public BoxStateEnum getState() {
        return state;
    }

    public void setState(BoxStateEnum state) {
        this.state = state;
    }

}
