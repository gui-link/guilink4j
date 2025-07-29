package com.bitwormhole.guilink.boxes;

public class StyleCache {

    private Style normal;
    private Style hovered;
    private Style disabled;
    private Style highlight;
    private Style selected;
    private Style checked;
    private Style pressed;

    public StyleCache() {
    }

    public Style getNormal() {
        return normal;
    }

    public void setNormal(Style normal) {
        this.normal = normal;
    }

    public Style getDisabled() {
        return disabled;
    }

    public void setDisabled(Style disabled) {
        this.disabled = disabled;
    }

    public Style getSelected() {
        return selected;
    }

    public void setSelected(Style selected) {
        this.selected = selected;
    }

    public Style getHighlight() {
        return highlight;
    }

    public void setHighlight(Style highlight) {
        this.highlight = highlight;
    }

    public void put(BoxStateEnum state, Style style) {
        if (state == null || style == null) {
            return;
        }
        switch (state) {
            case NORMAL:
                this.normal = style;
                break;
            case HOVERED:
                this.hovered = style;
                break;
            case CHECKED:
                this.checked = style;
                break;
            case DISABLED:
                this.disabled = style;
                break;
            case HIGHLIGHT:
                this.highlight = style;
                break;
            case SELECTED:
                this.selected = style;
                break;
            case PRESSED:
                this.pressed = style;
                break;
            default:
                break;
        }
    }

    public Style getStyle(BoxStateEnum state) {

        if (state == null) {
            return this.normal;
        }

        switch (state) {
            case NORMAL:
                return this.normal;
            case HOVERED:
                return this.hovered;
            case CHECKED:
                return this.checked;
            case DISABLED:
                return this.disabled;
            case HIGHLIGHT:
                return this.highlight;
            case SELECTED:
                return this.selected;
            case PRESSED:
                return this.pressed;
            default:
                break;
        }

        return this.normal;
    }

    public Style getChecked() {
        return checked;
    }

    public void setChecked(Style checked) {
        this.checked = checked;
    }

    public Style getPressed() {
        return pressed;
    }

    public void setPressed(Style pressed) {
        this.pressed = pressed;
    }

    public Style getHovered() {
        return hovered;
    }

    public void setHovered(Style hovered) {
        this.hovered = hovered;
    }

}
