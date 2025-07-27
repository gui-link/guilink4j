package com.bitwormhole.guilink.graphics;

public interface ColorSpace {

    int valueOf(int v1, int v2, int v3, int v4);

    ColorSpaceTypeEnum getSpaceType();

}
