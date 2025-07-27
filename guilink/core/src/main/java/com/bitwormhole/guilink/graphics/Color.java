package com.bitwormhole.guilink.graphics;

public final class Color {

    public static final Color RED = new Color(255, 0, 0, 255);
    public static final Color GREEN = new Color(0, 255, 0, 255);
    public static final Color BLUE = new Color(0, 0, 255, 255);
    public static final Color WHITE = new Color(255, 255, 255, 255);
    public static final Color BLACK = new Color(0, 0, 0, 255);
    public static final Color GRAY = new Color(128, 128, 128, 255);

    private final int value;
    private final ColorSpace space;

    public Color(int r, int g, int b, int a) {
        ColorSpace cs = getRGBAColorSpace();
        this.space = cs;
        this.value = cs.valueOf(r, g, b, a);
    }

    public int toInt32() {
        return this.value;
    }

    public ColorSpace getSpace() {
        return this.space;
    }

    public static ColorSpace getRGBAColorSpace() {
        ColorSpace cs = theRGBAColorSpace;
        if (cs == null) {
            cs = new RGBAColorSpace();
            theRGBAColorSpace = cs;
        }
        return cs;
    }

    private static ColorSpace theRGBAColorSpace;

}
