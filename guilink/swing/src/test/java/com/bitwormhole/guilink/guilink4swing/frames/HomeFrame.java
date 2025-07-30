package com.bitwormhole.guilink.guilink4swing.frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.guilink.boxes.BoxContext;
import com.bitwormhole.guilink.events.MouseEvent;
import com.bitwormhole.guilink.events.MouseEventEnum;
import com.bitwormhole.guilink.events.MouseEventListener;
import com.bitwormhole.guilink.events.MouseEventProxy;
import com.bitwormhole.guilink.examples.TheHomeView;
import com.bitwormhole.guilink.geometries.Point;
import com.bitwormhole.guilink.guilink4swing.JFrameWithLife;
import com.bitwormhole.guilink.guilink4swing.SwingCanvasAdapter;
import com.bitwormhole.guilink.widgets.Button;
import com.bitwormhole.starter4j.application.ApplicationContext;
import com.bitwormhole.starter4j.application.components.ComponentSelector;
import com.bitwormhole.starter4j.swing.FrameManager;
import com.bitwormhole.starter4j.swing.FrameRegistration;
import com.bitwormhole.starter4j.swing.FrameWithLife;
import com.bitwormhole.starter4j.swing.Goal;

public class HomeFrame extends JFrameWithLife {

    static final Logger logger = LoggerFactory.getLogger(HomeFrame.class);

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
        BoxContext bc = adapter.getCanvas().getContext();

        this.setLayout(new BorderLayout());
        this.add(adapter.getComponent(), BorderLayout.CENTER);

        TheHomeView view = new TheHomeView(bc);
        adapter.getCanvas().add(view);

        this.setupButton(view, "foo", (e1) -> this.onClickFoo(e1));
        this.setupButton(view, "bar", (e1) -> this.onClickBar(e1));
        this.setupButton(view, "333", (e) -> this.onClickBar(e));

        this.setupButton(view, null, The10kGridsFrame.class);

    }

    private void onClickFoo(MouseEvent event) {
        if (!MouseEventEnum.CLICKED.equals(event.getEvent())) {
            return;
        }

        logger.info("" + event);
    }

    private void onClickBar(MouseEvent event) {
        if (!MouseEventEnum.CLICKED.equals(event.getEvent())) {
            return;
        }
        Point pt1 = event.getLocation();
        Point pt2 = event.getLocationAtCanvas();
        logger.info(".onClickBar(), location=" + pt1 + ", location@canvas=" + pt2);
    }

    private void setupButton(TheHomeView home, String text, Class<? extends FrameWithLife> frame_class) {
        if (text == null) {
            text = frame_class.getSimpleName();
        }
        MouseEventListener li1 = (e) -> {
            Goal g2 = new Goal();
            g2.setContext(mGoal.getContext());
            g2.setFrameClass(frame_class);
            mFrameManager.show(g2);
        };
        MouseEventListener li2 = MouseEventProxy.proxy().setOnMouseClicked(li1);
        this.setupButton(home, text, li2);
    }

    private void setupButton(TheHomeView home, String text, MouseEventListener li) {

        MouseEventListener li2 = MouseEventProxy.proxy().setOnMouseClicked(li);

        BoxContext ctx = home.getContext();
        Button btn = new Button(ctx, text);
        btn.addMouseEventListener(li2);
        btn.setWeight(2);
        home.addButton(btn);
    }

    ////////////////////////////////////////////////////////////////////////////
    /// private

    private final Goal mGoal;
    private FrameManager mFrameManager;

    private HomeFrame(Goal goal) {
        this.mGoal = goal;
        this.mFrameManager = innerGetFrameManager(goal);
    }

    private static FrameManager innerGetFrameManager(Goal goal) {
        ApplicationContext ctx = goal.getContext();
        String sel = ComponentSelector.getInstance().ID(FrameManager.class);
        return ctx.selectComponent(sel, FrameManager.class);
    }

}
