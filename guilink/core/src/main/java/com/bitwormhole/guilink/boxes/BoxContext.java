package com.bitwormhole.guilink.boxes;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.guilink.canvases.CanvasAdapter;

public class BoxContext {

    static final Logger logger = LoggerFactory.getLogger(BoxContext.class);

    private Theme theme;
    private Executor uiExecutor;
    private CanvasAdapter adapter;

    private Box currentHovering;
    private Box currentDragging;
    private Box currentPressed;

    private int layoutRevision;
    private int paintRevision;

    public BoxContext() {
    }

    public Executor getUiExecutor() {
        return uiExecutor;
    }

    public void setUiExecutor(Executor uiExecutor) {
        this.uiExecutor = uiExecutor;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public int getLayoutRevision() {
        return layoutRevision;
    }

    public void setLayoutRevision(int layoutRevision) {
        this.layoutRevision = layoutRevision;
    }

    public int getPaintRevision() {
        return paintRevision;
    }

    public void setPaintRevision(int paintRevision) {
        this.paintRevision = paintRevision;
    }

    public void requestUpdateLayout() {
        this.layoutRevision++;
    }

    public void requestRepaint() {
        this.paintRevision++;
    }

    public CanvasAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(CanvasAdapter adapter) {
        this.adapter = adapter;
    }

    public Box getCurrentHovering() {
        return currentHovering;
    }

    public void setCurrentHovering(Box currentHovering) {
        this.currentHovering = currentHovering;
    }

    public Box getCurrentDragging() {
        return currentDragging;
    }

    public void setCurrentDragging(Box currentDragging) {
        this.currentDragging = currentDragging;
    }

    public Box getCurrentPressed() {
        return currentPressed;
    }

    public void setCurrentPressed(Box currentPressed) {
        this.currentPressed = currentPressed;
    }

}
