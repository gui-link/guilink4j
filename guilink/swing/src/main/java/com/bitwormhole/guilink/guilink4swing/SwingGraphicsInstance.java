package com.bitwormhole.guilink.guilink4swing;

import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.graphics.Color;
import com.bitwormhole.guilink.graphics.Font;
import com.bitwormhole.guilink.graphics.Graphics;
import com.bitwormhole.guilink.graphics.Stroke;

// import com.bitwormhole.guilink.utils.GuilinkGetters;

public class SwingGraphicsInstance implements com.bitwormhole.guilink.graphics.Graphics {

    static final Logger logger = LoggerFactory.getLogger(SwingGraphicsInstance.class);

    // private final SwingGraphicsContext context1;
    // private final SwingGraphicsContext context2;
    // private final MyParamsChecker checker;

    private Graphics2D mG2d;
    private FontRenderContext mFontRenderContext;

    public SwingGraphicsInstance(Graphics2D g2d) {

        // this.context1 = new SwingGraphicsContext();
        // this.context2 = new SwingGraphicsContext();
        // this.checker = new MyParamsChecker();

        // this.context1.graphics2d = g2d;
        // this.context2.graphics2d = g2d;

        this.mG2d = g2d;
    }

    @Override
    public Graphics create() {

        this.logAuto("create(0)");

        Graphics2D g2 = (Graphics2D) this.mG2d.create();
        return new SwingGraphicsInstance(g2);
    }

    @Override
    public Graphics create(float x, float y, float width, float height) {

        this.logAuto("create(4)");

        Graphics2D g1 = this.mG2d;
        Graphics2D g2 = (Graphics2D) g1.create((int) x, (int) y, (int) width, (int) height);
        return new SwingGraphicsInstance(g2);
    }

    @Override
    public void clip(float x, float y, float width, float height) {

        this.logAuto("clip");

        this.mG2d.clipRect((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public void translate(float x, float y) {

        this.logAuto("translate");

        this.mG2d.translate(x, y);
    }

    @Override
    public void drawLine(float x1, float y1, float x2, float y2) {

        this.logAuto("drawLine");
        // this.checker.checkColor().checkStroke();

        this.mG2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    }

    @Override
    public void drawRect(float x, float y, float width, float height) {

        this.logAuto("drawRect");
        // this.checker.checkColor();

        this.mG2d.drawRect((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public void drawText(String text, float x, float y) {

        this.logAuto("drawText");
        // this.checker.checkColor().checkFont();

        this.mG2d.drawString(text, x, y);
    }

    @Override
    public void fillRect(float x, float y, float width, float height) {

        this.logAuto("fillRect");
        // this.checker.checkColor();

        this.mG2d.fillRect((int) x, (int) y, (int) width, (int) height);
    }

    private void logAuto(String fn) {
        String name = this.getClass().getSimpleName();
        logger.info(name + "." + fn + "()");
    }

    // private class MyParamsChecker {

    // MyParamsChecker checkColor() {
    // final SwingGraphicsInstance inst = SwingGraphicsInstance.this;
    // Color c1 = inst.context1.color;
    // Color c2 = inst.context2.color;
    // if (c1 == null) {
    // return this;
    // }
    // if (c1 != c2) {
    // inst.context2.color = c2 = c1;
    // java.awt.Color c3 = SwingGraphicsConvertor.convert(c2);
    // inst.context1.graphics2d.setColor(c3);
    // }
    // return this;
    // }

    // MyParamsChecker checkFont() {
    // final SwingGraphicsInstance inst = SwingGraphicsInstance.this;
    // com.bitwormhole.guilink.graphics.Font f1 = inst.context1.font;
    // com.bitwormhole.guilink.graphics.Font f2 = inst.context2.font;
    // if (f1 == null) {
    // return this;
    // }
    // if (f1 != f2) {
    // inst.context2.font = f2 = f1;
    // java.awt.Font f3 = SwingGraphicsConvertor.convert(f2);
    // inst.context1.graphics2d.setFont(f3);
    // }
    // return this;
    // }

    // MyParamsChecker checkStroke() {
    // return this;
    // }

    // // MyParamsChecker checkPaint() {
    // // return this;
    // // }

    // }

    @Override
    public Size computeTextSize(String text) {

        // this.checker.checkFont();

        FontRenderContext frc = this.mFontRenderContext;
        if (frc == null) {
            frc = new FontRenderContext(null, true, false);
            this.mFontRenderContext = frc;
        }
        Rectangle2D bounds = this.mG2d.getFont().getStringBounds(text, frc);
        Size size = new Size();
        size.width = (float) bounds.getWidth();
        size.height = (float) bounds.getHeight();
        return size;
    }

    @Override
    public void setColor(Color color) {
        if (color == null) {
            return;
        }
        this.logAuto("setColor");
        java.awt.Color c2 = SwingGraphicsConvertor.convert(color);
        this.mG2d.setColor(c2);
    }

    @Override
    public void setStroke(Stroke stroke) {
        if (stroke == null) {
            return;
        }
        this.logAuto("setStroke");
        java.awt.Stroke s2 = SwingGraphicsConvertor.convert(stroke);
        this.mG2d.setStroke(s2);
    }

    @Override
    public void setFont(Font font) {
        if (font == null) {
            return;
        }
        this.logAuto("setFont");
        java.awt.Font font2 = SwingGraphicsConvertor.convert(font);
        this.mG2d.setFont(font2);
    }

}
