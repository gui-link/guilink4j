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
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.concurrent.Executor;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.boxes.LayoutContext;
import com.bitwormhole.guilink.boxes.LayoutSession;
import com.bitwormhole.guilink.boxes.PaintContext;
import com.bitwormhole.guilink.boxes.PaintSession;
import com.bitwormhole.guilink.boxes.Theme;
import com.bitwormhole.guilink.canvases.Canvas;
import com.bitwormhole.guilink.canvases.CanvasAdapter;
import com.bitwormhole.guilink.events.MouseEventEnum;
import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.geometries.Size;
import com.bitwormhole.guilink.themes.DefaultTheme;

public class SwingCanvasAdapter implements CanvasAdapter {

    private JComponent component;
    private Canvas canvas;

    private final BoxContext mBoxContext;
    private int mLayoutRevision;
    private int mPaintRevision;

    public SwingCanvasAdapter() {

        BoxContext bc = this.makeBoxContext();

        this.component = new JPanel();
        this.canvas = new Canvas(bc);
        this.mBoxContext = bc;

        this.init();
    }

    private BoxContext makeBoxContext() {
        BoxContext bc = new BoxContext();
        Theme theme = new DefaultTheme();
        bc.setTheme(theme);
        bc.setAdapter(this);
        bc.setUiExecutor(new MyUiExecutor());
        return bc;
    }

    private void init() {

        JComponent com = this.component;
        MyInnerView iv = new MyInnerView();
        MyInnerListener li = new MyInnerListener();

        com.setLayout(new BorderLayout());
        com.add(iv, BorderLayout.CENTER);

        iv.addMouseListener(li);
        iv.addMouseWheelListener(li);
        iv.addMouseMotionListener(li);
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

    private class MyInnerListener
            implements MouseListener, KeyListener, ComponentListener, MouseMotionListener, MouseWheelListener {

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
            e2.setEvent(MouseEventEnum.CLICKED);
            dispatchMouseEvent(e2);
        }

        @Override
        public void mousePressed(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            e2.setEvent(MouseEventEnum.PRESSED);
            dispatchMouseEvent(e2);
        }

        @Override
        public void mouseReleased(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            e2.setEvent(MouseEventEnum.RELEASED);
            dispatchMouseEvent(e2);
        }

        @Override
        public void mouseEntered(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            e2.setEvent(MouseEventEnum.ENTERED);
            dispatchMouseEvent(e2);
        }

        @Override
        public void mouseExited(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            e2.setEvent(MouseEventEnum.EXITED);
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

        @Override
        public void mouseWheelMoved(MouseWheelEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            e2.setEvent(MouseEventEnum.WHEELED);
            dispatchMouseEvent(e2);
        }

        @Override
        public void mouseDragged(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            e2.setEvent(MouseEventEnum.DRAGGED);
            dispatchMouseEvent(e2);
        }

        @Override
        public void mouseMoved(MouseEvent e1) {
            com.bitwormhole.guilink.events.MouseEvent e2;
            e2 = convertEvent(e1);
            e2.setEvent(MouseEventEnum.HOVERED);
            dispatchMouseEvent(e2);
        }
    }

    private class MyInnerView extends JPanel {

        @Override
        public void paint(Graphics g) {
            doPaint(g);
        }

    }

    private class MyUiExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            SwingUtilities.invokeLater(command);
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
        this.canvas.setContext(box_context);

        this.repaint(true);
    }

    private void doPaint(Graphics g1) {

        PaintSession session = new PaintSession();
        PaintContext pc = session.getPaintContextAt(0);
        pc.graphics = SwingGraphicsConvertor.convert((Graphics2D) g1);
        session.setBoxContext(this.mBoxContext);

        this.canvas.setContext(this.mBoxContext);
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
        int at_x = e1.getX();
        int at_y = e1.getY();
        com.bitwormhole.guilink.events.MouseEvent e2 = new com.bitwormhole.guilink.events.MouseEvent();
        e2.setLocation(new Point(at_x, at_y));
        e2.setLocationAtCanvas(new Point(at_x, at_y));
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
