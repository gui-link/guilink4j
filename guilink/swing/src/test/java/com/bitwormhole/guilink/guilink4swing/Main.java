package com.bitwormhole.guilink.guilink4swing;

import java.lang.reflect.InvocationTargetException;

import com.bitwormhole.guilink.guilink4swing.frames.TestingFrame1;
import com.bitwormhole.starter4j.swing.SwingApplicationConfig;
import com.bitwormhole.starter4j.swing.SwingApplicationStarter;

public final class Main {

    public static void main(String[] args) {
        try {
            Main m = new Main();
            m.display(args);
        } catch (InvocationTargetException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void display(String[] args) throws InvocationTargetException, InterruptedException {
        SwingApplicationConfig cfg = new SwingApplicationConfig();
        cfg.setArguments(args);
        cfg.setModule(TestingModuleForGuilinkSwing.module());
        cfg.setMainFrameClass(TestingFrame1.class);
        SwingApplicationStarter.run(cfg);
    }

    private Main() {
    }

}
