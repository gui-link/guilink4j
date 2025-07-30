package com.bitwormhole.guilink.boxes;

import java.util.ArrayList;
import java.util.List;

import com.bitwormhole.guilink.layouts.SimpleLayout;

public abstract class Container extends ContainerAbstract {

    private Layout layout;
    private List<Box> childrenForLayout; // 缓存用于排版的子元素
    private final List<Box> children;

    public Container(BoxContext bc) {
        super(bc);
        this.layout = new SimpleLayout();
        this.children = new ArrayList<>();
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public List<Box> getChildren() {
        return children;
    }

    public List<Box> getChildrenForLayout() {
        List<Box> list = this.childrenForLayout;
        if (list == null) {
            list = this.createChildrenListForLayout();
            this.childrenForLayout = list;
        }
        return list;
    }

    public void setChildrenForLayout(List<Box> childrenForLayout) {
        this.childrenForLayout = childrenForLayout;
    }

}
