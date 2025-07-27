package com.bitwormhole.guilink.guilink4swing;

import javax.swing.JFrame;

import com.bitwormhole.starter4j.application.LifeCycle;

public abstract class JFrameWithLifeAbs extends JFrame implements LifeCycle {

    protected abstract void onCreate();

    protected abstract void onStart();

    protected abstract void onResume();

    protected abstract void onPause();

    protected abstract void onStop();

    protected abstract void onDestroy();

}
