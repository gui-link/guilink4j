package com.bitwormhole.guilink.boxes;

import java.util.concurrent.Executor;

import com.bitwormhole.guilink.canvases.CanvasAdapter;

public class BoxContext {

    private Executor uiExecutor;
    private Theme theme;
    private int layoutRevision;
    private int paintRevision;
    private CanvasAdapter adapter;

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

}
