package com.bitwormhole.guilink.graphics;

public final class Color {

    public static final Color RED = new Color(255, 0, 0, 255);
    public static final Color GREEN = new Color(0, 255, 0, 255);
    public static final Color BLUE = new Color(0, 0, 255, 255);
    public static final Color WHITE = new Color(255, 255, 255, 255);
    public static final Color BLACK = new Color(0, 0, 0, 255);

    public static final Color GRAY = makeGray(128);
    public static final Color GRAY1 = makeGray(59);
    public static final Color GRAY2 = makeGray(69);
    public static final Color GRAY3 = makeGray(82);
    public static final Color GRAY4 = makeGray(96);
    public static final Color GRAY5 = makeGray(113);
    public static final Color GRAY6 = makeGray(133);
    public static final Color GRAY7 = makeGray(157);
    public static final Color GRAY8 = makeGray(185);
    public static final Color GRAY9 = makeGray(217);

    private final int value;
    private final ColorSpace space;

    public Color(int r, int g, int b, int a) {
        ColorSpace cs = getRGBAColorSpace();
        this.space = cs;
        this.value = cs.valueOf(r, g, b, a);
    }

    public Color(int r, int g, int b) {
        ColorSpace cs = getRGBAColorSpace();
        int a = 255;
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

    private static Color makeGray(int value) {
        return new Color(value, value, value, 255);
    }

}
