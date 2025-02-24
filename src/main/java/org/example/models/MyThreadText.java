package org.example.models;

import org.example.controllers.MenuController;

import java.io.IOException;

public class MyThreadText extends Thread {

    private volatile boolean czyZatrzymac = false;

    private static MyThreadText instance;

    private MyThreadText() {
    }

    public static synchronized MyThreadText getInstance() {
        if (instance == null) {
            instance = new MyThreadText();
        }
        return instance;
    }

    @Override
    public void run() {
        MenuController menuController = null;
        try {
            menuController = new MenuController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
                menuController.run();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        while (!czyZatrzymac) {}
    }

    public void zatrzymaj() {
        czyZatrzymac = true;
        instance = null;
    }
}
