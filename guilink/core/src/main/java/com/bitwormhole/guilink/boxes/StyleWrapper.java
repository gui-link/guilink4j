package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Font;

public class StyleWrapper extends Style {

    private final Style inner;

    public StyleWrapper(Style in) {
        if (in == null) {
            in = new Style();
        }
        this.inner = in;
    }

    @Override
    public Color getBackgroundColor() {
        return inner.getBackgroundColor();
    }

    @Override
    public Color getBorderBottomColor() {
        return inner.getBorderBottomColor();
    }

    @Override
    public LineStyleEnum getBorderBottomStyle() {
        return inner.getBorderBottomStyle();
    }

    @Override
    public Float getBorderBottomWidth() {
        return inner.getBorderBottomWidth();
    }

    @Override
    public Color getBorderColor() {
        return inner.getBorderColor();
    }

    @Override
    public Color getBorderLeftColor() {
        return inner.getBorderLeftColor();
    }

    @Override
    public LineStyleEnum getBorderLeftStyle() {
        return inner.getBorderLeftStyle();
    }

    @Override
    public Float getBorderLeftWidth() {
        return inner.getBorderLeftWidth();
    }

    @Override
    public Color getBorderRightColor() {
        return inner.getBorderRightColor();
    }

    @Override
    public LineStyleEnum getBorderRightStyle() {
        return inner.getBorderRightStyle();
    }

    @Override
    public Float getBorderRightWidth() {
        return inner.getBorderRightWidth();
    }

    @Override
    public LineStyleEnum getBorderStyle() {
        return inner.getBorderStyle();
    }

    @Override
    public Color getBorderTopColor() {
        return inner.getBorderTopColor();
    }

    @Override
    public LineStyleEnum getBorderTopStyle() {
        return inner.getBorderTopStyle();
    }

    @Override
    public Float getBorderTopWidth() {
        return inner.getBorderTopWidth();
    }

    @Override
    public Float getBorderWidth() {
        return inner.getBorderWidth();
    }

    @Override
    public BoxSizingEnum getBoxSizing() {
        return inner.getBoxSizing();
    }

    @Override
    public Font getFont() {
        return inner.getFont();
    }

    @Override
    public Color getForegroundColor() {
        return inner.getForegroundColor();
    }

    @Override
    public Float getMargin() {
        return inner.getMargin();
    }

    @Override
    public Float getMarginBottom() {
        return inner.getMarginBottom();
    }

    @Override
    public Float getMarginLeft() {
        return inner.getMarginLeft();
    }

    @Override
    public Float getMarginRight() {
        return inner.getMarginRight();
    }

    @Override
    public Float getMarginTop() {
        return inner.getMarginTop();
    }

    @Override
    public Float getPadding() {
        return inner.getPadding();
    }

    @Override
    public Float getPaddingBottom() {
        return inner.getPaddingBottom();
    }

    @Override
    public Float getPaddingLeft() {
        return inner.getPaddingLeft();
    }

    @Override
    public Float getPaddingRight() {
        return inner.getPaddingRight();
    }

    @Override
    public Float getPaddingTop() {
        return inner.getPaddingTop();
    }

    @Override
    public AlignEnum getTextAlign() {
        return inner.getTextAlign();
    }

    @Override
    public void setBackgroundColor(Color backgroundColor) {
        inner.setBackgroundColor(backgroundColor);
    }

    @Override
    public void setBorderBottomColor(Color borderBottomColor) {
        inner.setBorderBottomColor(borderBottomColor);
    }

    @Override
    public void setBorderBottomStyle(LineStyleEnum borderBottomStyle) {
        inner.setBorderBottomStyle(borderBottomStyle);
    }

    @Override
    public void setBorderBottomWidth(Float borderBottomWidth) {
        inner.setBorderBottomWidth(borderBottomWidth);
    }

    @Override
    public void setBorderColor(Color borderColor) {
        inner.setBorderColor(borderColor);
    }

    @Override
    public void setBorderLeftColor(Color borderLeftColor) {
        inner.setBorderLeftColor(borderLeftColor);
    }

    @Override
    public void setBorderLeftStyle(LineStyleEnum borderLeftStyle) {
        inner.setBorderLeftStyle(borderLeftStyle);
    }

    @Override
    public void setBorderLeftWidth(Float borderLeftWidth) {
        inner.setBorderLeftWidth(borderLeftWidth);
    }

    @Override
    public void setBorderRightColor(Color borderRightColor) {
        inner.setBorderRightColor(borderRightColor);
    }

    @Override
    public void setBorderRightStyle(LineStyleEnum borderRightStyle) {
        inner.setBorderRightStyle(borderRightStyle);
    }

    @Override
    public void setBorderRightWidth(Float borderRightWidth) {
        inner.setBorderRightWidth(borderRightWidth);
    }

    @Override
    public void setBorderStyle(LineStyleEnum borderStyle) {
        inner.setBorderStyle(borderStyle);
    }

    @Override
    public void setBorderTopColor(Color borderTopColor) {
        inner.setBorderTopColor(borderTopColor);
    }

    @Override
    public void setBorderTopStyle(LineStyleEnum borderTopStyle) {
        inner.setBorderTopStyle(borderTopStyle);
    }

    @Override
    public void setBorderTopWidth(Float borderTopWidth) {
        inner.setBorderTopWidth(borderTopWidth);
    }

    @Override
    public void setBorderWidth(Float borderWidth) {
        inner.setBorderWidth(borderWidth);
    }

    @Override
    public void setBoxSizing(BoxSizingEnum boxSizing) {
        inner.setBoxSizing(boxSizing);
    }

    @Override
    public void setFont(Font font) {
        inner.setFont(font);
    }

    @Override
    public void setForegroundColor(Color foregroundColor) {
        inner.setForegroundColor(foregroundColor);
    }

    @Override
    public void setMargin(Float margin) {
        inner.setMargin(margin);
    }

    @Override
    public void setMarginBottom(Float marginBottom) {
        inner.setMarginBottom(marginBottom);
    }

    @Override
    public void setMarginLeft(Float marginLeft) {
        inner.setMarginLeft(marginLeft);
    }

    @Override
    public void setMarginRight(Float marginRight) {
        inner.setMarginRight(marginRight);
    }

    @Override
    public void setMarginTop(Float marginTop) {
        inner.setMarginTop(marginTop);
    }

    @Override
    public void setPadding(Float padding) {
        inner.setPadding(padding);
    }

    @Override
    public void setPaddingBottom(Float paddingBottom) {
        inner.setPaddingBottom(paddingBottom);
    }

    @Override
    public void setPaddingLeft(Float paddingLeft) {
        inner.setPaddingLeft(paddingLeft);
    }

    @Override
    public void setPaddingRight(Float paddingRight) {
        inner.setPaddingRight(paddingRight);
    }

    @Override
    public void setPaddingTop(Float paddingTop) {
        inner.setPaddingTop(paddingTop);
    }

    @Override
    public void setTextAlign(AlignEnum textAlign) {
        inner.setTextAlign(textAlign);
    }

    @Override
    public String toString() {
        return inner.toString();
    }

}
