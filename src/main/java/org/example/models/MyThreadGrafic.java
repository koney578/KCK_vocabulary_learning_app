package org.example.models;

import org.example.controllersGraphics.GMenuController;

public class MyThreadGrafic extends Thread {

    private volatile boolean shouldStop = false;

    private static MyThreadGrafic instance;

    private MyThreadGrafic() {
    }

    public static synchronized MyThreadGrafic getInstance() {
        if (instance == null || !instance.isAlive()) {
            instance = new MyThreadGrafic();
        }
        return instance;
    }

    @Override
    public void run() {
        GMenuController gMenuController = new GMenuController();
        gMenuController.run();
        while (!shouldStop) {}
    }

    public void stopThread() {
        shouldStop = true;
        instance = null;
    }
}
