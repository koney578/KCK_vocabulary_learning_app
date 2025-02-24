package org.example.controllersGraphics;
import org.example.viewsGraphics.GStudyView;

public class GStudyController extends GController{
    private GStudyView gStudyView;
    private GMenuController gMenuController;
    private GSummaryController gSummaryController;
    public GStudyController(GMenuController gMenuController){
        gStudyView = new GStudyView(this, jframe);
        this.gSummaryController = new GSummaryController(this);
        this.gMenuController = gMenuController;

    }
    public void run(){
        if(dataSet.getSizeDataNotFamiliarized() == 0){
            gSummaryController.run();
        }
        else {
            gStudyView.ShowStudy();
        }
    }
    public void getNewMenuView() {
        gMenuController.run();
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
            gSummaryController.run();
        }
    }
    public void resetData() {
        dataSet.resetData();
    }
}
