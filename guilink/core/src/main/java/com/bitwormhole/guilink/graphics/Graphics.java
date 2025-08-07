package com.bitwormhole.guilink.graphics;

import com.bitwormhole.guilink.geometries.Size;

public interface Graphics {

    Context getContext();

    Graphics create();

    Graphics create(float x, float y, float width, float height);

    void drawLine(float x1, float y1, float x2, float y2);

    void drawRect(float x, float y, float width, float height);

    void fillRect(float x, float y, float width, float height);

    void drawText(String text, float x, float y);

    Size computeTextSize(String text, Font font);

    void translate(float x, float y);

    void clip(float x, float y, float width, float height);

    void setColor(Color color);

    void setStroke(Stroke stroke);

    void setFont(Font font);

}
