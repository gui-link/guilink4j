package com.bitwormhole.guilink.desktops;

import com.bitwormhole.guilink.geometries.Rect;

public interface WindowManager {

    Window[] windows();

    Desktop[] desktops();

    Window createNewWindow(Rect rect);

}
