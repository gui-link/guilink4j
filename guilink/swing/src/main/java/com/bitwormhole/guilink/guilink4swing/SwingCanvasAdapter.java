package com.bitwormhole.guilink.guilink4swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.boxes.LayoutContext;
import com.bitwormhole.guilink.boxes.LayoutSession;
import com.bitwormhole.guilink.boxes.PaintContext;
import com.bitwormhole.guilink.boxes.PaintSession;
import com.bitwormhole.guilink.canvases.Canvas;
import com.bitwormhole.guilink.canvases.CanvasAdapter;
import com.bitwormhole.guilink.geometries.Size;

public class SwingCanvasAdapter implements CanvasAdapter {

    private JComponent component;
    private Canvas canvas;

    private final BoxContext mBoxContext;
    private int mLayoutRevision;
    private int mPaintRevision;

    // private SwingGraphicsImplementation implementation;

    public SwingCanvasAdapter() {

        // this.implementation = SwingGraphicsImplementation.getInstance();

        this.component = new JPanel();
        this.canvas = new Canvas();
        this.mBoxContext = new BoxContext();
    }

    public void init() {

        JComponent com = this.component;
        MyInnerView iv = new MyInnerView();
        MyInnerListener li = new MyInnerListener();

        com.setLayout(new BorderLayout());
        com.add(iv, BorderLayout.CENTER);

        iv.addMouseListener(li);
        iv.addKeyListener(li);
        iv.addComponentListener(li);
    }

    @Override
    public Canvas canvas() {
        return this.canvas;
    }

    public JComponent getComponent() {
        return component;
    }

    public void setComponent(JComponent component) {
        this.component = component;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private class MyInnerListener implements MouseListener, KeyListener, ComponentListener {

        @Override
        public void keyTyped(KeyEvent e1) {
            com.bitwormhole.guilink.events.KeyEvent e2;
            e2 = convertEvent(e1);
            dispatchKeyEvent(e2);
        }

        @Override
        public void keyPressed(KeyEvent e1) {
            com.bitwormhole.guilink.events.KeyEvent e2;
            e2 = convertEvent(e1);
            dispatchKeyEvent(e2);
        }

        @Override
        public void keyReleased(KeyEvent e1) {
            com.bitwormhole.guilink.events.KeyEvent e2;
            e2 = convertEvent(e1);
            dispatchKeyEvent(e2);
        }

        @Override
        public void mouseClicked(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            dispatchMouseEvent(e2);
        }

        @Override
        public void mousePressed(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            dispatchMouseEvent(e2);
        }

        @Override
        public void mouseReleased(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            dispatchMouseEvent(e2);
        }

        @Override
        public void mouseEntered(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            dispatchMouseEvent(e2);
        }

        @Override
        public void mouseExited(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            dispatchMouseEvent(e2);
        }

        @Override
        public void componentResized(ComponentEvent e) {
            Dimension size = e.getComponent().getSize();
            doLayout(size);
        }

        @Override
        public void componentMoved(ComponentEvent e) {

        }

        @Override
        public void componentShown(ComponentEvent e) {

        }

        @Override
        public void componentHidden(ComponentEvent e) {

        }
    }

    private class MyInnerView extends JPanel {

        @Override
        public void paint(Graphics g) {
            doPaint(g);
        }

    }

    private void doLayout(Dimension size1) {

        LayoutSession session = new LayoutSession();
        LayoutContext lc = session.getLayoutContextAt(0);
        BoxContext box_context = this.mBoxContext;
        Size size2 = SwingGraphicsConvertor.convert(size1);

        session.setBoxContext(box_context);

        this.canvas.setSize(size2);
        this.canvas.updateLayout(lc);

        this.repaint(true);
    }

    private void doPaint(Graphics g1) {

        PaintSession session = new PaintSession();
        PaintContext pc = session.getPaintContextAt(0);
        pc.graphics = SwingGraphicsConvertor.convert((Graphics2D) g1);

        this.canvas.paint(pc);
    }

    private void dispatchMouseEvent(com.bitwormhole.guilink.events.MouseEvent e) {
        this.canvas.handleMouseEvent(e);
    }

    private void dispatchKeyEvent(com.bitwormhole.guilink.events.KeyEvent event) {
        this.canvas.handleKeyEvent(event);
    }

    private static com.bitwormhole.guilink.events.KeyEvent convertEvent(java.awt.event.KeyEvent e1) {

        com.bitwormhole.guilink.events.KeyEvent e2 = new com.bitwormhole.guilink.events.KeyEvent();
        return e2;

    }

    private static com.bitwormhole.guilink.events.MouseEvent convertEvent(java.awt.event.MouseEvent e1) {
        com.bitwormhole.guilink.events.MouseEvent e2 = new com.bitwormhole.guilink.events.MouseEvent();
        return e2;
    }

    @Override
    public void updateLayout(boolean force) {

        final int r1 = this.mLayoutRevision;
        final int r2 = this.mBoxContext.getLayoutRevision();

        if (!force) {
            if (r1 == r2) {
                return;
            }
        }

        Dimension size1 = this.component.getSize();
        this.mLayoutRevision = r2;
        this.doLayout(size1);
    }

    @Override
    public void repaint(boolean force) {

        final int r1 = this.mPaintRevision;
        final int r2 = this.mBoxContext.getPaintRevision();

        if (!force) {
            if (r1 == r2) {
                return;
            }
        }

        this.mPaintRevision = r2;
        this.component.repaint();
    }

}
