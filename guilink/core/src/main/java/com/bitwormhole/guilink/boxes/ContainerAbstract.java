package com.bitwormhole.guilink.boxes;

import java.util.List;

public abstract class ContainerAbstract extends BoxEntity {

    ////////////////////////////////////////////////////////////////////////////
    // public

    public abstract void add(Box child);

    public abstract void add(Box child, int layout_pos);

    /***
     * 更新容器中的子元素的排版
     */
    public abstract void updateLayoutForChildren(LayoutContext lc);

    /***
     * 获取经过排序的子元素列表, 一般用于排版,渲染等用途
     */
    public abstract List<Box> getChildrenForLayout();

    ////////////////////////////////////////////////////////////////////////////
    // protected

    protected abstract void onPaintChildren(PaintContext pc);

    protected abstract void onUpdateLayoutForChildren(LayoutContext lc);

    protected abstract List<Box> createChildrenListForLayout();

}
