package com.bitwormhole.guilink.boxes;

import java.util.List;

public class StyleSelector {

    private Class<?> type;
    private List<Class<?>> typeStack;
    private BoxStateEnum state;
    private String expression;
    private Style older;

    public StyleSelector() {
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public List<Class<?>> getTypeStack() {
        return typeStack;
    }

    public void setTypeStack(List<Class<?>> typeStack) {
        this.typeStack = typeStack;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public BoxStateEnum getState() {
        return state;
    }

    public void setState(BoxStateEnum state) {
        this.state = state;
    }

    public Style getOlder() {
        return older;
    }

    public void setOlder(Style older) {
        this.older = older;
    }

}
