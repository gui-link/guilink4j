package com.bitwormhole.guilink.desktops;

public class WindowContext {

    private WindowManager windowManager;
    private WindowSystem windowSystem;
    private WindowSystemImplementation windowSystemImplementation;

    public WindowContext() {
    }

    public WindowManager getWindowManager() {
        return windowManager;
    }

    public void setWindowManager(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    public WindowSystem getWindowSystem() {
        return windowSystem;
    }

    public void setWindowSystem(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
    }

    public WindowSystemImplementation getWindowSystemImplementation() {
        return windowSystemImplementation;
    }

    public void setWindowSystemImplementation(WindowSystemImplementation windowSystemImplementation) {
        this.windowSystemImplementation = windowSystemImplementation;
    }

}
