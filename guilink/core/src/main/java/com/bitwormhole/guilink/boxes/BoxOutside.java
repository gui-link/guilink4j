package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.geometries.Rect;

/************************************
 * BoxOutside 表示 box 模型的外边沿
 */
public class BoxOutside {

    private Rect margin;
    private Rect border; // = box-sizing:border-box
    private Rect padding;
    private Rect content; // = box-sizing:content-box

    private BoxSizingEnum sizing; // the box-sizing

    public BoxOutside() {
    }

    public Rect getMargin() {
        return margin;
    }

    public void setMargin(Rect margin) {
        this.margin = margin;
    }

    public Rect getBorder() {
        return border;
    }

    public void setBorder(Rect border) {
        this.border = border;
    }

    public Rect getPadding() {
        return padding;
    }

    public void setPadding(Rect padding) {
        this.padding = padding;
    }

    public Rect getContent() {
        return content;
    }

    public void setContent(Rect content) {
        this.content = content;
    }

    public BoxSizingEnum getSizing() {
        return sizing;
    }

    public void setSizing(BoxSizingEnum sizing) {
        this.sizing = sizing;
    }

}
