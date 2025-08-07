package com.bitwormhole.guilink.graphics;

import java.io.InputStream;

public interface ImageLoader {

    Image load(InputStream data, ImageMeta meta);

}
