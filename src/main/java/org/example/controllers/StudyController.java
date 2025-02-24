package org.example.controllers;
import org.example.views.StudyView;

import java.io.IOException;

public class StudyController extends Controller{
    private StudyView studyView;
    private MenuController menuController;
    private SummaryController summaryController;
    public StudyController(MenuController menuController){
        studyView = new StudyView(this, Gui);
        this.summaryController = new SummaryController(this);
        this.menuController = menuController;
    }
    public void run(){
        if(dataSet.getSizeDataNotFamiliarized() == 0){
            summaryController.run();
        }
        else {
            studyView.ShowStudy();
        }
    }
    public void getNewMenuView() throws IOException {
        menuController.run();
    }
    public String getDrawnKeyNotFamiliarized() {
        return dataSet.drawLotsKeyNotFamiliarized();
    }
    public String getDrawnValue(String key) {
        return dataSet.getValue(key);
    }

    public String howManyFamiliarized(){
        return dataSet.howManyFamiliarized();
    }

    public String getSizeData() {
        return dataSet.getSizeData();
    }
    public void removeField(String drawnKey) {
        if(dataSet.getSizeDataNotFamiliarized() > 1){
            dataSet.removeField(drawnKey);
            this.run();
        }
        else if(dataSet.getSizeDataNotFamiliarized() == 1){
            dataSet.removeField(drawnKey);
            summaryController.run();
        }
    }
    public void resetData() {
        dataSet.resetData();
    }
}
