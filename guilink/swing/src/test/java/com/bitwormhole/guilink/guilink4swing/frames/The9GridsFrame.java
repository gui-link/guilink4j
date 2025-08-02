package com.bitwormhole.guilink.guilink4swing.frames;

import java.awt.BorderLayout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.canvases.Canvas;
import com.bitwormhole.guilink.examples.The9GridsView;
import com.bitwormhole.guilink.guilink4swing.SwingCanvasAdapter;
import com.bitwormhole.starter4j.swing.FrameRegistration;
import com.bitwormhole.starter4j.swing.FrameWithLife;
import com.bitwormhole.starter4j.swing.Goal;

public class The9GridsFrame extends FrameWithLife {

    static final Logger logger = LoggerFactory.getLogger(HomeFrame.class);

    ////////////////////////////////////////////////////////////////////////////
    /// public

    public static The9GridsFrame create(Goal goal) {
        return new The9GridsFrame(goal);
    }

    public static FrameRegistration registration() {
        FrameRegistration r = new FrameRegistration();
        r.setType(The9GridsFrame.class);
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
        BoxContext bc = canvas.getContext();
        The9GridsView view = new The9GridsView(bc);
        canvas.add(view);

        this.add(adapter.getComponent());
    }

    private The9GridsFrame(Goal goal) {
    }
}
