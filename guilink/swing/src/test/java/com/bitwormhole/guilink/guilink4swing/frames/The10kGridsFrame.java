package com.bitwormhole.guilink.guilink4swing.frames;

import java.awt.BorderLayout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.guilink.canvases.Canvas;
import com.bitwormhole.guilink.examples.The10kGridsView;
import com.bitwormhole.guilink.guilink4swing.SwingCanvasAdapter;
import com.bitwormhole.guilink.layouts.SimpleLayout;
import com.bitwormhole.starter4j.swing.FrameRegistration;
import com.bitwormhole.starter4j.swing.FrameWithLife;
import com.bitwormhole.starter4j.swing.Goal;

public class The10kGridsFrame extends FrameWithLife {

    static final Logger logger = LoggerFactory.getLogger(HomeFrame.class);

    ////////////////////////////////////////////////////////////////////////////
    /// public

    public static The10kGridsFrame create(Goal goal) {
        return new The10kGridsFrame(goal);
    }

    public static FrameRegistration registration() {
        FrameRegistration r = new FrameRegistration();
        r.setType(The10kGridsFrame.class);
        r.setFactory((g) -> create(g));
        return r;
    }

    ////////////////////////////////////////////////////////////////////////////
    /// protected

    @Override
    protected void onCreate() {
        super.onCreate();
        this.setSize(1024, 768);
        this.setTitle(this.getClass().getName());
        this.setLayout(new BorderLayout());

        SwingCanvasAdapter adapter = new SwingCanvasAdapter();
        Canvas canvas = adapter.getCanvas();

        canvas.setLayout(new SimpleLayout());

        The10kGridsView view = new The10kGridsView(canvas.getContext());
        canvas.add(view);

        this.add(adapter.getComponent(), BorderLayout.CENTER);
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private The10kGridsFrame(Goal goal) {
    }
}
