package com.bitwormhole.guilink.boxes;

import com.bitwormhole.guilink.graphics.Color;

public class DefaultValueStyle extends StyleWrapper {

    public DefaultValueStyle() {
        super(null);
    }

    public DefaultValueStyle(Style in) {
        super(in);
    }

    @Override
    public Color getBorderBottomColor() {
        Color v1 = super.getBorderBottomColor();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderColor();
    }

    @Override
    public LineStyleEnum getBorderBottomStyle() {
        LineStyleEnum v1 = super.getBorderBottomStyle();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderStyle();
    }

    @Override
    public Float getBorderBottomWidth() {
        Float v1 = super.getBorderBottomWidth();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderWidth();
    }

    @Override
    public Color getBorderLeftColor() {
        Color v1 = super.getBorderLeftColor();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderColor();
    }

    @Override
    public LineStyleEnum getBorderLeftStyle() {
        LineStyleEnum v1 = super.getBorderLeftStyle();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderStyle();
    }

    @Override
    public Float getBorderLeftWidth() {
        Float v1 = super.getBorderLeftWidth();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderWidth();
    }

    @Override
    public Color getBorderRightColor() {
        Color v1 = super.getBorderRightColor();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderColor();
    }

    @Override
    public LineStyleEnum getBorderRightStyle() {
        LineStyleEnum v1 = super.getBorderRightStyle();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderStyle();
    }

    @Override
    public Float getBorderRightWidth() {
        Float v1 = super.getBorderRightWidth();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderWidth();
    }

    @Override
    public Color getBorderTopColor() {
        Color v1 = super.getBorderTopColor();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderColor();
    }

    @Override
    public LineStyleEnum getBorderTopStyle() {
        LineStyleEnum v1 = super.getBorderTopStyle();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderStyle();
    }

    @Override
    public Float getBorderTopWidth() {
        Float v1 = super.getBorderTopWidth();
        if (v1 != null) {
            return v1;
        }
        return super.getBorderWidth();
    }

    @Override
    public Float getPaddingBottom() {
        Float v1 = super.getPaddingBottom();
        if (v1 != null) {
            return v1;
        }
        return super.getPadding();
    }

    @Override
    public Float getPaddingLeft() {
        Float v1 = super.getPaddingLeft();
        if (v1 != null) {
            return v1;
        }
        return super.getPadding();
    }

    @Override
    public Float getPaddingRight() {
        Float v1 = super.getPaddingRight();
        if (v1 != null) {
            return v1;
        }
        return super.getPadding();
    }

    @Override
    public Float getPaddingTop() {
        Float v1 = super.getPaddingTop();
        if (v1 != null) {
            return v1;
        }
        return super.getPadding();
    }

}
