package org.example.controllersGraphics;
import org.example.models.DownloadData;

import javax.swing.*;
import java.io.IOException;

public abstract class GController {
    protected static final JFrame jframe;
    static DownloadData dataSet;

    static {
        jframe = new JFrame("Aplikacja do nauki słówek");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(800, 480);
        jframe.setLocationRelativeTo(null);
    }

    public static void addWord(String key, String value) {
        dataSet.addWord(key, value);
    }

    protected static void removeWord(String key) {
        dataSet.removeWord(key);
    }

    protected static void exitApp() {
        dataSet.saveData();
        System.exit(0);
    }

    protected static void saveData() throws IOException {
        dataSet.saveData();
        jframe.dispose();
    }
}
