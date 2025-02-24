package org.example.controllers;
import org.example.views.SummaryView;

import java.io.IOException;

public class SummaryController extends Controller {
    private SummaryView summaryView;
    private StudyController studyController;

    public SummaryController(StudyController studyController){
        summaryView = new SummaryView(this, Gui);
        this.studyController = studyController;
    }
    public void run() {
        summaryView.ShowSumarry();
    }

    public void getNewMenuView() throws IOException {
        studyController.getNewMenuView();
    }

    public String sizeData() {
        return dataSet.getSizeData();
    }

    public void resetData() {
        studyController.resetData();
    }
    public void getNewStudyView() {
        studyController.run();
    }
}
