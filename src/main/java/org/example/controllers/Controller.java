package org.example.controllers;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.Main;
import org.example.controllersGraphics.GController;
import org.example.controllersGraphics.GMenuController;
import org.example.models.DownloadData;

import javax.swing.*;
import java.io.IOException;

public abstract class Controller {
    protected static Terminal terminal;
    static DownloadData dataSet;
    protected static Screen screen;
    protected static MultiWindowTextGUI Gui;

    public static void addWord(String key, String value) {
        dataSet.addWord(key, value);
    }

    protected static void removeWord(String key) {
        dataSet.removeWord(key);
    }

    protected static void exitApp() throws IOException {
        try {
            screen.close();
            terminal.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSet.saveData();
        System.exit(0);
    }
    protected static void saveData() throws IOException {
        dataSet.saveData();
        screen.close();
        terminal.close();
    }
}
