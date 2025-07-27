package com.bitwormhole.guilink.guilink4swing.frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.bitwormhole.guilink.examples.The9GridsView;
import com.bitwormhole.guilink.examples.TheLinearView;
import com.bitwormhole.guilink.guilink4swing.JFrameWithLife;
import com.bitwormhole.guilink.guilink4swing.SwingCanvasAdapter;
import com.bitwormhole.guilink.layouts.LinearLayout;
import com.bitwormhole.guilink.widgets.Space;

import com.bitwormhole.starter4j.swing.FrameRegistration;
import com.bitwormhole.starter4j.swing.Goal;

public class TestingFrame1 extends JFrameWithLife {

    ////////////////////////////////////////////////////////////////////////////
    /// public

    public static TestingFrame1 create(Goal goal) {
        return new TestingFrame1(goal);
    }

    public static FrameRegistration registration() {
        FrameRegistration r = new FrameRegistration();
        r.setType(TestingFrame1.class);
        r.setFactory((g) -> create(g));
        return r;
    }

    ////////////////////////////////////////////////////////////////////////////
    /// protected

    @Override
    protected void onCreate() {
        super.onCreate();
        this.setSize(640, 480);
        this.setTitle(this.getClass().getName());

        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        SwingCanvasAdapter adapter = new SwingCanvasAdapter();
        adapter.init();
        this.setLayout(new BorderLayout());
        this.add(adapter.getComponent(), BorderLayout.CENTER);

        Space space = new Space();
        The9GridsView view1 = new The9GridsView();
        TheLinearView view2 = new TheLinearView(LinearLayout.Direction.HORIZONTAL);

        adapter.getCanvas().add(view1);

    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private TestingFrame1(Goal goal) {
    }

}
