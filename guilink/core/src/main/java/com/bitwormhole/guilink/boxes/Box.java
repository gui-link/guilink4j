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

    private BoxOutside outside;

    private Style style;
    private StyleCache styleCache;
    private StyleLoader styleLoader;
    private StyleLoader mInnerStyleLoader; // 用于内部加载样式, 不公开给外部使用

    private BoxStateEnum state;
    private boolean present; // 是否出现在渲染列表中
    private boolean clip; // 是否对绘图区域进行裁减
    private boolean enabled;
    private boolean selected; // 是否已被选中
    private boolean acceptHovering; // 是否可以响应 mouse-hovering 事件

    private int z; // 显示顺序
    private int index; // dom 顺序
    private int weight; // 排版所占的比重
    private int layoutPosition; // 用于排版的位置
    private int id;
    private String name;

    public Box(BoxContext bc) {
        this.clip = true;
        this.present = true;
        this.enabled = true;
        this.context = bc;
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
        return this.getStyleWithInnerLoader(null);
    }

    /***
     * 获取与指定的状态对应的样式
     */
    public Style getStyle(BoxStateEnum _state) {
        return this.getStyleWithInnerLoader(_state);
    }

    private Style getStyleWithInnerLoader(BoxStateEnum _state) {
        StyleLoader loader = this.mInnerStyleLoader;
        if (loader == null) {
            loader = new MyInnerStyleLoader();
            this.mInnerStyleLoader = loader;
        }
        StyleSelector sel = null;
        if (_state != null) {
            sel = new StyleSelector();
            sel.setState(_state);
            sel.setType(this.getClass());
        }
        return loader.load(sel);
    }

    private class MyInnerStyleLoader implements StyleLoader {

        @Override
        public Style load(StyleSelector sel) {

            final Box box1 = Box.this;
            BoxStateEnum state1 = box1.getState();
            StyleCache cache1 = box1.styleCache;
            StyleLoader loader1 = box1.styleLoader;

            state1 = this.prepareState(state1);
            cache1 = this.prepareCache(cache1);
            loader1 = this.prepareLoader(loader1);

            if (loader1 == null) {
                return null;
            }

            // load from cache
            Style style1 = cache1.getStyle(state1);
            if (style1 != null) {
                return style1;
            }

            // load from source
            if (sel == null) {
                sel = new StyleSelector();
                sel.setType(box1.getClass());
                sel.setState(state1);
            }
            style1 = loader1.load(sel);

            // put to cache
            cache1.put(state1, style1);

            style1 = GuilinkGetters.notNull(style1);
            return style1;
        }

        private BoxStateEnum prepareState(BoxStateEnum state1) {
            if (state1 != null) {
                return state1;
            }
            return BoxStateEnum.NORMAL;
        }

        private StyleLoader prepareLoader(StyleLoader loader) {
            if (loader != null) {
                return loader;
            }
            final Box box1 = Box.this;
            final BoxContext ctx = box1.context;
            if (ctx == null) {
                return null;
            }
            loader = ctx.getTheme();
            if (loader == null) {
                throw new RuntimeException("no theme");
            }
            box1.styleLoader = loader;
            return loader;
        }

        private StyleCache prepareCache(StyleCache cache1) {
            if (cache1 != null) {
                return cache1;
            }
            cache1 = new StyleCache();
            Box.this.styleCache = cache1;
            return cache1;
        }
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

    public StyleCache getStyleCache() {
        StyleCache sc = this.styleCache;
        if (sc == null) {
            sc = new StyleCache();
            this.styleCache = sc;
        }
        return sc;
    }

    public void setStyleCache(StyleCache styleCache) {
        this.styleCache = styleCache;
    }

    public StyleLoader getStyleLoader() {
        return styleLoader;
    }

    public void setStyleLoader(StyleLoader styleLoader) {
        this.styleLoader = styleLoader;
    }

    public BoxStateEnum getState() {
        BoxStateEnum st = this.state;
        if (st == null) {
            return this.computeCurrentState();
        } else if (st.equals(BoxStateEnum.AUTO)) {
            return this.computeCurrentState();
        }
        return state;
    }

    public void setState(BoxStateEnum state) {
        this.state = state;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isAcceptHovering() {
        return acceptHovering;
    }

    public void setAcceptHovering(boolean acceptHovering) {
        this.acceptHovering = acceptHovering;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BoxOutside getOutside() {
        BoxOutside bo = this.outside;
        if (bo == null) {
            bo = BoxOutsideComputer.compute(this, bo);
            this.outside = bo;
        }
        return bo;
    }

    public void setOutside(BoxOutside outside) {
        this.outside = outside;
    }

}
