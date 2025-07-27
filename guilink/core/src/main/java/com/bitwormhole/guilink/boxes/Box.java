package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.utils.GuilinkGetters;

public abstract class Box extends BoxAbstract {

    private Container parent;
    private BoxContext context;

    private Size size; // 实际的大小
    private Size minSize; // 最大尺寸
    private Size maxSize; // 最小尺寸
    private Size wantSize; // 建议排版的大小

    private Point location;
    private Point locationAtCanvas;

    private Style style;

    private boolean present; // 是否出现在渲染列表中
    private boolean clip; // 是否对绘图区域进行裁减

    private int z; // 显示顺序
    private int index; // dom 顺序
    private int weight; // 排版所占的比重
    private int layoutPosition; // 用于排版的位置
    private String name;

    public Box() {
        this.clip = true;
        this.present = true;
    }

    public Size getSize() {
        Size s = this.size;
        if (s == null) {
            s = GuilinkGetters.notNull(s);
            this.size = s;
        }
        return s;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Point getLocation() {
        Point pt = this.location;
        if (pt == null) {
            pt = GuilinkGetters.notNull(pt);
            this.location = pt;
        }
        return pt;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Point getLocationAtCanvas() {
        Point pt = this.locationAtCanvas;
        if (pt == null) {
            pt = this.computeLocationAtCanvas();
            this.locationAtCanvas = pt;
        }
        return pt;
    }

    public void setLocationAtCanvas(Point locationAtCanvas) {
        this.locationAtCanvas = locationAtCanvas;
    }

    public Style getStyle() {
        Style st = this.style;
        if (st == null) {
            st = GuilinkGetters.notNull(st);
            this.style = st;
        }
        return st;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Size getMinSize() {
        return GuilinkGetters.notNull(minSize);
    }

    public void setMinSize(Size minSize) {
        this.minSize = minSize;
    }

    public Size getMaxSize() {
        return GuilinkGetters.notNull(maxSize);
    }

    public void setMaxSize(Size maxSize) {
        this.maxSize = maxSize;
    }

    public Size getWantSize() {
        return GuilinkGetters.notNull(wantSize);
    }

    public void setWantSize(Size wantSize) {
        this.wantSize = wantSize;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLayoutPosition() {
        return layoutPosition;
    }

    public void setLayoutPosition(int layoutPosition) {
        this.layoutPosition = layoutPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Container getParent() {
        return parent;
    }

    public void setParent(Container parent) {
        this.parent = parent;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public BoxContext getContext() {
        return context;
    }

    public void setContext(BoxContext context) {
        this.context = context;
    }

    public boolean isClip() {
        return clip;
    }

    public void setClip(boolean clip) {
        this.clip = clip;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
