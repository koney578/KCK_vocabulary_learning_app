package org.example.controllers;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import org.example.controllersGraphics.GController;
import org.example.controllersGraphics.GMenuController;
import org.example.models.DownloadData;
import org.example.models.MyThreadGrafic;
import org.example.models.MyThreadText;
import org.example.views.MenuView;

import java.io.IOException;

public class MenuController extends Controller {
    private MenuView menuView;
    private StudyController studyController;
    private AddWordController addWordController;

    private RemoveWordController removeWordController;

    private QuizController quizController;

    public MenuController() throws IOException {
        terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(90, 30)).createTerminal();
        dataSet = new DownloadData();
        screen = new TerminalScreen(terminal);
        screen.startScreen();
        Gui = new MultiWindowTextGUI(screen);
        menuView = new MenuView(this, Gui);
        studyController = new StudyController(this);
        addWordController = new AddWordController(this);
        quizController = new QuizController(this);
        removeWordController = new RemoveWordController(this);
    }

    public void run() throws IOException {
        menuView.ShowMenu();
    }
    public void getNewStudyView() {
        studyController.run();
    }
    public void getNewAddWordView() {
        addWordController.run();
    }

    public void getNewTestView() {
        quizController.run();
    }
    public void getNewRemoveWordView() {
        removeWordController.run();
    }
    public static void exitApp() throws IOException {
        Controller.exitApp();
    }

    public static void runGrafic() throws IOException {
        Controller.saveData();
        MyThreadText myThreadText = MyThreadText.getInstance();
        myThreadText.interrupt();
        myThreadText.zatrzymaj();
        MyThreadGrafic myThreadGrafic = MyThreadGrafic.getInstance();
        myThreadGrafic.start();
    }
}
