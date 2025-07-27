package com.bitwormhole.guilink.graphics;

public class RGBAColorSpace implements ColorSpace {

    @Override
    public int valueOf(int r, int g, int b, int a) {
        int n = 0;
        n = (n << 8) | (0x00ff & a);
        n = (n << 8) | (0x00ff & r);
        n = (n << 8) | (0x00ff & g);
        n = (n << 8) | (0x00ff & b);
        return n;
    }

    @Override
    public ColorSpaceTypeEnum getSpaceType() {
        return ColorSpaceTypeEnum.RGBA;
    }

}
