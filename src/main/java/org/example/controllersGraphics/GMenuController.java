package org.example.controllersGraphics;

import org.example.controllers.MenuController;
import org.example.models.DownloadData;
import org.example.models.MyThreadGrafic;
import org.example.models.MyThreadText;
import org.example.viewsGraphics.GMenuView;

import java.io.IOException;

public class GMenuController extends GController{
    private GMenuView gMenuView;
    private GStudyController gStudyController;
    private GAddWordController gAddWordController;
    private GRemoveWordController gRemoveWordController;

    private GQuizController gQuizController;

    public GMenuController(){
        dataSet = new DownloadData();
        gMenuView = new GMenuView(this, jframe);
        gStudyController = new GStudyController(this);
        gAddWordController = new GAddWordController(this);
        gQuizController = new GQuizController(this);
        gRemoveWordController = new GRemoveWordController(this);
    }
    public void run() {
        gMenuView.ShowMenu();
    }

    public void getNewStudyView() {
        gStudyController.run();
    }

    public void getNewAddWordView() {
        gAddWordController.run();
    }

    public void getNewRemoveWordView() {
        gRemoveWordController.run();
    }

    public void getNewTestView() {
        gQuizController.run();
    }

    public static void exitApp() {
        GController.exitApp();
    }

    public static void runText() throws IOException {
        GController.saveData();
        MyThreadGrafic myThreadGrafic = MyThreadGrafic.getInstance();
        myThreadGrafic.interrupt();
        myThreadGrafic.stopThread();
        MyThreadText myThreadText = MyThreadText.getInstance();
        myThreadText.start();
    }
}
