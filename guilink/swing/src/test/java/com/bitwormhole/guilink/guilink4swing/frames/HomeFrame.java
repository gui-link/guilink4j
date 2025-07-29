package com.bitwormhole.guilink.guilink4swing.frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.bitwormhole.guilink.examples.TheHomeView;
import com.bitwormhole.guilink.guilink4swing.JFrameWithLife;
import com.bitwormhole.guilink.guilink4swing.SwingCanvasAdapter;
import com.bitwormhole.starter4j.swing.FrameRegistration;
import com.bitwormhole.starter4j.swing.Goal;

public class HomeFrame extends JFrameWithLife {

    ////////////////////////////////////////////////////////////////////////////
    /// public

    public static HomeFrame create(Goal goal) {
        return new HomeFrame(goal);
    }

    public static FrameRegistration registration() {
        FrameRegistration r = new FrameRegistration();
        r.setType(HomeFrame.class);
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingCanvasAdapter adapter = new SwingCanvasAdapter();
        adapter.init();
        this.setLayout(new BorderLayout());
        this.add(adapter.getComponent(), BorderLayout.CENTER);

        TheHomeView view = new TheHomeView();
        adapter.getCanvas().add(view);
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private HomeFrame(Goal goal) {
    }

}
