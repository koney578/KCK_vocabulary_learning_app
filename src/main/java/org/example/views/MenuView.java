package org.example.views;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import org.example.controllers.MenuController;

import java.io.IOException;
import java.util.Arrays;

public class MenuView {
    private MenuController menuController;
    private MultiWindowTextGUI Gui;
    public MenuView(MenuController menuController, MultiWindowTextGUI Gui){
        this.menuController = menuController;
        this.Gui = Gui;
    }
    public void ShowMenu() throws IOException {
        Gui.removeWindow(Gui.getActiveWindow());
        Gui.updateScreen();
        BasicWindow menuWindow = new BasicWindow();
        Panel panel = new Panel();
        panel.setPreferredSize(new TerminalSize(85, 25));

        Label label1 = new Label("Witaj w aplikacji do nauki angielskich słówek!");
        label1.addStyle(SGR.BOLD);
        panel.addComponent(label1);

        Label label2 = new Label("Co chcesz robic?");
        label2.addStyle(SGR.BOLD);
        panel.addComponent(label2);

        Label label3= new Label("");
        panel.addComponent(label3);

        Button buttonFirst = new Button("Chcę się uczyć! (Fiszki)", new Runnable() {
            @Override
            public void run() {
                menuController.getNewStudyView();
            }
        });

        Button buttonSecond = new Button("Chcę dodać nowe słowo do słownika!", new Runnable() {
            @Override
            public void run() {menuController.getNewAddWordView();}
        });

        Button buttonThird = new Button("Chcę usunąć słowo ze słownika!", new Runnable() {
            @Override
            public void run() {menuController.getNewRemoveWordView();}
        });

        Button buttonFourth = new Button("Chcę sprawdzić swoją wiedzę! (Test - 5 słów)", new Runnable() {
            @Override
            public void run() {menuController.getNewTestView();}
        });

        Button buttonFifth = new Button("Nie chcę już się uczyć! (Wyjście)", new Runnable() {
            @Override
            public void run() {
                try {
                    menuController.exitApp();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Button buttonSixth = new Button("Przełącz na tryb graficzny", new Runnable() {
            @Override
            public void run() {
                try {
                    menuController.runGrafic();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        panel.addComponent(buttonFirst);
        panel.addComponent(buttonSecond);
        panel.addComponent(buttonThird);
        panel.addComponent(buttonFourth);
        panel.addComponent(buttonFifth);
        panel.addComponent(buttonSixth);
        menuWindow.setComponent(panel);
        menuWindow.setHints(Arrays.asList(Window.Hint.CENTERED));
        Gui.addWindowAndWait(menuWindow);
    }
}
