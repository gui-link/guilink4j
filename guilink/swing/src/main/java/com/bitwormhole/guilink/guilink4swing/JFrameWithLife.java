package com.bitwormhole.guilink.guilink4swing;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowStateListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bitwormhole.starter4j.application.Life;

/******************************************************
 * JFrameWithLife 为 JFrame 添加对 lifecycle 的支持
 */

public class JFrameWithLife extends JFrameWithLifeAbs {

    static final Logger logger = LoggerFactory.getLogger(JFrameWithLife.class);

    public JFrameWithLife() {
        this.initLife();
    }

    ////////////////////////////////////////////////////////
    /// protected

    @Override
    protected void onCreate() {
        this.logMyself("onCreate");
    }

    @Override
    protected void onStart() {
        this.logMyself("onStart");
    }

    @Override
    protected void onResume() {
        this.logMyself("onResume");
    }

    @Override
    protected void onPause() {
        this.logMyself("onPause");
    }

    @Override
    protected void onStop() {
        this.logMyself("onStop");
    }

    @Override
    protected void onDestroy() {
        this.logMyself("onDestroy");
    }

    ////////////////////////////////////////////////////////
    /// private

    private class MyWindowListener implements WindowListener, WindowFocusListener, WindowStateListener {

        @Override
        public void windowStateChanged(WindowEvent e) {
        }

        @Override
        public void windowGainedFocus(WindowEvent e) {
            JFrameWithLife.this.onResume();
        }

        @Override
        public void windowLostFocus(WindowEvent e) {
            JFrameWithLife.this.onPause();
        }

        @Override
        public void windowOpened(WindowEvent e) {
            JFrameWithLife.this.onCreate();
        }

        @Override
        public void windowClosing(WindowEvent e) {
        }

        @Override
        public void windowClosed(WindowEvent e) {
            JFrameWithLife.this.onDestroy();
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
            JFrameWithLife.this.onStart();
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            JFrameWithLife.this.onStop();
        }
    }

    private void initLife() {
        MyWindowListener l = new MyWindowListener();
        this.addWindowListener(l);
        this.addWindowFocusListener(l);
        this.addWindowStateListener(l);
    }

    private final void logMyself(String fn) {
        String cname = this.getClass().getSimpleName();
        logger.info(cname + "." + fn + "()");
    }

    @Override
    public Life life() {
        Life l = new Life();
        l.onCreate = () -> this.onCreate();
        l.onStart = () -> this.onStart();
        l.onResume = () -> this.onResume();
        l.onPause = () -> this.onPause();
        l.onStop = () -> this.onStop();
        l.onCreate = () -> this.onDestroy();
        return l;
    }

}
