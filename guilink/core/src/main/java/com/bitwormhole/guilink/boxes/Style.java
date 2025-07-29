package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Font;

public class Style {

    private Color backgroundColor;
    private Color foregroundColor;
    private Font font;

    private BoxSizingEnum boxSizing;
    private AlignEnum textAlign;

    // border

    private Color borderColor;
    private Float borderWidth;
    private LineStyleEnum borderStyle;

    private Color borderTopColor;
    private Float borderTopWidth;
    private LineStyleEnum borderTopStyle;

    private Color borderLeftColor;
    private Float borderLeftWidth;
    private LineStyleEnum borderLeftStyle;

    private Color borderRightColor;
    private Float borderRightWidth;
    private LineStyleEnum borderRightStyle;

    private Color borderBottomColor;
    private Float borderBottomWidth;
    private LineStyleEnum borderBottomStyle;

    // margin
    private Float margin;

    private Float marginTop;
    private Float marginLeft;
    private Float marginRight;
    private Float marginBottom;

    // padding
    private Float padding;

    private Float paddingTop;
    private Float paddingLeft;
    private Float paddingRight;
    private Float paddingBottom;

    public Style() {
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Float getMargin() {
        return margin;
    }

    public void setMargin(Float margin) {
        this.margin = margin;
    }

    public Float getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(Float marginTop) {
        this.marginTop = marginTop;
    }

    public Float getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(Float marginLeft) {
        this.marginLeft = marginLeft;
    }

    public Float getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(Float marginRight) {
        this.marginRight = marginRight;
    }

    public Float getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(Float marginBottom) {
        this.marginBottom = marginBottom;
    }

    public Float getPadding() {
        return padding;
    }

    public void setPadding(Float padding) {
        this.padding = padding;
    }

    public Float getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(Float paddingTop) {
        this.paddingTop = paddingTop;
    }

    public Float getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(Float paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public Float getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(Float paddingRight) {
        this.paddingRight = paddingRight;
    }

    public Float getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(Float paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public BoxSizingEnum getBoxSizing() {
        return boxSizing;
    }

    public void setBoxSizing(BoxSizingEnum boxSizing) {
        this.boxSizing = boxSizing;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public AlignEnum getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(AlignEnum textAlign) {
        this.textAlign = textAlign;
    }

    public Float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Float borderWidth) {
        this.borderWidth = borderWidth;
    }

    public LineStyleEnum getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(LineStyleEnum borderStyle) {
        this.borderStyle = borderStyle;
    }

    public Color getBorderTopColor() {
        return borderTopColor;
    }

    public void setBorderTopColor(Color borderTopColor) {
        this.borderTopColor = borderTopColor;
    }

    public Float getBorderTopWidth() {
        return borderTopWidth;
    }

    public void setBorderTopWidth(Float borderTopWidth) {
        this.borderTopWidth = borderTopWidth;
    }

    public LineStyleEnum getBorderTopStyle() {
        return borderTopStyle;
    }

    public void setBorderTopStyle(LineStyleEnum borderTopStyle) {
        this.borderTopStyle = borderTopStyle;
    }

    public Color getBorderLeftColor() {
        return borderLeftColor;
    }

    public void setBorderLeftColor(Color borderLeftColor) {
        this.borderLeftColor = borderLeftColor;
    }

    public Float getBorderLeftWidth() {
        return borderLeftWidth;
    }

    public void setBorderLeftWidth(Float borderLeftWidth) {
        this.borderLeftWidth = borderLeftWidth;
    }

    public LineStyleEnum getBorderLeftStyle() {
        return borderLeftStyle;
    }

    public void setBorderLeftStyle(LineStyleEnum borderLeftStyle) {
        this.borderLeftStyle = borderLeftStyle;
    }

    public Color getBorderRightColor() {
        return borderRightColor;
    }

    public void setBorderRightColor(Color borderRightColor) {
        this.borderRightColor = borderRightColor;
    }

    public Float getBorderRightWidth() {
        return borderRightWidth;
    }

    public void setBorderRightWidth(Float borderRightWidth) {
        this.borderRightWidth = borderRightWidth;
    }

    public LineStyleEnum getBorderRightStyle() {
        return borderRightStyle;
    }

    public void setBorderRightStyle(LineStyleEnum borderRightStyle) {
        this.borderRightStyle = borderRightStyle;
    }

    public Color getBorderBottomColor() {
        return borderBottomColor;
    }

    public void setBorderBottomColor(Color borderBottomColor) {
        this.borderBottomColor = borderBottomColor;
    }

    public Float getBorderBottomWidth() {
        return borderBottomWidth;
    }

    public void setBorderBottomWidth(Float borderBottomWidth) {
        this.borderBottomWidth = borderBottomWidth;
    }

    public LineStyleEnum getBorderBottomStyle() {
        return borderBottomStyle;
    }

    public void setBorderBottomStyle(LineStyleEnum borderBottomStyle) {
        this.borderBottomStyle = borderBottomStyle;
    }

}
